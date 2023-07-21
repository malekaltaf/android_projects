package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

        private workout  addnew = new workout();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickFind(View view){
        TextView modal = (TextView) findViewById(R.id.txt);
        Spinner phone = (Spinner) findViewById(R.id.selection);
        String workout = String.valueOf(phone.getSelectedItem());
        //modal.setText(workout);
        List <String> WorkOutLISt = addnew.getWorkout(workout);
        StringBuilder workformatted = new StringBuilder();
        for(String work:WorkOutLISt)
        {
            workformatted.append(work).append("\n");
        }
        modal.setText(workformatted);
    }
}