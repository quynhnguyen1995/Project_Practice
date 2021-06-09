package com.example.practiceproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceproject.adapter.NowPlayingAdapter
import com.example.practiceproject.adapter.PopularAdapter
import com.example.practiceproject.adapter.TopRateAdapter
import com.example.practiceproject.adapter.UpcomingAdapter
import com.example.practiceproject.api.ApiClient
import com.example.practiceproject.fragment.SearchFragment
import com.example.practiceproject.model.PNowPlaying
import com.example.practiceproject.model.PPopular
import com.example.practiceproject.model.PTopRate
import com.example.practiceproject.model.PUpcomingMovie
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import java.util.ArrayList


/*private const val TOP_RATE_URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
private const val NOW_PLAYING_MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
private const val UPCOMING_MOVIE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"*/
class HomeActivity : AppCompatActivity() {

    val apiClient by lazy {
        ApiClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Bottom navigation view
        bnvHome.setOnNavigationItemSelectedListener(bottomNavigation)

        //recyclerView
        rvPopular.layoutManager = LinearLayoutManager(this)
        rvTopRate.layoutManager = LinearLayoutManager(this)
        rvNowPlayingMovie.layoutManager = LinearLayoutManager(this)
        rvUpcomingMovie.layoutManager = LinearLayoutManager(this)

        //get Popular
        apiClient.getPopular()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                setDataInPopular(it)
            }, {
                Log.d("error", "errors")
            })

        //get Top rate
        apiClient.getTopRate()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                setDataInTopRate(it)
            }, { Log.d("error","errors")
            })

        //get Now playing movie
        apiClient.getNowPlayingMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                setDataInNowPlaying(it)
            },{
                Log.d("error","errors")
            })

        //get Upcoming movie
        apiClient.getUpcoming()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                setDataInUpcoming(it)
            },{
                Log.d("error","errors")
            })
    }

    private fun setDataInUpcoming(it: ArrayList<PUpcomingMovie.Upcoming>?) {
        rvUpcomingMovie.adapter = UpcomingAdapter(it!!,this)
    }

    private fun setDataInNowPlaying(it: ArrayList<PNowPlaying.NowPlaying>?) {
        rvNowPlayingMovie.adapter = NowPlayingAdapter(it!!, this)
    }

    private fun setDataInTopRate(it: ArrayList<PTopRate.TopRate>?) {
        rvTopRate.adapter = TopRateAdapter(it!!, this)
    }

    private fun setDataInPopular(it: ArrayList<PPopular.Popular>?) {
        rvPopular.adapter = PopularAdapter(it!!,this)
    }

    private val bottomNavigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.mSearch -> {
                val fragment = SearchFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}