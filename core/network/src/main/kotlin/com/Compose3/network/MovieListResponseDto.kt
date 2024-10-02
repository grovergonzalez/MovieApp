package com.Compose3.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListResponseDto(
    @Json(name = "results")
    val movies: List<MovieResponseDto> // Lista de películas
)