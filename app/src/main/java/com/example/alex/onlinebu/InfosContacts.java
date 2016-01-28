package com.example.alex.onlinebu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InfosContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String[] infosStrings = {"Adresse: Paris X","Horaires: de 10h à 18h ","Autres infos: "};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infosStrings);
        ListView listInfos = (ListView)findViewById(R.id.listViewInfos);
        listInfos.setAdapter(adapter);

        String[] contactsStrings = {"Documentaliste: Dupont Jean\nMail: Jean.Dupont@hotmail.fr",
                                    "Secrétaire: Durand Pierre\nMail: Pierre.Durand@gmail.com"};


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsStrings);
        ListView listContacts = (ListView)findViewById(R.id.listViewContacts);
        listContacts.setAdapter(adapter2);


    }

}
