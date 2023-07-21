

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

public class ChequeAdapter extends ArrayAdapter<Cheque> {
    private ArrayList<Cheque> listeComptesCheque;
    private Context context;
    private int viewRes;
    private Resources res;

    public ChequeAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<Cheque> cheque) {
        super(context, textViewResourceId, cheque);

        this.listeComptesCheque = cheque;
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

        final Cheque compteChequeClient = listeComptesCheque.get(position);

        if (compteChequeClient != null) {

            final TextView numerocomptecheque = (TextView) view.findViewById(R.id.numerocomptecheque);
            final TextView soldecheque =(TextView)view.findViewById(R.id.soldecheque);

            //numero de compte
            String chequingNumber=res.getString(R.string.numerocomptecheque)+""+compteChequeClient.getNumeroCompte();
            numerocomptecheque.setText(chequingNumber);

            //solde de compte
            String chequingBalance=res.getString(R.string.soldecheque)+""+compteChequeClient.getSoldeCompte();
            soldecheque.setText(chequingBalance);
        }

        return view;
    }

    @Override
    public int getCount() {
        return listeComptesCheque.size();
    }
}
