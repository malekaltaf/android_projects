package com.example.firstworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mybtn = (Button) findViewById(R.id.mybtn);

        mybtn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView mytxt = findViewById(R.id.mytxt);
                        mytxt.setText("Button Clicked");
                    }
                }

        );

        mybtn.setOnLongClickListener(
                new Button.OnLongClickListener()
                {
                    public boolean onLongClick(View v)
                    {
                        TextView mytxt = findViewById(R.id.mytxt);
                        mytxt.setText("Button Long Pressed");
                        return true;
                    }
                }
        );

    }
}