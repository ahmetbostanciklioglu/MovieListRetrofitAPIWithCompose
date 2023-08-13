package com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.model.Movie
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.movie.MovieItem
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.movie.MovieViewModel
import com.ahmet.bostanciklioglu.movielistretrofitapiwithcompose.ui.theme.MovieListRetrofitAPIWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListRetrofitAPIWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { _, movie ->
            MovieItem(movie = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieListRetrofitAPIWithComposeTheme {
        val movie = Movie(
            "Coco",
            "https://howtodoandroid.com/images/coco.jpg",
            "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
            "Latest"
        )
        MovieItem(movie = movie)
    }
}