package com.example.ca2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ca2.network.Movie


class MovieAdaptor(private val moviesArray: Array<Movie>) : RecyclerView.Adapter<MovieAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.movieTitleTextView.text = moviesArray[position].title
//            holder.movieStarNameTextView.text = moviesArray[position].stars
//            holder.movieTimeValueTextView.text = moviesArray[position].runtimeStr.toString()
            holder.movieSeatsRemainingTextView.text = moviesArray[position].seats_remaining.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitleTextView: TextView
        val movieStarNameTextView: TextView
        val movieTimeValueTextView: TextView
        val movieSeatsRemainingTextView: TextView
        init {
            // Define click listener for the ViewHolder's View
            movieTitleTextView = view.findViewById(R.id.movieTitleTextView)
            movieStarNameTextView = view.findViewById(R.id.movieStarNameTextView)
            movieTimeValueTextView = view.findViewById(R.id.movieTimeValueTextView)
            movieSeatsRemainingTextView = view.findViewById(R.id.movieSeatsRemainingTextView)
        }
    }
}