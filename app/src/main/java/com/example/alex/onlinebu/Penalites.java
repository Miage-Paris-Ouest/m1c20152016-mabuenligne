package com.example.alex.onlinebu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Penalites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalites);

       TextView Penalites = (TextView) findViewById(R.id.textViewPenalités);
        Penalites.setText("Livre: Les Misérables\n Penalité: 1 (1 jour)");
    }
}
