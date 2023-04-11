package com.example.ca2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.ca2.network.Movie


class MainActivity : AppCompatActivity(R.layout.activity_main){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val movieArray = Array(50) { Movie("Name $it", "${it * 10}") }
        val movieAdapter = MovieAdaptor(moviesArray = movieArray)
        recyclerView.adapter = movieAdapter
    


    }
}

