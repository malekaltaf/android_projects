package com.vama.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;
import com.vama.usermanagement.databinding.ActivityMainBinding;

import java.security.GeneralSecurityException;
import java.util.List;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button create;
    String userString, passString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding;
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userString = activityMainBinding.username.getText().toString().trim();
                passString = activityMainBinding.password.getText().toString().trim();
                if(userString.length()>5 && passString.length()>5){
                    SaveInformationOFUsers();
                }else{Toast.makeText(MainActivity.this, "Length of the Username and Password Must Be Longer than 5 Characters", Toast.LENGTH_SHORT).show();}
            }
        });

        activityMainBinding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityMainBinding.username.setText("");
                activityMainBinding.password.setText("");
            }
        });

    }

    private void SaveInformationOFUsers() {
        String ENCPass = null;
        try {
            ENCPass = AESCrypt.encrypt("433", passString);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String DECPass = null;
        try {
            DECPass = AESCrypt.decrypt("433", ENCPass);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        // original password ---->  encryption ----> encrypted password ----> decryption -----> original password
        // string password ------> AES algorithm ------> secure key -------> AES algo reverse -----> string password

            Paper.init(MainActivity.this);
            Paper.book().write("username",userString);
            Paper.book().write("password",ENCPass);
    }
}