package com.example.practiceproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceproject.adapter.NowPlayingAdapter
import com.example.practiceproject.adapter.PopularAdapter
import com.example.practiceproject.adapter.TopRateAdapter
import com.example.practiceproject.adapter.UpcomingAdapter
import com.example.practiceproject.api.ApiClient
import com.example.practiceproject.fragment.SearchFragment
import com.example.practiceproject.model.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(){

    //Retrofit
    val apiClient by lazy {
        ApiClient.create()
    }

    //ArrayList
    private val popList: ArrayList<Popular> = ArrayList()
    private val topRateList: ArrayList<TopRate> = ArrayList()
    private val nowPlayingList: ArrayList<NowPlaying> = ArrayList()
    private val upcomingList: ArrayList<Upcoming> = ArrayList()

    //Adapter
    private val popAdapter: PopularAdapter = PopularAdapter(popList, this@HomeActivity)
    private val topRateAdapter: TopRateAdapter = TopRateAdapter(topRateList, this@HomeActivity)
    private val nowPlayingAdapter: NowPlayingAdapter = NowPlayingAdapter(nowPlayingList, this@HomeActivity)
    private val upcomingAdapter: UpcomingAdapter = UpcomingAdapter(upcomingList, this@HomeActivity)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Bottom navigation view
        bnvHome.setOnNavigationItemSelectedListener(bottomNavigation)

        rvPopular.layoutManager = LinearLayoutManager(this)
        rvTopRate.layoutManager = LinearLayoutManager(this)
        rvNowPlayingMovie.layoutManager = LinearLayoutManager(this)
        rvUpcomingMovie.layoutManager = LinearLayoutManager(this)

        //item click
        popAdapter.getOnItemClickObservable().subscribe()
        topRateAdapter.getOnItemClickObservable().subscribe()
        nowPlayingAdapter.getOnItemClickObservable().subscribe()
        upcomingAdapter.getOnItemClickObservable().subscribe()

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

    private fun setDataInUpcoming(it: Upcoming?) {
        rvUpcomingMovie.adapter = upcomingAdapter
    }

    private fun setDataInNowPlaying(it: NowPlaying?) {
        rvNowPlayingMovie.adapter = nowPlayingAdapter
    }

    private fun setDataInTopRate(it: TopRate?) {
        rvTopRate.adapter = topRateAdapter
    }

    private fun setDataInPopular(it: Popular?) {
        rvPopular.adapter = popAdapter
    }

    private val bottomNavigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.mSearch -> {
                val fragment = SearchFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                    .commit()
                true
            }
            else -> false
        }
    }
}