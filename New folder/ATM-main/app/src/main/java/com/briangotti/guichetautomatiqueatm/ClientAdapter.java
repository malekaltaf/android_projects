

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

public class ClientAdapter extends ArrayAdapter<Client> {
    private ArrayList<Client> listClients;
    private Context context;
    private int viewRes;
    private Resources res;

    public ClientAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<Client> client) {
        super(context, textViewResourceId, client);

        this.listClients = client;
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

        final Client client = listClients.get(position);

        if (client != null) {

            final TextView nomclient = (TextView) view.findViewById(R.id.nomclient);
            final TextView prenomclient =(TextView)view.findViewById(R.id.prenomclient);

            //numero de compte
            String nomClient=res.getString(R.string.nomclient)+""+client.getNom();
            nomclient.setText(nomClient);

            //solde de compte
            String prenomClient=res.getString(R.string.prenomclient)+""+client.getPrenom();
            prenomclient.setText(prenomClient);
        }

        return view;
    }

    @Override
    public int getCount() {
        return listClients.size();
    }
}
