package com.vama.drawingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button onestar,twostar,threestar,fourstar,fivestar;
    TextView onecount, twocount, threecount, fourcount, fivecount,countNo,avgVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onestar = findViewById(R.id.button);
        twostar = findViewById(R.id.button2);
        threestar = findViewById(R.id.button3);
        fourstar = findViewById(R.id.button4);
        fivestar = findViewById(R.id.button5);

        onecount = findViewById(R.id.textView2);
        twocount = findViewById(R.id.textView3);
        threecount = findViewById(R.id.textView4);
        fourcount = findViewById(R.id.textView5);
        fivecount = findViewById(R.id.textView6);
        countNo = findViewById(R.id.countNo);
        avgVote = findViewById(R.id.avgVote);

        onestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String star = onecount.getText().toString();
                int star3 = Integer.valueOf(star);
                star3++;
                onecount.setText(String.valueOf(star3));
                Toastthanx();
            }
        });

        twostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String star = twocount.getText().toString();
                int star3 = Integer.valueOf(star);
                star3+=2;
                twocount.setText(String.valueOf(star3));
                Toastthanx();
            }
        });

        threestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String star = threecount.getText().toString();
                int star3 = Integer.valueOf(star);
                star3+=3;
                threecount.setText(String.valueOf(star3));
                Toastthanx();
            }
        });

        fourstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String star = fourcount.getText().toString();
                int star3 = Integer.valueOf(star);
                star3+=4;
                fourcount.setText(String.valueOf(star3));
                Toastthanx();
            }
        });

        fivestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String star = fivecount.getText().toString();
                int star3 = Integer.valueOf(star);
                star3+=5;
                fivecount.setText(String.valueOf(star3));
                Toastthanx();
            }
        });
    }

    private void Toastthanx() {
         Toast.makeText(this, "Thank You For Your Valuable Rating", Toast.LENGTH_SHORT).show();
         String one = onecount.getText().toString();
         String two =  twocount.getText().toString();
         String three = threecount.getText().toString();
         String four =  fourcount.getText().toString();
         String five = fivecount.getText().toString();
         int _1 = Integer.valueOf(one);
         int _2 = Integer.valueOf(two);
         int _3 = Integer.valueOf(three);
         int _4 = Integer.valueOf(four);
         int _5 = Integer.valueOf(five);
         int total = _1+_2+_3+_4+_5;
         countNo.setText(String.valueOf(total));
         //avgVote.setText(String.valueOf(avg));
    }
}