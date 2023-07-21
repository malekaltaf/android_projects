package com.example.atmapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class WithdrawalList {

    @SerializedName("transactions")
    @Expose
    private var withdrawals: ArrayList<Withdrawal>? = null

    fun get(): ArrayList<Withdrawal>? {
        return withdrawals
    }

    fun set(withdrawals: ArrayList<Withdrawal>) {
        this.withdrawals = withdrawals
    }
}