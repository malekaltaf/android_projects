package com.example.atmapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    // computer IP Address
    private static final String BASE_URL = "http://bolsschools.com/";

    //Get Retrofit Instance
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Get API Service and return API Service
    public static Api getApiService() {
        return getRetrofitInstance().create(Api.class);
    }
}
