package com.vama.atmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vama.atmapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button balance,withdrawn;
    EditText amount;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        setContentView(R.layout.activity_main);
        balance = findViewById(R.id.currentbalance);
        withdrawn = findViewById(R.id.withdrawlabutton);
        amount = findViewById(R.id.withdrawlmoney);
        // everything declare and value has been assign
        

    }

}