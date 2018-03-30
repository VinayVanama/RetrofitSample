package com.example.cykulapps.retrofitsample;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CYKUL App's on 21-12-2016.
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")
    public void insertUser(
            @Field("name")String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);
}
