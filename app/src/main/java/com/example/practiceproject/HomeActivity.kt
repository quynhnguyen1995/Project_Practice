package com.example.practiceproject

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.adapter.PopularAdapter
import com.example.practiceproject.model.Popular
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.ArrayList

private const val POPULAR_URL = "https://api.themoviedb.org/3/movie/popular?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
private const val TOP_RATE_URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
private const val NOW_PLAYING_MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
private const val UPCOMING_MOVIE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=a7e38c80a0efc42034dfb5c8b95a72cb"
class HomeActivity : AppCompatActivity() {

    //list popular
    private val popularList = ArrayList<Popular>()
    private lateinit var popular: Popular
    private lateinit var mPopular: List<Popular>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    //list popular
    inner class GetData(): AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String {
            var current: String = ""
            try {
                val url: URL
                var urlConnection: HttpURLConnection? = null
                try {
                    url = URL(POPULAR_URL)
                    urlConnection = url.openConnection() as HttpURLConnection?

                    val inputStream: InputStream = urlConnection!!.inputStream
                    val inputStreamReader: InputStreamReader = InputStreamReader(inputStream)

                    var data: Int = inputStreamReader.read()
                    while (data != -1){
                        current += data
                        data = inputStreamReader.read()
                    }
                    return current
                } catch (e: MalformedURLException){
                    e.printStackTrace()
                }catch (e: IOException){
                    e.printStackTrace()
                } finally {
                    urlConnection?.disconnect()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
            return current
        }

        override fun onPostExecute(result: String?) {
            try {
                val jsonObject: JSONObject = JSONObject(result)
                val jsonArray: JSONArray = jsonObject.getJSONArray("results")
                for (i in 0..jsonArray.length()){
                    val jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                    popular.setPosterPath(jsonObject1.getString("poster_path"))
                    popular.setTitle(jsonObject1.getString("title"))

                    popularList.add(popular)
                }
            }catch (e: JSONException){
                e.printStackTrace()
            }

            PutDataIntoRecycleView(mPopular)
        }
    }

    //put data into recyclerview for popular
    private fun PutDataIntoRecycleView(mPopular: List<Popular>){
        val popularAdapter: PopularAdapter = PopularAdapter(this,mPopular)
        rvPopular.layoutManager = LinearLayoutManager(this)
        rvPopular.adapter = popularAdapter
    }
}