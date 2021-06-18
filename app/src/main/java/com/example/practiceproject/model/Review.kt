package com.example.practiceproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Review(
    @SerializedName("id")
    @Expose
    val   id:String,
    @SerializedName("author")
    @Expose
    val   author:String,
    @SerializedName("content")
    @Expose
    val   content:String,
    @SerializedName("iso_639_1")
    @Expose
    val   iso6391:String,
    @SerializedName("media_id")
    @Expose
    val   mediaId:Int,
    @SerializedName("media_title")
    @Expose
    val   mediaTitle:String,
    @SerializedName("media_type")
    @Expose
    val   mediaType:String,
    @SerializedName("url")
    @Expose
    val   url:String
) : Serializable {
}