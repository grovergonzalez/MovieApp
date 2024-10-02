package com.Compose3.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieResponseDto(
    @Json(name = "title")
    val title: String,
    @Json(name = "poster_path")
    val poster: String) {

}