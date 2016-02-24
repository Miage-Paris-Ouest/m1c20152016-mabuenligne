package com.example.alex.onlinebu;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import XML.XMLParser;
import livre.Livre;

/**
 * Created by Alex on 18/02/2016.
 */
public class EmpruntsXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emprunt_xml);
        String user =  this.getIntent().getStringExtra("USER");
        TextView textUser = (TextView)findViewById(R.id.textViewEmprunts);

        textUser.setText("Emprunts de " + user);
        XMLParser XMl = new XMLParser();
        Livre livre = new Livre();
        InputStream inputStream = getResources().openRawResource(R.raw.livre);
        //InputStreamReader ipsr = new InputStreamReader(inputStream);
        //BufferedReader br = new BufferedReader(ipsr);
        try {
            livre=XMl.parse(inputStream);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView livreUser = (TextView)findViewById(R.id.Livre);
        livreUser.setText(livre.toString());

        textUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(EmpruntsXML.this);
                builder.setMessage("Saisir la durée avant déclenchement (en sec)");
                builder.setTitle("PARAMETRER UNE ALERTE");

                final EditText dureeChoisie = new EditText(EmpruntsXML.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                dureeChoisie.setLayoutParams(lp);
                builder.setView(dureeChoisie);

                builder.setPositiveButton("Valider l'alerte",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                String dureeAlerte = dureeChoisie.getText().toString();
                                int duree = Integer.parseInt(dureeAlerte);
                                Intent intent = new Intent(EmpruntsXML.this, TimerNotif.class);

                                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);

                                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * duree), pendingIntent);
                            }

                        });
                builder.show();
            }
        });

        textUser.setOnLongClickListener(new View.OnLongClickListener()
                                        {
                                            @Override
                                            public boolean onLongClick(View v)
                                            {
                                                AlertDialog.Builder builderPenalite = new AlertDialog.Builder(EmpruntsXML.this);
                                                builderPenalite.setMessage("Pénalités sur les emprunts en retard");
                                                builderPenalite.setTitle("VOIR MES PENALITES");

                                                builderPenalite.setPositiveButton("OK",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int whichButton)
                                                            {
                                                                Intent intent = new Intent(EmpruntsXML.this, Penalites.class);
                                                                startActivity(intent);
                                                            }

                                                        });

                                                builderPenalite.setNegativeButton("Annuler",
                                                        new DialogInterface.OnClickListener() {

                                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                            }

                                                        });

                                                builderPenalite.show();
                                                return false;
                                            }
                                        }
        );



    }
}
