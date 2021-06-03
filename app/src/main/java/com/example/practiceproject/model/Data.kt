package com.example.practiceproject.model

import com.google.gson.annotations.SerializedName

class Data (private val success: Boolean, private val expires_at: String, private val request_token: String)

class User(private val username: String, private  val password: String)
