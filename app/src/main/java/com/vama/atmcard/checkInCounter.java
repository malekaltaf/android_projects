package com.vama.atmcard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.vama.atmcard.databinding.ActivityCheckInCounterBinding;

public class checkInCounter extends AppCompatActivity {
    int type = 0;
    // not selected 0
    // withdrawal   1
    // deposit      2
    private ActivityCheckInCounterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_check_in_counter);
        binding = ActivityCheckInCounterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                String typ2 = radioButton.getText().toString();
                if(typ2=="Withdrawal"){
                    type = 1;
                }else{
                    type = 2;
                }
            }
        });
    }
}