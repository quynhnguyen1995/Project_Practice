package com.example.practiceproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practiceproject.api.ApiService
import com.example.practiceproject.model.Data
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        pbLoad.progress = 0
        val call  = service.getTokenRequest()

        call.enqueue(object: Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val intent: Intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
                pbLoad.progress = 10
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(applicationContext,"Loading Error", Toast.LENGTH_SHORT).show()
                pbLoad.progress = 0
            }

        })
    }
}