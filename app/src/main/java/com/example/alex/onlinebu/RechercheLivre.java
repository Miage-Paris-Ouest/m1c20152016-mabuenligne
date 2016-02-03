package com.example.alex.onlinebu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RechercheLivre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_livre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String titre =  this.getIntent().getStringExtra("TITRE");
        String auteur =  this.getIntent().getStringExtra("AUTEUR");
        String theme =  this.getIntent().getStringExtra("THEME");


        String[] infosStrings = {
                "\nTitre: Au bonheur des dames \n Auteur: Emile Zola",
                "Titre: Harry Potter L'ordre du Phénix \n Auteur: J.K Roling",
                "Titre: Les misérables \n Auteur: Victor Hugo",
                "Titre: Les vieux qui lisait des romans \n Auteur: Luis Sepulveda",
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infosStrings);
        ListView listInfos = (ListView)findViewById(R.id.listViewLivres);
        listInfos.setAdapter(adapter);



    }

}
