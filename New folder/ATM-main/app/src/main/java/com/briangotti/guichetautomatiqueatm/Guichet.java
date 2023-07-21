package com.briangotti.guichetautomatiqueatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Guichet extends AppCompatActivity {
    StubsPourSimulation stubsPourSimulation;

    Client client;



    //String
    String selectedRadio;
    private static final String NIP_INVALIDE = "Nip invalide!";
    private static final String NIP = "1234";
    private static final String SOLDE = " Solde : ";


    //Radiobutton
    RadioButton cheque, epargne, depot, retrait, virement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guichet);



        ConfigurationGuichet application = (ConfigurationGuichet)getApplication();
        stubsPourSimulation = application.stubsPourSimulation;



        // Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(Intent.EXTRA_TEXT);
        client = stubsPourSimulation.getClient(username);

        // TextView
        // use the text in a TextView
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Bonjour " + client.getPrenom() + " ATM ");
        client.getCompteCheque().getSoldeCompte();


        //Radio Group

        RadioGroup radioGroupCompte = (RadioGroup) findViewById(R.id.radioGroupComptes);
        RadioGroup radioGroupTransaction = (RadioGroup) findViewById(R.id.radioGroupTransaction);
        //Reset
        radioGroupCompte.clearCheck();
        radioGroupTransaction.clearCheck();

        //Radio Button

        cheque = (RadioButton) findViewById(R.id.radioCheque);
        radioGroupCompte.check(R.id.radioCheque);
        radioGroupTransaction.check(R.id.radioCheque);
        epargne = (RadioButton) findViewById(R.id.radioEpargne);
        depot = (RadioButton) findViewById(R.id.radioDepot);
        retrait = (RadioButton) findViewById(R.id.radioRetrait);
        virement = (RadioButton) findViewById(R.id.radioVirement);


        //Bouton
        Button etatcompte, soumettre;
        etatcompte = (Button) findViewById(R.id.btnEtatCompte);
        soumettre = (Button) findViewById(R.id.btnSoumettre);


        etatcompte.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (cheque.isChecked()) {
                    selectedRadio = "Solde du compte " + cheque.getText().toString() + ":  " + client.getCompteCheque().getSoldeCompte();
                    Toast.makeText(view.getContext(), selectedRadio, Toast.LENGTH_LONG).show();
                } else if (epargne.isChecked()) {
                    selectedRadio = "Solde du compte " + epargne.getText().toString() + ":  " + client.getCompteEpargne().getSoldeCompte();
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();
                } else if (!cheque.isChecked() || !epargne.isChecked()) {
                    Toast.makeText(view.getContext(), "Veuillez choisir faire une bonne selection.", Toast.LENGTH_LONG).show();
                }
            }


        });

        soumettre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText txtMontant = (EditText) findViewById(R.id.txtMontant);
                String txtMontantStr = txtMontant.getText().toString();
                Double montant = Double.valueOf(txtMontant.getText().toString());

                //Compte cheque
                if (!depot.isChecked() && !retrait.isChecked() && !cheque.isChecked() && !epargne.isChecked() && !virement.isChecked() && txtMontant.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Erreur.", Toast.LENGTH_LONG).show();

                } else if (depot.isChecked() && cheque.isChecked() && !txtMontant.getText().toString().isEmpty()) {
                    depotCheque(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();

                } else if (retrait.isChecked() && cheque.isChecked() && !txtMontant.getText().toString().isEmpty()){
                    retraitCheque(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();

                } else if (virement.isChecked() && cheque.isChecked() && !txtMontant.getText().toString().isEmpty()) {
                    virementCheque(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();
                }
                //Compte epargne
                else if (depot.isChecked() && epargne.isChecked() && !txtMontant.getText().toString().isEmpty()) {
                    depotEpargne(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();
                } else if (retrait.isChecked() && epargne.isChecked() && !txtMontant.getText().toString().isEmpty()) {
                    retraitEpargne(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();
                } else if (virement.isChecked() && epargne.isChecked() && !txtMontant.getText().toString().isEmpty()) {
                    virementEpargne(NIP, montant);
                    Toast.makeText(getApplicationContext(), selectedRadio, Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public double depotCheque(String nip, double montant) {
        if (client.getCompteCheque().getNumeroNip().equals(nip)) {
            client.getCompteCheque(). depot(montant);
            selectedRadio = depot.getText().toString() + " de " + montant + " sur votre compte " + cheque.getText().toString() + SOLDE + client.getCompteCheque().getSoldeCompte() ;
        } else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteCheque().getSoldeCompte();
    }

    public double depotEpargne(String nip, double montant) {
        if (client.getCompteEpargne().getNumeroNip().equals(nip)) {
            client.getCompteEpargne().depot(montant);
            selectedRadio = depot.getText().toString() + " de " + montant + " sur votre compte " + epargne.getText().toString() + SOLDE + client.getCompteEpargne().getSoldeCompte();
        } else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteEpargne().getSoldeCompte();
    }

    public double retraitCheque(String nip, double montant) {
        if (client.getCompteCheque().getNumeroNip().equals(nip)) {
            if (montant <= 1000.0 && montant % 10 == 0){
                if (client.getCompteCheque().getSoldeCompte() > montant){
                    client.getCompteCheque().retrait(montant);
                    selectedRadio = retrait.getText().toString() + " de " + montant + " sur votre compte " + cheque.getText().toString() + SOLDE + client.getCompteCheque().getSoldeCompte();
                }else{
                    selectedRadio = retrait.getText().toString() + " Le solde " + client.getCompteCheque().getSoldeCompte() + " est insufisant pour faire le retrait. "  + cheque.getText().toString();
                }
            } else{
                selectedRadio = retrait.getText().toString() + "  le retraite doit être multiple de $10 et le maximum de $1000.0  "  +  cheque.getText().toString();
            }
        } else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteCheque().getSoldeCompte();
    }

    public double retraitEpargne(String nip, double montant) {

        if (client.getCompteEpargne().getNumeroNip().equals(nip)) {
            if (montant <= 1000.0 && montant % 10 == 0){
                if (client.getCompteEpargne().getSoldeCompte() > montant){
                    client.getCompteEpargne().retrait(montant);
                    selectedRadio = retrait.getText().toString() + " de " + montant + " sur votre compte " + epargne.getText().toString() + SOLDE + client.getCompteEpargne().getSoldeCompte();
                }else{
                    selectedRadio = retrait.getText().toString() + " Le solde " + client.getCompteEpargne().getSoldeCompte() + " est insufisant pour faire le retrait. "  + epargne.getText().toString() ;
                }
            } else{
                selectedRadio = retrait.getText().toString() + "  le retraite doit être multiple de $10 et le maximum de $1000.0  "  +  epargne.getText().toString();
            }
        } else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteEpargne().getSoldeCompte();
    }

    public double virementCheque(String nip, double montant) {
        if (client.getCompteCheque().getNumeroNip().equals(nip)) {
            if (montant <= 100000.0){
                if (client.getCompteCheque().getSoldeCompte() > montant){
                    client.getCompteCheque().retrait(montant);
                    client.getCompteEpargne().depot(montant);
                    selectedRadio = virement.getText().toString() + " de " + montant + " de votre compte " + cheque.getText().toString() + " vers votre compte " + epargne.getText().toString() + SOLDE + client.getCompteCheque().getSoldeCompte();

                }else {
                    selectedRadio = virement.getText().toString() + " Le solde " + client.getCompteCheque().getSoldeCompte() + " est insufisant pour faire le virement. "  + cheque.getText().toString() + " vers votre compte " + epargne.getText().toString();
                }
            }else {
                selectedRadio = virement.getText().toString() + " le montant maximum pour virement est de $100000.0  "  +  cheque.getText().toString();
            }
        }else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteCheque().getSoldeCompte();
    }

    public double virementEpargne(String nip, double montant) {
        if (client.getCompteEpargne().getNumeroNip().equals(nip)) {
            if (montant <= 100000.0){
                if (client.getCompteEpargne().getSoldeCompte() > montant){
                    client.getCompteEpargne().retrait(montant);
                    client.getCompteCheque().depot(montant);
                    selectedRadio = virement.getText().toString() + " de " + montant + " de votre compte " + epargne.getText().toString() + " vers votre compte " + cheque.getText().toString()+ SOLDE + client.getCompteEpargne().getSoldeCompte();

                }else {
                    selectedRadio = virement.getText().toString() + " Le solde " + client.getCompteEpargne().getSoldeCompte() + " est insufisant pour faire le virement. "  + epargne.getText().toString() + " vers votre compte " + cheque.getText().toString();
                }
            }else {
                selectedRadio = virement.getText().toString() + " le montant maximum pour virement est de $100000.0  "  +  epargne.getText().toString();
            }


        } else {
            selectedRadio = NIP_INVALIDE;
        }
        return client.getCompteEpargne().getSoldeCompte();
    }




    public void onClickBtnLogout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickBtnClear(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.setText("");
    }


    public void onClickBtnZero(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("0");
    }

    public void onClickBtnOne(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("1");
    }

    public void onClickBtnTwo(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("2");
    }

    public void onClickBtnThree(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("3");
    }

    public void onClickBtnFour(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("4");
    }

    public void onClickBtnFive(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("5");
    }

    public void onClickBtnSix(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("6");
    }

    public void onClickBtnSeven(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("7");
    }

    public void onClickBtnEight(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("8");
    }

    public void onClickBtnNine(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append("9");
    }

    public void onClickBtnPoint(View view) {
        EditText montant = findViewById(R.id.txtMontant);
        montant.append(".");
    }

    public void onClickBtnEtatCompte(View view) {

        Toast.makeText(view.getContext(), "Solde compte Cheque: " + client.getCompteCheque().getSoldeCompte(), Toast.LENGTH_LONG).show();
        Toast.makeText(view.getContext(), "Solde compte Epargne: " + client.getCompteEpargne().getSoldeCompte(), Toast.LENGTH_LONG).show();
    }

    public void onClickBtnSoumettre(View view) {

        Toast.makeText(getApplicationContext(), "Submit", Toast.LENGTH_SHORT).show();
    }


}

