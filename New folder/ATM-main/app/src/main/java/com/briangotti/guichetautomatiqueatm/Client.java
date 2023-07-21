package com.briangotti.guichetautomatiqueatm;

public class Client {

private String nom;
private String prenom;
private String username;
private String numeroNip;
private Cheque compteCheque;
private Epargne compteEpargne;

    public Cheque getCompteCheque() {
        return compteCheque;
    }

    public void setCompteCheque(Cheque compteCheque) {
        this.compteCheque = compteCheque;
    }

    public Epargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(Epargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumeroNip() {
        return numeroNip;
    }

    public void setNumeroNip(String numeroNip) {
        this.numeroNip = numeroNip;
    }
}
