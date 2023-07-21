package com.example.atmapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.atmapp.R;
import com.example.atmapp.model.Withdrawal;

import java.util.List;

public class Withdrawaladp extends RecyclerView.Adapter<Withdrawaladp.CustomViewHolder> {
    private List<Withdrawal> repositories;

    public Withdrawaladp(List<Withdrawal> repositories) {
        this.repositories = repositories;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.withdrawal_row_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Withdrawal withdraws = repositories.get(position);

        holder.customerName.setText(withdraws.getName());
         holder.transactionType.setText(withdraws.getTransactionType());

//        holder.transactionType.setText(withdraws.getTransactionType());
//        holder.transactionAmount.setText(withdraws.getAmount());

    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView customerName, transactionType, transactionAmount;

        public CustomViewHolder(View view) {
            super(view);
            customerName = view.findViewById(R.id.customerName);
            transactionType = view.findViewById(R.id.transactionType);
            transactionAmount = view.findViewById(R.id.transactionAmount);

        }
    }
}