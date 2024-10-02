package com.example.compose3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.Compose3.network.MovieRemoteDataSource
import com.Compose3.network.MovieResponseDto
import com.Compose3.network.RetrofitBuilder
import com.example.compose3.ui.theme.Compose3Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose3Theme {
                MovieApp()
            }
        }
    }
}

@Composable
fun MovieApp() {
    val movieDataSource = MovieRemoteDataSource(RetrofitBuilder)
    var movies by remember { mutableStateOf(listOf<MovieResponseDto>()) }
    var isLoading by remember { mutableStateOf(true) }

    // Llamada a la API para obtener las películas
    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val response = withContext(Dispatchers.IO) {
                movieDataSource.getPopularMovies()
            }
            movies = response.movies // Asigna la lista de películas
        } catch (e: Exception) {
            println("Error fetching movies: ${e.message}")
        }
        isLoading = false
    }

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(movies.size) { movie ->
                MovieItem(movies[movie])
            }
        }
    }
}

@Composable
fun MovieItem(movie: MovieResponseDto) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.poster}"),
                contentDescription = movie.title,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = movie.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieApp()
}