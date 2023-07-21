package com.example.bank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var providers : List<AuthUI.IdpConfig>
    val MY_REQUEST_CODE = 771


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_signOut.setOnClickListener(View.OnClickListener {
            AuthUI.getInstance().signOut(this)
                .addOnCompleteListener {
                    btn_signOut.isEnabled = false
                    showSignINOptions()
                }
                .addOnFailureListener {
                        e -> Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
        })

        atm_transaction.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "ATM Transaction started", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PinActivity::class.java))
        })


        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(), // EMAIL
            AuthUI.IdpConfig.GoogleBuilder().build()  // Google
        )

        showSignINOptions()

    }


    // activity result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == MY_REQUEST_CODE){

            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK){
                val user = FirebaseAuth.getInstance().currentUser  // gets the current user
                Toast.makeText(this, "" + user!!.email, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, PinActivity::class.java))
                btn_signOut.isEnabled = true
            }else{
                Toast.makeText(this, "" + response!!.error!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showSignINOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.MyTheme)
            .build(),MY_REQUEST_CODE)
    }
}
