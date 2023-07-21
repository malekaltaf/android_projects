package com.example.threadinstudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView mytext = (TextView) findViewById(R.id.txt);
            mytext.setText("Button Clicked Successfully");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clicknow(View view){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long future = System.currentTimeMillis()+10000;
                while(System.currentTimeMillis()<future){
                    synchronized (this){
                        try {
                            wait(future-System.currentTimeMillis());
                        }
                        catch (Exception e){}
                    }
                }
                handler.sendEmptyMessage(0);

            }
        };

        Thread mythread = new Thread(r);
        mythread.start();


    }
}