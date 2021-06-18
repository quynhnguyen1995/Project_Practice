package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.TopRate
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.line_home_top_rate.view.*

class TopRateAdapter(val topRateList: ArrayList<TopRate>, val context: Context): RecyclerView.Adapter<TopRateAdapter.ViewHolder>() {

    private val onItemClickSubject = PublishSubject.create<Int>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(get: TopRate) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+get.poster_path)
                .into(itemView.imgHomeTopRate)
            itemView.txtHomeTitleTopRate.text = get.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRateAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_home_top_rate, parent, false)
        return TopRateAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopRateAdapter.ViewHolder, position: Int) {
        holder!!.bindingValues(topRateList[position])

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
        return topRateList.size
    }

}