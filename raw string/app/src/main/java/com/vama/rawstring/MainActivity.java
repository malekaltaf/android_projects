package com.vama.rawstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;

import com.trendyol.bubblescrollbarlib.BubbleScrollBar;

public class MainActivity extends AppCompatActivity {

    BubbleScrollBar bubbleScrollBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubbleScrollBar = findViewById(R.id.bubbleScrollBar);
        ScrollView scrollView = findViewById(R.id.scrollview);
    }
}