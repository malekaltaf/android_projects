
package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewClient extends AppCompatActivity {
    StubsPourSimulation stubsPourSimulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        ConfigurationGuichet application = (ConfigurationGuichet)getApplication();
        stubsPourSimulation = application.stubsPourSimulation;
        //Remplir ma liste
        ArrayList<Client> listeClients = new ArrayList<>();

        for(int i = 0; i<stubsPourSimulation.listeClient.size(); i++) {
            listeClients.add(stubsPourSimulation.listeClient.get(i));
        }

        //Donner ma liste au Adapter
        ClientAdapter adapter = new ClientAdapter(this, R.layout.liste_layout_client, listeClients);


        ListView maListObj = findViewById(R.id.maListe);

        final TextView quantite = (TextView) findViewById(R.id.nombre);
        String nombreClients = getString(R.string.listecompteclients) + adapter.getCount();
        quantite.setText(nombreClients);

        maListObj.setAdapter(adapter);

    }


}