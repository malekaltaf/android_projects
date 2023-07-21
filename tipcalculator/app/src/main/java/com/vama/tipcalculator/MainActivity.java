package com.vama.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vama.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/ "));
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/html");
//        intent.putExtra(Intent.EXTRA_TITLE,"my title");
//        intent.putExtra(Intent.EXTRA_SUBJECT,"my subject");
//        intent.putExtra(Intent.EXTRA_TEXT,R.string.my_text);
//        startActivity(intent);
//        paykey.net
    }
}