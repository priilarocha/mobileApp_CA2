package com.example.ca2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_movie2)
        // Get the movie object from the intent extras (if it exists) and cast it to a Movie object
        val movie: Movie? = intent.getSerializableExtra("movie") as? Movie

        // Check if the movie object is not null
        if (movie != null) {
            // Call the setupMovieData method to set the UI elements with the movie data from the object we just created above (movie)
            setupMovieData(movie)
        } else {
            // If the movie object is null, log an error message
            Log.e("MovieActivity", "Movie object is null")
        }
    }

    @SuppressLint("SetTextI18n", "WrongViewCast")
    private fun setupMovieData(movie: Movie) {

        // Find UI elements and assign them to variables for later use in the method
        val movieImage: ImageView = findViewById(R.id.movieImage)
        val movieTitle: TextView = findViewById(R.id.movieTitle)
        val movieCertification: TextView = findViewById(R.id.movieCert)
        val movieActors: TextView = findViewById(R.id.movieStarName)
        val movieDescription: TextView = findViewById(R.id.plotTextView)
        val movieRunningTime: TextView = findViewById(R.id.movieTimeValue)
        val seatsSelected: TextView = findViewById(R.id.numberSeatsSelected)
        val plusButton: MaterialButton = findViewById(R.id.addSeats)
        val minusButton: MaterialButton = findViewById(R.id.removeSeats)
        val movieSeatsRemaining: TextView = findViewById(R.id.numberSeatsRemaining)

        // Load the image into the image view using Picasso
        Picasso.get()
            .load(movie.image)
            .into(movieImage)

        // Set text values for the text views
        movieTitle.text = movie.title
        movieCertification.text = movie.contentRating
        movieActors.text = movie.stars
        movieDescription.text = movie.plot
        movieRunningTime.text = movie.runtimeStr
        seatsSelected.text = movie.seats_selected.toString()

        // Check if the movie is sold out and set the text view accordingly
        if (movie.seats_remaining == 0) {
            movieSeatsRemaining.text = getString(R.string.sold_out)
        } else {
            movieSeatsRemaining.text = getString(R.string.seats_remaining, movie.seats_remaining)
        }

//        // Set back button click listener to pass the updated movie object back to the main activity
//        backButton.setOnClickListener {
//            val resultIntent = Intent()
//            resultIntent.putExtra("updatedMovie", movie)
//            setResult(Activity.RESULT_OK, resultIntent)
//            finish()
//        }

        // function to update the button state, so if the seats remaining is 0, the plus button is disabled
        fun updateButtonStates() {
            plusButton.isEnabled = movie.seats_remaining > 0
            minusButton.isEnabled = movie.seats_selected > 0
        }

        updateButtonStates()

        // by clicking the plus button, the seats selected is increased by 1 and the seats remaining is decreased by 1
        plusButton.setOnClickListener {
            if (movie.seats_remaining > 0) {
                movie.seats_selected++
                movie.seats_remaining--
                seatsSelected.text = movie.seats_selected.toString()
                movieSeatsRemaining.text = getString(R.string.seats_remaining, movie.seats_remaining)
                updateButtonStates()
            }
        }

        // by clicking the minus button, the seats selected is decreased by 1 and the seats remaining is increased by 1
        minusButton.setOnClickListener {
            if (movie.seats_selected > 0) {
                movie.seats_selected--
                movie.seats_remaining++
                seatsSelected.text = movie.seats_selected.toString()
                movieSeatsRemaining.text = getString(R.string.seats_remaining, movie.seats_remaining)
                updateButtonStates()
            }
        }
    }

    // override the back button to update the movie object before going back to the main activity
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val movie: Movie? = intent.getSerializableExtra("movie") as? Movie
        if (movie != null) {
            val resultIntent = Intent()
            resultIntent.putExtra("updatedMovie", movie)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        super.onBackPressed()
    }
}