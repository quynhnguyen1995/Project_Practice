package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ReviewResult (
    @SerializedName("id")
    @Expose
    val  id:Int,
    @SerializedName("page")
    @Expose
    val  page:Int,
    @SerializedName("results")
    @Expose
    val  results:List<Review>? = null,
    @SerializedName("total_pages")
    @Expose
    val  totalPages:Int,
    @SerializedName("total_results")
    @Expose
    val  totalResults:Int
) : Serializable {
}