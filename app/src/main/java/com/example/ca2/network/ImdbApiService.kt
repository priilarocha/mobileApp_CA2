package com.example.ca2.network

import com.example.ca2.Movie
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://imdb-api.com/en/API/InTheaters/k_eoq9atnd"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object ImdbApi {
    val retrofitService : ImdbApiService by lazy {
        retrofit.create(ImdbApiService::class.java)
    }
}

/**
 * A public interface that exposes the [getMovieTitle] method
 */
interface ImdbApiService {
    @GET("https://imdb-api.com/en/API/InTheaters/k_eoq9atnd")
    suspend fun getMovieTitle(): List<Movie>
}


