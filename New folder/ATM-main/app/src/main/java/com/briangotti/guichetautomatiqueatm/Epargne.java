package com.briangotti.guichetautomatiqueatm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Epargne extends Compte {



    public void paimentInterets(double taux) {
        setSoldeCompte(getSoldeCompte() * taux);
    }

}