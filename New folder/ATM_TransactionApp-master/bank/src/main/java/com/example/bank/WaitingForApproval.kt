package com.example.bank

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_transaction_type.*
import kotlinx.android.synthetic.main.waiting_for_approval.*

class WaitingForApproval : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.waiting_for_approval)


        // transaction cancelled button
        transactionCancelled.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(applicationContext, "Transaction Cancelled", Toast.LENGTH_SHORT).show()
        })
    }


}