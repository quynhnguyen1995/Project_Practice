package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.PPopular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.line_home_popular.view.*

class PopularAdapter(val popList: ArrayList<PPopular.Popular>, val context: Context): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(get: PPopular.Popular) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+get.poster_path)
                .into(itemView.imgHomePopular)
            itemView.txtHomeTitlePopular.text = get.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_home_popular, parent, false)
        return PopularAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        holder!!.bindingValues(popList[position])
    }

    override fun getItemCount(): Int {
        return popList.size
    }

}