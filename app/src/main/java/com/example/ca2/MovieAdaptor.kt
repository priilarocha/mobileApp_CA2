package com.example.ca2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_movie.view.*

class MovieAdaptor(
    var movies: List<Movie>
) : RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.apply {
            movieTitleTextView.text = movies[position].name
            movieStarNameTextView.text = movies[position].starring
            movieTimeValueTextView.text = movies[position].running_time_mins.toString()
            movieSeatsRemainingTextView.text = movies[position].seats_remaining.toString()

        }
    }
}