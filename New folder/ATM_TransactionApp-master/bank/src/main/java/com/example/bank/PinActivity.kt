package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pin.*
import android.content.Intent



class PinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)


        val editPhone = editPhoneNumber

        button_continue.setOnClickListener(View.OnClickListener {

            val mobile = editPhone.text.toString().trim()

            if (mobile.isEmpty() || mobile.length < 10 ) {
                editPhone.setError("Enter a valid number")
                editPhone.requestFocus()
                return@OnClickListener
            }

            val intent = Intent(this@PinActivity, VerifyPhoneNumber::class.java)
            intent.putExtra("mobile", mobile)
            startActivity(intent)
        })

    }
}
