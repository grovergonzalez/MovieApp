package com.Compose3.network;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/Compose3/network/MovieResponseDto;", "", "title", "", "poster", "(Ljava/lang/String;Ljava/lang/String;)V", "getPoster", "()Ljava/lang/String;", "getTitle", "network_debug"})
public final class MovieResponseDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String poster = null;
    
    public MovieResponseDto(@com.squareup.moshi.Json(name = "title")
    @org.jetbrains.annotations.NotNull
    java.lang.String title, @com.squareup.moshi.Json(name = "poster_path")
    @org.jetbrains.annotations.NotNull
    java.lang.String poster) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPoster() {
        return null;
    }
}