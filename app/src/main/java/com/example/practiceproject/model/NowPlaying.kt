package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName


//list now playing movie
class NowPlaying(
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("title")
    val title: String)
