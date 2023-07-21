package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAdmin extends AppCompatActivity {
    StubsPourSimulation stubsPourSimulation;
    private static final double TAUX_INTERET = 1.0125;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ConfigurationGuichet application = (ConfigurationGuichet)getApplication();
        stubsPourSimulation = application.stubsPourSimulation;

        // Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(Intent.EXTRA_TEXT);

        // TextView
        // use the text in a TextView
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Bonjour " + username);
    }

    public void onClickCheque(View view) {
        Intent intent = new Intent(this, ViewCheque.class);
        startActivity(intent);
    }

    public void onClickEpargne(View view) {
        Intent intent = new Intent(this, ViewEpargne.class);
        startActivity(intent);
    }

    public void onClickInterets(View view) {
        for (int i = 0; i < stubsPourSimulation.listeClient.size(); i++ ){
            stubsPourSimulation.listeClient.get(i).getCompteEpargne().paimentInterets(TAUX_INTERET);
        }
        Toast.makeText(getApplicationContext(), "Une taux d'interet de 1.25% a éte payé a chaque client", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ViewEpargne.class);
        startActivity(intent);
    }

    public void onClickListeClients(View view) {
        Intent intent = new Intent(this, ViewClient.class);
        startActivity(intent);
    }

    public void onClickLogout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}