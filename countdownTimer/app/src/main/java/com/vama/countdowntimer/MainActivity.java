package com.vama.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.vama.countdowntimer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Boolean timer=false;
    long l2;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        CountDownTimer countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                activityMainBinding.textView.setText( ""+l/1000);
                l2=l;
            }

            @Override
            public void onFinish() {

            }
        };
        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                countDownTimer.start();
//                activityMainBinding.button.setText("Pause");
//                boolean timerstart = true;
//                if(){
//
//                }
            if(timer==false){
                timer=true;
                countDownTimer.start();
                activityMainBinding.button.setText("Pause");
            }else{
                timer=false;
                countDownTimer.cancel();
                activityMainBinding.button.setText("Restart");
            }

            }
        });

    }
}