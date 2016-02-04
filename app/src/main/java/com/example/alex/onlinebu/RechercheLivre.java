package com.example.alex.onlinebu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.*;

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




            /*TEST ACCES AUX DONNEES D UN FICHIER POUR LES AJOUTER DANS LES LISTVIEW

        String filePath = "C:\\Users\\Alex\\Documents\\GitHub\\m1c20152016-mabuenligne\\donnéesLivres.txt";
        InputStream ips = null;
        try {
            ips = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader ipsr= new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);

        String ligne;
        try {
            while((ligne=br.readLine())!=null){
                int i =0;
                //ton traitement par exemple ici avec ton fichier csv
                String str[] =ligne.split("/");
                System.out.println(str[i]);
                i++;
    // chaque valeur du tableau str est une valeur de ta ligne ex: str[0]=M392060... Comme ça tu peux faire les traitements que tu veux
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


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
