package com.example.animationbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ViewGroup mylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylayout = (ViewGroup) findViewById(R.id.mylayout);
        mylayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );

    }
    public void moveButton(){
        TransitionManager.beginDelayedTransition(mylayout);
        View myButton = findViewById(R.id.mybtn);
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        myButton.setLayoutParams(positionRules);
        // code for exapanding the btn
        ViewGroup.LayoutParams sizeRules = myButton.getLayoutParams();
        sizeRules.width=450;
        sizeRules.height=300;
        myButton.setLayoutParams(sizeRules);
    }
}