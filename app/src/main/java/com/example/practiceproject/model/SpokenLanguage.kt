package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SpokenLanguage (
    @SerializedName("iso_639_1")
    @Expose
    val iso6391 : String,
    @SerializedName("name")
    @Expose
    val name : String
) : Serializable {
}