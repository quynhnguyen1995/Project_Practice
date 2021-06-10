package com.example.practiceproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.R
import com.example.practiceproject.model.PPopular
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.line_home_popular.view.*


class PopularAdapter(val popList: ArrayList<PPopular.Popular>, val context: Context) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private val onItemClickSubject = PublishSubject.create<Int>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindingValues(get: PPopular.Popular) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+get.poster_path)
                .into(itemView.imgHomePopular)
            itemView.txtHomeTitlePopular.text = get.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.line_home_popular, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder!!.bindingValues(popList[position])

        //set on item click
        holder.itemView.setOnClickListener {
            v -> onItemClickSubject.onNext(holder.adapterPosition)
        }
    }

    public fun getOnItemClickObservable(): Observable<Int>{
        return onItemClickSubject
        //onItemClickSubject.asObservable()
    }

    override fun getItemCount(): Int {
        return popList.size
    }

}