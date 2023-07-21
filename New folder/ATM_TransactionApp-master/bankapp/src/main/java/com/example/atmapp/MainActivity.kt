package com.example.atmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.app.ProgressDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atmapp.adapter.Withdrawaladp
import com.example.atmapp.api.RetroClient
import com.example.atmapp.model.Withdrawal
import com.example.atmapp.model.WithdrawalList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private var withdrawalsList: ArrayList<Withdrawal>? = null
    private var pDialog: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var withdrawalAdapter: Withdrawaladp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Data is loading.. Please be patient...")
        pDialog!!.isIndeterminate = false
        pDialog!!.setCancelable(false)
        pDialog!!.show()

        getApiInfo()

    }

    private fun getApiInfo() {
        val api = RetroClient.getApiService()
        val call = api.getMyJSON()

        call.enqueue(object : Callback<WithdrawalList> {
            override fun onResponse(
                call: Call<WithdrawalList>,
                response: Response<WithdrawalList>
            ) {
                //Dismiss Dialog
                pDialog!!.dismiss()

                if (response.isSuccessful) {

                    withdrawalsList = response.body()!!.get()
                    recyclerView = findViewById<RecyclerView>(R.id.withdrawalRecyclerView)
                    withdrawalAdapter = Withdrawaladp(withdrawalsList!!)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.layoutManager = eLayoutManager
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    recyclerView!!.adapter = withdrawalAdapter
                }
            }

            override fun onFailure(call: Call<WithdrawalList>, t: Throwable) {
                pDialog!!.dismiss()
            }
        })
    }
}
