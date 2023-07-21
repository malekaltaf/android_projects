package com.vama.gsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        TextView helloWorld = findViewById(R.id.helloworld);
        helloWorld.setText(jsonString);

        

    }

}