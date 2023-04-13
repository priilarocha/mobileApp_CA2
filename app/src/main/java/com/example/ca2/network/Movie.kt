package com.example.ca2.network

data class Movie(
    val title: String,
    val image: String,
    val contentRating: String,
    val plot: String,
    var stars: String,
    var runtimeStr: String,
    var seats_remaining: String,
    var seats_selected: String
)