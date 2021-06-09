package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.PUpcomingMovie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.line_home_upcoming.view.*

class UpcomingAdapter(val upcomingList: ArrayList<PUpcomingMovie.Upcoming>, val context: Context): RecyclerView.Adapter<UpcomingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(get: PUpcomingMovie.Upcoming) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+get.poster_path)
                .into(itemView.imgHomeUpcoming)
            itemView.txtHomeTitleUpcoming.text = get.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_home_upcoming, parent, false)
        return UpcomingAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpcomingAdapter.ViewHolder, position: Int) {
        holder!!.bindingValues(upcomingList[position])
    }

    override fun getItemCount(): Int {
        return upcomingList.size
    }

}