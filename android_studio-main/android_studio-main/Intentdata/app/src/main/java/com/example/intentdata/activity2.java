package com.example.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        Bundle firstdata = getIntent().getExtras();
        if(firstdata==null)
        {
            return;
        }
        String firstmsg = firstdata.getString("First Message");
        final TextView secondtext = (TextView) findViewById(R.id.txt2);
        secondtext.setText(firstmsg);
    }
}