package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductionCompany (
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("logo_path")
    @Expose
    val   logoPath:String,
    @SerializedName("name")
    @Expose
    val   name:String,
    @SerializedName("origin_country")
    @Expose
    val   originCountry:String
) : Serializable {
}