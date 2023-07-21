package com.example.bank.retrofit;

import com.example.bank.model.Withdrawal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/db.json")
    @FormUrlEncoded
    Call<Withdrawal> getMoney(@Field("name") String title,
                              @Field("amount") String body);
}
