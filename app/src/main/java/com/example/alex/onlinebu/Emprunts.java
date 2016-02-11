package com.example.alex.onlinebu;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Emprunts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprunts);

        String user =  this.getIntent().getStringExtra("USER");
        TextView textUser = (TextView)findViewById(R.id.textViewEmprunts);

        textUser.setText("Emprunts de " + user);

        /*
        InputStream inputStream = getResources().openRawResource(R.raw.emprunts);
        InputStreamReader ipsr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(ipsr);

        String ligne;
        try {
            while ((ligne = br.readLine()) != null)
            {
                String[] data = ligne.split(";");

                for (String val : data)
                {
                    System.out.println(val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        String[] emprunts = {"Livre: Les misérables\n Date Emprunt: 01/01/2016\n Date Retour: 01/03/2016",
                                    "Livre: Langage C\n Date Emprunt: 10/02/2016\n Date Retour: 21/03/2016",
                                    "Livre: Les Ressources Humaines\n Date Emprunt: 15/02/2016\n Date Retour: 19/04/2016"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emprunts);
        ListView listEmprunts = (ListView)findViewById(R.id.listViewEmprunts);
        listEmprunts.setAdapter(adapter);

        listEmprunts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {


            }
        });

    }


}