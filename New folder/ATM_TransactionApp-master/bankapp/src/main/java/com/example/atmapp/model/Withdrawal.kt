package com.example.atmapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Withdrawal {
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("transactionType")
    @Expose
    private var transactionType: String? = null
    @SerializedName("amount")
    private var amount: Int = 0

    @SerializedName("status")
    @Expose
    private var status: String? = null

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getTransactionType(): String? {
        return transactionType
    }

    fun setTransactionType(transactionType: String) {
        this.transactionType = transactionType
    }

    fun getAmount(): Int {
        return amount
    }

    fun setAmount(amount: Int) {
        this.amount = amount
    }

}