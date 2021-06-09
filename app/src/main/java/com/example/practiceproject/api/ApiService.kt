package com.example.practiceproject.api


import com.example.practiceproject.model.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //Splash screen
    @GET("authentication/token/new?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTokenRequest(): Call<Splash>

    //List Popular
    @GET("movie/popular?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getPopular(): Observable<ArrayList<PPopular.Popular>>

    //List Top rate
    @GET("movie/top_rated?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTopRate(): Observable<ArrayList<PTopRate.TopRate>>

    //List Now playing movie
    @GET("now_playing?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getNowPlayingMovie(): Observable<ArrayList<PNowPlaying.NowPlaying>>

    //List Upcoming movie
    @GET("upcoming?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getUpcoming(): Observable<ArrayList<PUpcomingMovie.Upcoming>>
}