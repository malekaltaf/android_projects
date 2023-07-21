package com.briangotti.guichetautomatiqueatm;

import java.util.ArrayList;

public class StubsPourSimulation {
    ArrayList<Client> listeClient = new ArrayList<>();
    public StubsPourSimulation() {
        genererClients();
    }

    public ArrayList<Client> getListeClient() {
        return listeClient;
    }


    private void genererClients() {

        // Compte 1
        Client compteUn = new Client();
        compteUn.setNom("Jacques");
        compteUn.setPrenom("Hamel");
        compteUn.setUsername("compteUn");
        compteUn.setNumeroNip("compteUn");

        Cheque chequeCompteUn = new Cheque();
        chequeCompteUn.setNumeroCompte(1111);
        chequeCompteUn.setNumeroNip("1234");
        chequeCompteUn.setSoldeCompte(1000.0);

        Epargne epargneCompteUn = new Epargne();
        epargneCompteUn.setNumeroCompte(9111);
        epargneCompteUn.setNumeroNip("1234");
        epargneCompteUn.setSoldeCompte(10000.0);

        compteUn.setCompteCheque(chequeCompteUn);
        compteUn.setCompteEpargne(epargneCompteUn);


        listeClient.add(compteUn);

        // Compte 2
        Client compteDeux = new Client();
        compteDeux.setNom("Maxime");
        compteDeux.setPrenom("Hamel");
        compteDeux.setUsername("compteDeux");
        compteDeux.setNumeroNip("compteDeux");

        Cheque chequeCompteDeux = new Cheque();
        chequeCompteDeux.setNumeroCompte(2222);
        chequeCompteDeux.setNumeroNip("1234");
        chequeCompteDeux.setSoldeCompte(500.0);

        Epargne epargneCompteDeux = new Epargne();
        epargneCompteDeux.setNumeroCompte(9222);
        epargneCompteDeux.setNumeroNip("1234");
        epargneCompteDeux.setSoldeCompte(6000.0);

        compteDeux.setCompteCheque(chequeCompteDeux);
        compteDeux.setCompteEpargne(epargneCompteDeux);


        listeClient.add(compteDeux);

        // Compte 3
        Client compteTrois = new Client();
        compteTrois.setNom("Jacques");
        compteTrois.setPrenom("Lauzon");
        compteTrois.setUsername("compteTrois");
        compteTrois.setNumeroNip("compteTrois");

        Cheque chequeCompteTrois = new Cheque();
        chequeCompteTrois.setNumeroCompte(3333);
        chequeCompteTrois.setNumeroNip("1234");
        chequeCompteTrois.setSoldeCompte(3500.0);

        Epargne epargneCompteTrois = new Epargne();
        epargneCompteTrois.setNumeroCompte(9333);
        epargneCompteTrois.setNumeroNip("1234");
        epargneCompteTrois.setSoldeCompte(4500.0);

        compteTrois.setCompteCheque(chequeCompteTrois);
        compteTrois.setCompteEpargne(epargneCompteTrois);

        listeClient.add(compteTrois);

    }


    public Client getClient(String username){
    for (int i = 0; i <listeClient.size(); i++){
        if (listeClient.get(i).getUsername().equalsIgnoreCase(username)){
            return listeClient.get(i);
        }
    }
     return null;
    }

}
