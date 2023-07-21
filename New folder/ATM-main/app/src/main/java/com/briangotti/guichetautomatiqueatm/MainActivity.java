package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int compteur = 3;
    StubsPourSimulation stubsPourSimulation = new StubsPourSimulation();
    ArrayList<Client> listeClient = stubsPourSimulation.getListeClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private boolean validerUtilisateur (String nom, String nip ){
        for (int  i = 0 ; i < listeClient.size() ; i++){
            Client unClient = listeClient.get(i);
            if(unClient.getUsername().equalsIgnoreCase(nom)){
                if(unClient.getNumeroNip().equals(nip)){
                    return true;
                }
            }
        }
        return false;
    }


    public void onClickBtnSignIn(View view) {

        TextView username = (TextView) findViewById(R.id.editTextUsername);
        TextView nip = (TextView) findViewById(R.id.editTextNip);


            if (validerUtilisateur(username.getText().toString(), nip.getText().toString())){

                // get the text to pass
                EditText editText = (EditText) findViewById(R.id.editTextUsername);
                String textToPass = editText.getText().toString();

                // start the Compte Activity
                Intent intent = new Intent(this, Guichet.class);
                intent.putExtra(Intent.EXTRA_TEXT, textToPass);

                startActivity(intent);


            }
            //Password: D001
            else if ((username.getText().toString().equalsIgnoreCase("admin")) && (nip.getText().toString().equals("admin"))) {


                // get the text to pass
                EditText editText = (EditText) findViewById(R.id.editTextUsername);
                String textToPass = editText.getText().toString();

                // start the Compte Activity
                Intent intent = new Intent(this, ViewAdmin.class);
                intent.putExtra(Intent.EXTRA_TEXT, textToPass);
                startActivity(intent);

            }

            else  {
                Toast.makeText(view.getContext(), "Le nom d'utilisateur et/ou le nip est incorrect.", Toast.LENGTH_LONG).show();
                compteur--;
                if (compteur == 0) {
                    Toast.makeText(view.getContext(), "Erreur. Veuillez essayer plus tard.", Toast.LENGTH_LONG).show();
                    System.exit(0);
                }
            }


    }

}

