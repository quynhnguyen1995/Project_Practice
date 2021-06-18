package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MoviePageResult(
    @SerializedName("page")
    val  page : Int,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("total_pages")
    val totalPages : Int,
    @SerializedName("results")
    val movieResult : ArrayList<Movie>
) : Serializable {
}