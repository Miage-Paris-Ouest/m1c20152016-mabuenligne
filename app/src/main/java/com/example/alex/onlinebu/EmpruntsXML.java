package com.example.alex.onlinebu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import XML.XmlParser;
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
        ListView listEmprunts = (ListView)findViewById(R.id.listViewEmprunts);

        textUser.setText("Emprunts de " + user);
        XmlParser XMl = new XmlParser();
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

    }
}
