package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName


//List top rate
 class TopRate(
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("title")
    val title: String)