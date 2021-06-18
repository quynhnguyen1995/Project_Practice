package com.example.practiceproject.api


import com.example.practiceproject.model.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //Splash screen
    @GET("authentication/token/new?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTokenRequest(): Call<Splash>

    //List Popular
    @GET("movie/popular?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getPopular(): Observable<Popular>

    //List Top rate
    @GET("movie/top_rated?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTopRate(): Observable<TopRate>

    //List Now playing movie
    @GET("now_playing?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getNowPlayingMovie(): Observable<NowPlaying>

    //List Upcoming movie
    @GET("upcoming?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getUpcoming(): Observable<Upcoming>

    //detail
    @GET("movie/{movie_id}?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getMovieDetail(@Path("movie_id") movieId : Int) : Observable<Detail>

    //trailer
    @GET("movie/{movie_id}/videos?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTrailerMovie(@Path("movie_id") movieId : Int) : Observable<TrailerResult>

    //trending movie
    @GET("trending/{media_type}/{time_window}?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getTrendingMovie(@Path("media_type") mediaType : String, @Path("time_window") timeWindow : String) : Observable<MoviePageResult>

    //reviews
    @GET("movie/{movie_id}/reviews?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getReview(@Path("movie_id") movieId : Int) : Observable<ReviewResult>

    //search
    @GET("search/movie?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getMovieSearch(@Query("query") query : String) : Observable<MoviePageResult>

    //list backdrop image
    @GET("collection/{collection_id}/images?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getListBackdrop(@Path("collection_id") collection_id: String): Observable<BackDropResult>

    //list poster image
    @GET("collection/{collection_id}/images?api_key=a7e38c80a0efc42034dfb5c8b95a72cb")
    fun getListPoster(@Path("collection_id") collection_id: Int): Observable<PosterResult>

    //list crew image
    //list cast image

}