package com.example.alex.onlinebu;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import XML.XMLParser;
import livre.Livre;

public class Emprunts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprunts);

        String user =  this.getIntent().getStringExtra("USER");
        TextView textUser = (TextView)findViewById(R.id.textViewEmprunts);
        ListView listEmprunts = (ListView)findViewById(R.id.listViewEmprunts);

        textUser.setText("Emprunts de " + user);
        InputStream inputStream = getResources().openRawResource(R.raw.emprunts);
        InputStreamReader ipsr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(ipsr);

        String[] emprunt = new String[0];

        String ligne;
        try {
            while ((ligne = br.readLine()) != null)
            {
                String[] emprunt2 = emprunt;
                int taille = emprunt2.length;
                emprunt = new String[taille+1];
                System.arraycopy(emprunt2, 0, emprunt,0, taille);
                emprunt[taille] = ligne;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emprunt);
            listEmprunts.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        String[] emprunts = {"Livre: Les misérables\n Date Emprunt: 01/01/2016\n Date Retour: 01/03/2016",
                                    "Livre: Langage C\n Date Emprunt: 10/02/2016\n Date Retour: 21/03/2016",
                                    "Livre: Les Ressources Humaines\n Date Emprunt: 15/02/2016\n Date Retour: 19/04/2016"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emprunts);
        ListView listEmprunts = (ListView)findViewById(R.id.listViewEmprunts);
        listEmprunts.setAdapter(adapter);*/


        listEmprunts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView,
                                           View view,
                                           int position,
                                           long id) {

                AlertDialog.Builder builderPenalite = new AlertDialog.Builder(Emprunts.this);
                builderPenalite.setMessage("Pénalités sur les emprunts en retard");
                builderPenalite.setTitle("VOIR MES PENALITES");

                builderPenalite.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {
                                Intent intent = new Intent(Emprunts.this, Penalites.class);
                                startActivity(intent);

                            }

                        });

                builderPenalite.setNegativeButton("Annuler",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                            }

                        });

                builderPenalite.show();

                return true;
            }
        });

        listEmprunts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Emprunts.this);
                builder.setMessage("Saisir la durée avant déclenchement (en sec)");
                builder.setTitle("PARAMETRER UNE ALERTE");

                final EditText dureeChoisie = new EditText(Emprunts.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                dureeChoisie.setLayoutParams(lp);
                builder.setView(dureeChoisie);

                builder.setPositiveButton("Valider l'alerte",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                String dureeAlerte = dureeChoisie.getText().toString();
                                int duree =Integer.parseInt(dureeAlerte);
                                Intent intent = new Intent(Emprunts.this, TimerNotif.class);

                                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1,intent, PendingIntent.FLAG_ONE_SHOT);

                                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * duree), pendingIntent);
                            }

                        });
                builder.show();


            }
        });

    }


}