package com.reynaldiwijaya.googlenews.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static final String API_URL = "http://newsapi.org/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ApiService service = retrofit.create(ApiService.class);
}
