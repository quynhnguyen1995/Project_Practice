package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.Popular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.line_home_popular.view.*


class PopularAdapter(private var context: Context,private var popList:List<Popular>): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    //inner class
    inner class PopularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView = itemView.imgHomePopular
        var itemTitle: TextView = itemView.txtHomeTitlePopular
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.line_home_popular,parent,false)
        return PopularViewHolder(v)
    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {
        holder.itemTitle.text = popList[position].getTitle()

        //Using picasso
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+popList[position].getPosterPath())
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return popList.size
    }
}