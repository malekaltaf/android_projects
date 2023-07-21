package com.vama.atmcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.vama.atmcard.databinding.ActivityMoneyOptionsScreenBinding;

public class MoneyOptionsScreen extends AppCompatActivity {

    private ActivityMoneyOptionsScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_money_options_screen);
        binding = ActivityMoneyOptionsScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.withdrawalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //withdraw amount
                goanotherActivity();
            }
        });

        binding.depositbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deposit amount
                goanotherActivity();
            }
        });
    }

    private void goanotherActivity() {
        binding.imageView.setVisibility(View.INVISIBLE);
        binding.progressBar2.setVisibility(View.VISIBLE);
        binding.depositbtn.setEnabled(false);
        binding.withdrawalbtn.setEnabled(false);
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MoneyOptionsScreen.this,checkInCounter.class));
                finish();
            }
        }.start();
    }
}