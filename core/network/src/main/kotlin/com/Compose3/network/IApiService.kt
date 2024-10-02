package com.Compose3.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("api_key") apiKey: String = "fa3e844ce31744388e07fa47c7c5d8c3"
    ): MovieResponse
}