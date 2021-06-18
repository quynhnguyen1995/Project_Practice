package com.example.practiceproject.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practiceproject.R
import com.example.practiceproject.adapter.BackDropAdapter
import com.example.practiceproject.api.ApiClient
import com.example.practiceproject.model.BackDropResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*

const val collection_id = "collection_id"
class BackdropFragment : Fragment() {

    //Retrofit
    val apiClient by lazy {
        ApiClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiClient.getListBackdrop(collection_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                setDataInBackDrop(it)
            }, {
                Log.d("error", "errors")
            })
    }

    private fun setDataInBackDrop(it: BackDropResult?) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_backdrop, container, false)
    }
}