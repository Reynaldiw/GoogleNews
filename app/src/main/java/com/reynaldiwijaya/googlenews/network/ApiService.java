package com.reynaldiwijaya.googlenews.network;

import com.reynaldiwijaya.googlenews.responseapi.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v2/top-headlines?sources=google-news&apiKey=72b0da4102224254a299c4d63080c4e6")
    Call<ResponseBerita> getBerita();
}
