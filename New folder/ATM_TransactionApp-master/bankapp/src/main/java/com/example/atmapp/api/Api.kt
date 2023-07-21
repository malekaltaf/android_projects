package com.example.atmapp.api

import com.example.atmapp.model.WithdrawalList
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/db.json")
    fun getMyJSON(): Call<WithdrawalList>

}