package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.PNowPlaying
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.line_home_now_playing.view.*

class NowPlayingAdapter(val nowPlayingList: ArrayList<PNowPlaying.NowPlaying>, val context: Context): RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(get: PNowPlaying.NowPlaying) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+get.poster_path)
                .into(itemView.imgHomeNowPlaying)
            itemView.txtHomeTitleNowPlaying.text = get.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_home_now_playing, parent, false)
        return NowPlayingAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingAdapter.ViewHolder, position: Int) {
        holder!!.bindingValues(nowPlayingList[position])
    }

    override fun getItemCount(): Int {
        return nowPlayingList.size
    }

}