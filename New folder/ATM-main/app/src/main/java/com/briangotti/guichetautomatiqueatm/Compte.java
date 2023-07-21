package com.briangotti.guichetautomatiqueatm;

public class Compte {

    private String numeroNip;
    private int numeroCompte;
    private double soldeCompte;

    public String getNumeroNip() {
        return numeroNip;
    }

    public void setNumeroNip(String numeroNip) {
        this.numeroNip = numeroNip;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return Math.floor(soldeCompte * 100) / 100;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public void retrait(double montant) {

        setSoldeCompte(soldeCompte - montant);
    }

    public void depot(double montant) {
        setSoldeCompte(soldeCompte + montant);

    }
}