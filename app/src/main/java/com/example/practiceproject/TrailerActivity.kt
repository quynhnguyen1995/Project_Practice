package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practiceproject.api.ApiClient
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class TrailerActivity : YouTubeBaseActivity() {

    private lateinit var trailerKey : String
    private lateinit var youtubePlayer : YouTubePlayerView
    //Retrofit
    val apiClient by lazy {
        ApiClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailer)

        youtubePlayer = findViewById<YouTubePlayerView>(R.id.youtube_player_view)

        val intent = intent.extras
        trailerKey = intent?.getString("trailer_id", "").toString()
        initializeYoutubePlayer()
    }

    private fun initializeYoutubePlayer(){
        youtubePlayer.initialize(getString(R.string.YOUTUBE_API_KEY), object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                if (!p2){
                    p1?.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                    p1?.loadVideo(trailerKey)
                }
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Log.e("abc", "Youtube Player View initialization failed");
            }

        })
    }
}