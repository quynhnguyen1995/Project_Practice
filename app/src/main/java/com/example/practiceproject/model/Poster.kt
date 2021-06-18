package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Poster (
    @SerializedName("aspect_radio")
    val aspect_radio: Number,
    @SerializedName("file_path")
    val file_path: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("iso_639_1")
    val iso_639_1: Object,
    @SerializedName("vote_average")
    val vote_average: Number,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("width")
    val width: Int
): Serializable {}