package com.Compose3.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("discover/movie?sort_by=popularity.desc&api_key=fa3e844ce31744388e07fa47c7c5d8c3")
    suspend fun getPopularMovies(): MovieListResponseDto
}