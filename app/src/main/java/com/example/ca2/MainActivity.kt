package com.example.ca2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.util.*
import kotlin.random.Random
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var movieAdaptor: MovieAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load the hero image using Picasso and a random seed to get a different image each time the app is opened
//        val heroImage = findViewById<ImageView>(R.id.recyclerImage)
//        val randomSeed = Random.nextInt(1000)
//        val url2 = "https://picsum.photos/seed/$randomSeed/2080/920?grayscale&blur=10"
//        Picasso.get().load(url2).into(heroImage)

        //Created JSON file on Gist
        val url = "https://gist.githubusercontent.com/priilarocha/06a701cc3ff144890a6227892727e066/raw/8fc535959bbf44a6dcd91833884d80e7ba44ddbc/movie.json"

        // Create the adapter and pass in the click listener lambda function
        movieAdaptor = MovieAdaptor(emptyList()) { movie ->
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra("movie", movie)
            startActivityForResult(intent, MOVIE_ACTIVITY_REQUEST_CODE)
        }

            // Create the recycler view and set the adapter and layout manager
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = movieAdaptor

            // Make the HTTP request to get the movie data
            url.makeHTTPRequest()
        }

        // This method makes an HTTP request to the given URL and updates the UI with the data
        private fun String.makeHTTPRequest() {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(this)
                .build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("MainActivity", "Failed to make HTTP request")
                }

                // This method is called when the HTTP request is successful
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val body = response.body?.string()
                        val gson = Gson()
                        val movies: Array<Movie> = gson.fromJson(body, Array<Movie>::class.java)

                        // Update the seats remaining for each movie
                        movies.forEach { movie ->
                            movie.seats_remaining = Random.nextInt(0, 16)
                        }

                        // Update the UI with the data
                        runOnUiThread {
                            movieAdaptor.updateMovies(movies.toList())
                        }
                    }
                }
            })
        }

        // This method is called when the MovieActivity finishes and returns the updated movie data
        @Deprecated("Deprecated in Java")
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            // Check if the request code and result code are correct and update the movie data
            if (requestCode == MOVIE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
                val updatedMovie = data?.getSerializableExtra("updatedMovie") as? Movie
                updatedMovie?.let {
                    movieAdaptor.updateMovie(it)
                }
            }
        }

        // Companion object to store the request code for the MovieActivity
        companion object {
            const val MOVIE_ACTIVITY_REQUEST_CODE = 1001
        }
    }
//-------------------test-------------------
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        val movieArray = Array(5) { Movie("Movie $it","Image $it", "ContentRating $it", "Plot $it", "Stars $it", "RunTime $it", "SeatsRemaining $it", "SeatsSelected $it") }
//        val movieAdapter = MovieAdaptor(moviesArray = movieArray)
//        recyclerView.adapter = movieAdapter
//
//            fun String.makeHTTPRequest() {
//                val client = OkHttpClient()
//                val request = Request.Builder()
//                    .url(this)
//                    .build()
//                client.newCall(request).enqueue(object : Callback {
//                    override fun onFailure(call: Call, e: IOException) {
//                        Log.e("MainActivity", "Failed to make HTTP request")
//                    }
//
//                    // This method is called when the HTTP request is successful
//                    override fun onResponse(call: Call, response: Response) {
//                        if (response.isSuccessful) {
//                            val body = response.body?.string()
//                            val gson = Gson()
//                            val movies: Array<Movie> = gson.fromJson(body, Array<Movie>::class.java)
//                        }
//
//                    }
//                })
//            }
//        }
//  }
////}


