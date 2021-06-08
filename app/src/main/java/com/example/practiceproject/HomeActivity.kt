package com.example.practiceproject

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.adapter.PopularAdapter
import com.example.practiceproject.model.Popular
import com.google.gson.JsonObject
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

private const val BASE_URL = "https://api.themoviedb.org/3/"
class HomeActivity : AppCompatActivity() {

    //list popular
    private val popularList = ArrayList<Popular>()
    //Adapter
    private lateinit var popularAdapter: PopularAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        popularAdapter = PopularAdapter(popularList)
    }

    inner class GetData(): AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String {
            var current: String = ""
            try {
                val url: URL
                var urlConnection: HttpURLConnection? = null
                try {
                    url = URL(BASE_URL)
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
                for (i in )
            }catch (e: JSONException){
                e.printStackTrace()
            }
        }
    }
}