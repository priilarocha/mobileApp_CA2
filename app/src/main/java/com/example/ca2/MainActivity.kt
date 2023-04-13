package com.example.ca2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ca2.network.Movie


class MainActivity : AppCompatActivity(R.layout.activity_main){
//    private fun Movie(title: String, image: String, seats_remaining: String, s: String): Movie {
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val selectSeat: Button = findViewById(R.id.addSeatsButton)
//        selectSeat.setOnClickListener { addSubSeat() }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val movieArray = Array(5) { Movie("Movie $it","Image $it", "ContentRating $it", "Plot $it", "Stars $it", "RunTime $it", "SeatsRemaining $it", "SeatsSelected $it") }
        val movieAdapter = MovieAdaptor(moviesArray = movieArray)
        recyclerView.adapter = movieAdapter

    }

}

//    private fun addSubSeat() {
//        val plus = seatsSelected(1)
//        val minus = seatsSelected(-1)
//
//        val addSeatsButton = findViewById<Button>(R.id.addSeatsButton)
//        addSeatsButton.setOnClickListener {
//            seatsRemaining(1)
//        }



//    }


//
//private fun seatsRemaining(i: Int): Any {
//        TODO()
//
//    }
//
//    fun seatsSelected(i: Int): Any {
//        TODO()
//
//}


