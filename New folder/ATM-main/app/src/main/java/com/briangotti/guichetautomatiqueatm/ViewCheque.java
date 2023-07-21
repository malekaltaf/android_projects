
package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCheque extends AppCompatActivity {

    StubsPourSimulation stubsPourSimulation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheque);

        ConfigurationGuichet application = (ConfigurationGuichet)getApplication();
        stubsPourSimulation = application.stubsPourSimulation;

        //Remplir ma liste
        ArrayList<Cheque> listeComptesCheque = new ArrayList<>();

        for(int i = 0; i<stubsPourSimulation.listeClient.size(); i++) {
            listeComptesCheque.add(stubsPourSimulation.listeClient.get(i).getCompteCheque());
        }

        //Donner ma liste au Adapter
        ChequeAdapter adapter = new ChequeAdapter(this, R.layout.liste_layout_cheque, listeComptesCheque);


        ListView maListObj = findViewById(R.id.maListe);

        final TextView quantite = (TextView) findViewById(R.id.nombre);
        String nombreCompteCheques = getString(R.string.listecomptecheque) + adapter.getCount();
        quantite.setText(nombreCompteCheques);

        maListObj.setAdapter(adapter);

    }

}