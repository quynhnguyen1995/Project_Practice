package com.example.practiceproject.api

import com.example.practiceproject.model.Popular
import com.example.practiceproject.model.Splash
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //Splash screen
    @GET("authentication/token/new?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTokenRequest(): Call<Splash>

    //List popular
    @GET("movie/popular?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getListPopular(): Call<List<Popular>>
}