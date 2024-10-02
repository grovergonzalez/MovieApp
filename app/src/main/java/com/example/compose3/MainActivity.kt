package com.example.compose3

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.Compose3.network.MovieRemoteDataSource
import com.Compose3.network.MovieResponseDto
import com.Compose3.network.RetrofitBuilder
import com.example.compose3.ui.theme.Compose3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose3Theme {
                Scaffold (modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                    MovieApp(modifier = Modifier.padding(innerPadding), context = applicationContext)
                }
            }
        }
    }
}

@Composable
fun MovieApp(
    modifier: Modifier = Modifier, context: Context
) 
{
    val movieDataSource = MovieRemoteDataSource(RetrofitBuilder)
    
    var movies by remember { mutableStateOf(listOf<MovieResponseDto>()) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember {
        mutableStateOf("")
    }
    
    LaunchedEffect(Unit) {
        isLoading = true
        try {
                movies = movieDataSource.getPopularMovies().movies
        } catch (e: Exception) {
            errorMessage = "Error capturing movies: ${e.message}"
        } finally {
            isLoading = false
        }
    }
    
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text(
           modifier = Modifier.padding(16.dp),
           text = stringResource(id = R.string.movie_ui_title)
       )
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(16.dp)
            ) {
                items(movies.size) {
                    index ->
                    val movie = movies[index]
                    MovieItem(movie = movie)
                }
            }
        }
    }
}

@Composable
fun MovieItem(
    movie: MovieResponseDto)
{
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(2 / 3f),
        shape = RoundedCornerShape(7.dp))
    {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.poster}"),
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(modifier = Modifier.padding(2.dp),
                text = movie.title,
                color = Color.Blue,
                textAlign = TextAlign.Center)
        }
    }
}