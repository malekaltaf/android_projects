
package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewEpargne extends AppCompatActivity {
    StubsPourSimulation stubsPourSimulation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epargne);

        ConfigurationGuichet application = (ConfigurationGuichet)getApplication();
        stubsPourSimulation = application.stubsPourSimulation;



        //Remplir ma liste
        ArrayList<Epargne> listeComptesEpargne = new ArrayList<>();

        for(int i = 0; i<stubsPourSimulation.listeClient.size(); i++) {
          listeComptesEpargne.add(stubsPourSimulation.listeClient.get(i).getCompteEpargne());
        }


        //Donner ma liste au Adapter
        EpargneAdapter adapter = new EpargneAdapter(this, R.layout.liste_layout_epargne, listeComptesEpargne);


        ListView maListObj = findViewById(R.id.maListe);

        final TextView quantite = (TextView) findViewById(R.id.nombre);
        String nombreCompteEpargnes = getString(R.string.listecompteepargne) + adapter.getCount();
        quantite.setText(nombreCompteEpargnes);

        maListObj.setAdapter(adapter);

    }




}