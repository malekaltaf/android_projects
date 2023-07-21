package com.example.bank.utils;

import com.example.bank.retrofit.ApiService;
import com.example.bank.retrofit.RetrofitClient;

public class AppUtils {

    public AppUtils() {
    }

    public static final String BASE_URL = "http://bolsschools.com/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
