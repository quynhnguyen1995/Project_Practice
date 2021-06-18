package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName

//List popular
class Popular(
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("title")
    val title: String)