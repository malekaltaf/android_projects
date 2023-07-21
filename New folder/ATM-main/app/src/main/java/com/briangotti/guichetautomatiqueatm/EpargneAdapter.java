

package com.briangotti.guichetautomatiqueatm;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class EpargneAdapter extends ArrayAdapter<Epargne> {
    private ArrayList<Epargne> listeComptesEpargne;
    private Context context;
    private int viewRes;
    private Resources res;

    public EpargneAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<Epargne> epargne) {
        super(context, textViewResourceId, epargne);

        this.listeComptesEpargne = epargne;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.
                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }

        final Epargne compteEpargneClient = listeComptesEpargne.get(position);

        if (compteEpargneClient != null) {

            final TextView numerocompteepargne = (TextView) view.findViewById(R.id.numerocompteepargne);
            final TextView soldeepargne =(TextView)view.findViewById(R.id.soldeepargne);

            //numero de compte
            String savingsNumber=res.getString(R.string.numerocompteepargne)+"" +compteEpargneClient.getNumeroCompte();
            numerocompteepargne.setText(savingsNumber);

            //solde de compte
            String savingsBalance=res.getString(R.string.soldeepargne)+""+ compteEpargneClient.getSoldeCompte();
            soldeepargne.setText(savingsBalance);
        }

        return view;
    }

    @Override
    public int getCount() {
        return listeComptesEpargne.size();
    }
}
