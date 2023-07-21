package com.vama.randomaigenerate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int i;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
    int buttonIDs[] = {R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,
    R.id.b15,R.id.b16,R.id.b17,R.id.b18,R.id.b19,R.id.b20,R.id.b21,R.id.b22,R.id.b23,R.id.b24,R.id.b25,R.id.b26,R.id.b27,R.id.b28,R.id.b29,R.id.b30};
    Button buttonArray[] = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(i=0;i<30;i++){
            buttonArray[i] = findViewById(buttonIDs[i]);
            buttonArray[i].setText(String.valueOf(i));
        }
    }
}