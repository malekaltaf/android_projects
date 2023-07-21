package com.example.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyIntentService.class);
        startService(intent);
    }
    public void click1(View view){
        Intent i = new Intent(this,activity2.class);
        final EditText firstinput = (EditText) findViewById(R.id.input1);
        String usermsg  = firstinput.getText().toString();
        i.putExtra("First Message",usermsg);
        startActivity(i);
    }
}