package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class BackDropResult (
    @SerializedName("id")
    val id: Int,
    @SerializedName("backdrops")
    val backdrops: ArrayList<BackDrop>,
        ): Serializable{}