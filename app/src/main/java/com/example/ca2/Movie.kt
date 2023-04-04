package com.example.ca2

data class Movie (
    val title: String,
    val image: String,
    val contentRating: String,
    val plot: String,
    var stars: String,
    var runtimeStr: String,
//    var seats_remaining: Int,
//    var seats_selected: Int = 0
)