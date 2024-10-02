package com.Compose3.network

class MovieRemoteDataSource(
    val retrofitService: RetrofitBuilder
) {
    suspend fun getPopularMovies(): MovieListResponseDto {
        return retrofitService.apiService.getPopularMovies()
    }
}
