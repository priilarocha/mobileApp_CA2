package com.example.ca2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdaptor(private var moviesArray: List<Movie>, private val onItemClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_movie, parent, false)
        return MovieViewHolder(view)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesArray[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClick(movie)
        }
    }
    override fun getItemCount(): Int {
        return moviesArray.size
    }

    fun updateMovies(newMovies: List<Movie>) {
        moviesArray = newMovies
        notifyDataSetChanged()
    }

    fun updateMovie(updatedMovie: Movie) {
        val index = moviesArray.indexOfFirst { it.id == updatedMovie.id }
        if (index != -1) {
            val updatedMovies = moviesArray.toMutableList()
            updatedMovies[index] = updatedMovie
            moviesArray = updatedMovies
            notifyDataSetChanged()
        }
    }
}

//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//            holder.movieTitleTextView.text = moviesArray[position].title
//            holder.movieStarNameTextView.text = moviesArray[position].stars
//            holder.movieTimeValueTextView.text = moviesArray[position].runtimeStr
//            holder.movieSeatsRemainingTextView.text = moviesArray[position].seats_remaining.toString()
//    }
//
//        class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val movieTitleTextView: TextView
//            val movieStarNameTextView: TextView
//            val movieTimeValueTextView: TextView
//            val movieSeatsRemainingTextView: TextView
//
//            init {
//                // Define click listener for the ViewHolder's View
//                movieTitleTextView = view.findViewById(R.id.movieTitleTextView)
//                movieStarNameTextView = view.findViewById(R.id.movieStarNameTextView)
//                movieTimeValueTextView = view.findViewById(R.id.movieTimeValueTextView)
//                movieSeatsRemainingTextView = view.findViewById(R.id.movieSeatsRemainingTextView)
//            }

