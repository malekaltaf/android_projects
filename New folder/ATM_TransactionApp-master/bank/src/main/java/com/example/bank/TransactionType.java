package com.example.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bank.model.Withdrawal;
import com.example.bank.retrofit.ApiService;
import com.example.bank.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class TransactionType extends AppCompatActivity {
    private ApiService mAPIService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_type);


        final EditText titleEt = (EditText) findViewById(R.id.name_edit);
        final EditText bodyEt = (EditText) findViewById(R.id.amount_edit);
        Button submitBtn = (Button) findViewById(R.id.continue_transactions);

        mAPIService = AppUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });
    }


    public void sendPost(String title, String body) {
        mAPIService.getMoney(title, body).enqueue(new Callback<Withdrawal>() {
            @Override
            public void onResponse(Call<Withdrawal> call, Response<Withdrawal> response) {

                if(response.isSuccessful()) {
                    nextActivity();
                }
            }

            @Override
            public void onFailure(Call<Withdrawal> call, Throwable t) {

            }
        });
    }


    private void nextActivity(){
        Toast.makeText(this, "Awaiting Approval", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(TransactionType.this, WaitingForApproval.class);
        startActivity(i);
    }
}
