package com.Compose3.network

import com.squareup.moshi.Json

data class Movie(
    val id: Int,
    val title: String,
    @Json(name ="poster_path") val posterPath: String
)

data class MovieResponse(
    val results: List<Movie>
)