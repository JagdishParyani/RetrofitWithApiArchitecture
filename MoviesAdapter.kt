package com.example.apiarchitecture.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.apiarchitecture.R
import com.example.apiarchitecture.model.ResModelMovies

class MoviesAdapter(private val result: List<ResModelMovies>, private val mContext: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, null)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: ResModelMovies = result[position]
        holder.bind(movie, mContext, position)

        holder.titlesTxt.setOnClickListener {
            Toast.makeText(mContext,position.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titlesTxt: TextView
        var ratingsTxt: TextView
        var releaseYearsTxt: TextView
        var genresTxt: TextView
        var imgs: ImageView

        init {
            titlesTxt = itemView.findViewById(R.id.titleTxt)
            ratingsTxt = itemView.findViewById(R.id.ratingTxt)
            releaseYearsTxt = itemView.findViewById(R.id.releaseTxt)
            genresTxt = itemView.findViewById(R.id.genreTxt)
            imgs = itemView.findViewById(R.id.img)
        }

        fun bind(movie: ResModelMovies, mContext: Context,pos : Int) {
            titlesTxt.text = "$pos  "+(movie.title)
            ratingsTxt.text = "Rating :" + movie.rating.toString()
            releaseYearsTxt.text = "Year :"+ movie.releaseYear.toString()
            var s = ""
            for (i in movie.genre!!) {
                s = s + i + ","
            }
            s = s.substring(0, s.length - 1)

            genresTxt.text = s

            Glide.with(mContext).load(movie.image).into(imgs);
        }
    }
}