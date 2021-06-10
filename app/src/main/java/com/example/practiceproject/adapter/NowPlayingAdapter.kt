package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.PNowPlaying
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.line_home_now_playing.view.*

class NowPlayingAdapter(val nowPlayingList: ArrayList<PNowPlaying.NowPlaying>, val context: Context): RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    private val onItemClickSubject = PublishSubject.create<Int>()

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

        //set on item click
        holder.itemView.setOnClickListener {
                v -> onItemClickSubject.onNext(holder.adapterPosition)
        }
    }

    public fun getOnItemClickObservable(): Observable<Int> {
        return onItemClickSubject
        //onItemClickSubject.asObservable()
    }

    override fun getItemCount(): Int {
        return nowPlayingList.size
    }

}