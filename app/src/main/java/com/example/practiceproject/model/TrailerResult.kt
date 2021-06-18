package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TrailerResult (
    @SerializedName("id")
    @Expose
    val   id:Int,
    @SerializedName("results")
    @Expose
    val   results : ArrayList<Trailer>?= null
) : Serializable {
}