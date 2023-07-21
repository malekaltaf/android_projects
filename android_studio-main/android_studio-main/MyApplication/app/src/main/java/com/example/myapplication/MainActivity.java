package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;
public class MainActivity extends AppCompatActivity {

        private  static final String TAG="MyMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG,"onCreate");

        RelativeLayout mylayout = new RelativeLayout(this);
        Button mybtn = new Button(this);


        mylayout.setBackgroundColor(Color.YELLOW);
        mybtn.setBackgroundColor(Color.RED);
        mybtn.setText("Click Here");


        RelativeLayout.LayoutParams btndet = new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        btndet.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btndet.addRule(RelativeLayout.CENTER_VERTICAL);

        mylayout.addView(mybtn,btndet);



        EditText username = new EditText(this);

        mybtn.setId(1);
        username.setId(2);

        RelativeLayout.LayoutParams userdet = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        userdet.addRule(RelativeLayout.ABOVE,mybtn.getId());
        userdet.addRule(RelativeLayout.CENTER_HORIZONTAL);


        Resources r = getResources();
        int pc = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());

        username.setWidth(pc);

        userdet.setMargins(0,0,0,50);

        mylayout.addView(username,userdet);


        setContentView(mylayout);

        



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }
}

