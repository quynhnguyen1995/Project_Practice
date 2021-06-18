package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceproject.api.ApiClient

class DetailActivity : AppCompatActivity() {

    //Retrofit
    val apiClient by lazy {
        ApiClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }


}