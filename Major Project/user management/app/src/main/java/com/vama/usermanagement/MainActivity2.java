package com.vama.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vama.usermanagement.databinding.ActivityMain2Binding;
import com.vama.usermanagement.databinding.ActivityMainBinding;

import io.paperdb.Paper;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding activityMainBinding;
        activityMainBinding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        Paper.book().read("username");
        Paper.book().read("password");
    }
}