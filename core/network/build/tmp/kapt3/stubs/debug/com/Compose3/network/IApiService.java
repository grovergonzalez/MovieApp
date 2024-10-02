package com.Compose3.network;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"Lcom/Compose3/network/IApiService;", "", "getPopularMovies", "Lcom/Compose3/network/MovieListResponseDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public abstract interface IApiService {
    
    @retrofit2.http.GET(value = "discover/movie?sort_by=popularity.desc&api_key=fa3e844ce31744388e07fa47c7c5d8c3")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPopularMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.Compose3.network.MovieListResponseDto> $completion);
}