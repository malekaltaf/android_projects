package com.vama.simpleapppart01;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Debug");
        Log.e("MainActivity","Error");
        Log.i("MainActivity","Info");
        Log.w("MainActivity","Warning");
        Log.v(LOG_TAG,"Verbose");

        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++){
                Log.d("Table of 1 to 100",String.valueOf(i)+" * "+String.valueOf(j)+" = "+String.valueOf(i*j));
            }
        }

        Log.d("MainActivity", "Hello World");


    }
}