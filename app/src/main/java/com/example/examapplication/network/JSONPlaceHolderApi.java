package com.example.examapplication.network;

import com.example.examapplication.model.LoginModel;
import com.example.examapplication.model.LoginResponse;
import com.example.examapplication.model.QuotesResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {
    @POST("user/login")
    Call<LoginResponse> login(@Body LoginModel loginModel);
}
