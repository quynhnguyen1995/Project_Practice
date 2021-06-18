package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.Poster
import com.example.practiceproject.model.Trailer
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.line_poster.view.*
import kotlinx.android.synthetic.main.line_trailer.view.*

class TrailerAdapter(val trailerList: ArrayList<Trailer>, val context: Context) : RecyclerView.Adapter<TrailerAdapter.ViewHolder>() {
    private val onItemClickSubject = PublishSubject.create<Int>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindingValues(get: Trailer) {
            itemView.txtSite.text = get.site
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_trailer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder!!.bindingValues(trailerList[position])

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
        return trailerList.size
    }
}