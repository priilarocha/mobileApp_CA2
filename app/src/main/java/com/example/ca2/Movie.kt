package com.example.ca2

data class Movie (
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    var starring: String,
    var running_time_mins: Int,
    var seats_remaining: Int,
    var seats_selected: Int = 0
)