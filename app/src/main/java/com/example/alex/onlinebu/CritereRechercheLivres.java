package com.example.alex.onlinebu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CritereRechercheLivres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critere_recherche_livres);

        Button boutonRecherche = (Button) findViewById(R.id.buttonRecherche);

        boutonRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText editTitre = (EditText) findViewById(R.id.editTextTitreLivre);
                final EditText editAuteur = (EditText) findViewById(R.id.editTextAuteurLivre);
                final EditText editTheme = (EditText) findViewById(R.id.editTextThemeLivre);

                Intent intent = new Intent(CritereRechercheLivres.this, RechercheLivre.class);
                intent.putExtra("TITRE",editTitre.getText().toString());
                intent.putExtra("AUTEUR",editAuteur.getText().toString());
                intent.putExtra("THEME",editTheme.getText().toString());
                startActivity(intent);
            }
        });
    }
}
