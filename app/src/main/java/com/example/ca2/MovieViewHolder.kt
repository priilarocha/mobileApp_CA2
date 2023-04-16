package com.example.ca2

import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
    private val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
    private val movieClassification: TextView = itemView.findViewById(R.id.movieCert)
    private val movieActors: TextView = itemView.findViewById(R.id.movieStarName)
    private val movieRunningTime: TextView = itemView.findViewById(R.id.movieTimeValue)
    private val movieSeatsRemaining: TextView = itemView.findViewById(R.id.movieSeatsRemaining)
    private val movieSeatIcon: ImageView = itemView.findViewById(R.id.movieSeatsImage)

    // Bind the data to the views in the layout
    fun bind(movie: Movie) {

        // Load the image using Picasso library
        Picasso.get()
            .load(movie.image)
            .into(movieImage)

        // Set the text of the views to the data in the movie object
        movieTitle.text = movie.title
        movieClassification.text = movie.contentRating
        movieActors.text = movie.stars
        movieRunningTime.text = movie.runtimeStr

        // Set the text color of the seats remaining text view
        when {
            movie.seats_selected > 0 -> {
                movieSeatsRemaining.text = itemView.context.getString(R.string.seats_selected, movie.seats_selected)
                movieSeatsRemaining.setTextColor(Color.GREEN)
                movieSeatIcon.setColorFilter(Color.GREEN)
            }
            movie.seats_remaining == 0 -> {
                movieSeatsRemaining.text = itemView.context.getString(R.string.sold_out)
                movieSeatsRemaining.setTextColor(Color.parseColor("#CAC4D0"))
                movieSeatIcon.clearColorFilter()
            }
            else -> {
                movieSeatsRemaining.text =
                    itemView.context.getString(R.string.seats_remaining, movie.seats_remaining)
                movieSeatsRemaining.setTextColor(Color.parseColor("#CAC4D0"))
                movieSeatIcon.clearColorFilter()
            }
        }
    }
}

