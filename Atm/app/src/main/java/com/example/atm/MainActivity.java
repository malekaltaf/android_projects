package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.atm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Integer> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String amount = binding.etAmount.getText().toString();
                final String balance = binding.tvTotalBalance.getText().toString();

                final String twoThNoteNumBlnc = binding.tv2ThBlnc.getText().toString();
                final String fiveHNoteNumBlnc = binding.tv5HndrdBlnc.getText().toString();
                final String twoHNoteNumBlnc = binding.tv2HndrdBlnc.getText().toString();
                final String oneHNoteNumBlnc = binding.tv2HndrdBlnc.getText().toString();

                int newAmount;
                int newBalance;

                int newTwoThNoteNumBlnc;
                int newFiveHNoteNumBlnc;
                int newTwoHNoteNumBlnc;
                int newOneHNoteNumBlnc;

                newAmount = Integer.valueOf(amount);
                newBalance = Integer.valueOf(balance);

                newTwoThNoteNumBlnc = Integer.valueOf(twoThNoteNumBlnc);
                newFiveHNoteNumBlnc = Integer.valueOf(fiveHNoteNumBlnc);
                newTwoHNoteNumBlnc = Integer.valueOf(twoHNoteNumBlnc);
                newOneHNoteNumBlnc = Integer.valueOf(oneHNoteNumBlnc);


                notes = new ArrayList<>();
                notes.add(2000);
                notes.add(500);
                notes.add(200);
                notes.add(100);

                if(newAmount <= newBalance){
                    newBalance = newBalance - newAmount;
                    binding.tvTotalBalance.setText(newBalance);
                    binding.tvWidrwAmunt.setText(newAmount);

                        for (int x = 0; x < notes.size(); x++) {
                            if (newAmount >= 2000) {
                                newAmount = newAmount % notes.get(x);
                                binding.tv2ThousndCount.setText(newAmount);
                                newTwoThNoteNumBlnc = newTwoThNoteNumBlnc - newAmount;
                                binding.tv2HndrdBlnc.setText(newTwoThNoteNumBlnc);
                            }
                            if (newAmount >= 500) {
                                newAmount = newAmount % notes.get(x);
                                binding.tv5HndrdCount.setText(newAmount);
                                newFiveHNoteNumBlnc = newFiveHNoteNumBlnc - newAmount;
                                binding.tv5HndrdCount.setText(newFiveHNoteNumBlnc);
                            }
                            if (newAmount >= 200) {
                                newAmount = newAmount % notes.get(x);
                                binding.tv2HndrdCount.setText(newAmount);
                                newTwoHNoteNumBlnc = newTwoHNoteNumBlnc - newAmount;
                                binding.tv2HndrdCount.setText(newTwoHNoteNumBlnc);
                            }
                            if (newAmount >= 100) {
                                newAmount = newAmount % notes.get(x);
                                binding.tv1HndrdCount.setText(newAmount);
                                newOneHNoteNumBlnc = newOneHNoteNumBlnc - newAmount;
                                binding.tv1HndrdCount.setText(newOneHNoteNumBlnc);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Enter valid amount", Toast.LENGTH_SHORT).show();
                            }
                        }

                }else {
                    Toast.makeText(MainActivity.this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}