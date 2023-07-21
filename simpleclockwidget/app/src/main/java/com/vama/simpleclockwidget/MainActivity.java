package com.vama.simpleclockwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vama.simpleclockwidget.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    boolean ischeck=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ischeck){
                    ischeck=false;
                    binding.language.setText("Hindi");
                }else{
                    ischeck=true;
                    binding.language.setText("Gujarati");
                }
            }
        });


    }
}