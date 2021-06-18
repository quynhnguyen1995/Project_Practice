package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(
    @SerializedName("vote_count")
    val voteCount:Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("video")
    val video : Boolean,
    @SerializedName("vote_average")
    val voteAverage : Double,
    @SerializedName("title")
    val  title : String,
    @SerializedName("popularity")
    val popularity : Double,
    @SerializedName("poster_path")
    val posterPath : String,
    @SerializedName("original_language")
    val originalLanguage : String,
    @SerializedName("original_title")
    val originalTitle : String,
    @SerializedName("genre_ids")
    val genreId : List<Int>,
    @SerializedName("backdrop_path")
    val backdropPath : String,
    @SerializedName("adult")
    val adult : Boolean,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("release_date")
    val releaseDate : String,
    @SerializedName("first_air_date")
    @Expose
    val  firstAirDate:String,
    @SerializedName("name")
    @Expose
    val   name:String,
    @SerializedName("origin_country")
    @Expose
    val   originCountry:List<String>? = null,
    @SerializedName("original_name")
    @Expose
    val  originalName:String
) : Serializable{
}