package com.vama.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vama.snackbar.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText et1,et2;
    String st1,st2;
    TextView tt1,tt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.user_name);
        et2 = findViewById(R.id.user_desc);
        tt1 = findViewById(R.id.uname);
        tt2 = findViewById(R.id.udesc);
        submit = findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1 = et1.getText().toString().trim();
                st2 = et2.getText().toString().trim();
                if(st1.isEmpty()&&st2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill Details", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Changes Made Sucessfully", Toast.LENGTH_SHORT).show();
                    tt1.setText(st1);
                    tt2.setText(st2);
                }
            }
        });
    }
}