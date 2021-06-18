package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PosterResult (
    @SerializedName("id")
    val id: Int,
    @SerializedName("posters")
    val posters: ArrayList<Poster>
    ): Serializable{}
