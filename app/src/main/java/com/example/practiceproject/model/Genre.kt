package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Genre (
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("name")
    @Expose
    val name:String
    ) : Serializable {

}