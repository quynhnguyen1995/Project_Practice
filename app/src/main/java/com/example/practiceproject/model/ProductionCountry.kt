package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductionCountry (
    @SerializedName("iso_3166_1")
    @Expose
    val iso31661 : String,
    @SerializedName("name")
    @Expose
    val name : String
) : Serializable {
}