package com.vama.randomaigenerate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    boolean curLanguage = true;
    // false = english
    // true = hindi
    Button language,go;
    int languageImg[] = {R.drawable.english0,R.drawable.hindi0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        language = findViewById(R.id.language0);
        go = findViewById(R.id.go0);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curLanguage){
                    language.setBackground(getDrawable(R.drawable.hindi0));
                    curLanguage=false;
                }
                else{
                    curLanguage=true;
                    language.setBackground(getDrawable(R.drawable.english0));
                }
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curLanguage){
                    Toast.makeText(MainActivity3.this, "Hindi Content", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity3.this, "English Content", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}