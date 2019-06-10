package com.mabadiku.marketplace.api;

import com.mabadiku.marketplace.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginAPI {
    @FormUrlEncoded
    @POST("inserDB.php")
    Call<Value> login(@Field("email") String email,
                      @Field("password") String password);
    @GET("getproduk.php")
    Call<Value> view();
}

