package com.example.practiceproject.api

import com.example.practiceproject.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("authentication/token/new?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTokenRequest(): Call<Data>
}