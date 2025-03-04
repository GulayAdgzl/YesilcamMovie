package com.glyadgzl.yesilcammovie

import FilmItem
import FilmItemModel
import MainViewModel
import SearchBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glyadgzl.yesilcammovie.Activity.BaseActivity
import com.glyadgzl.yesilcammovie.ui.theme.YesilcamMovieTheme

class MainActivity :BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(onItemClick = {})
        }
    }
}

@Composable

fun MainScreen(onItemClick: (FilmItemModel) -> Unit) {
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF121212)) // Koyu tema için arka plan rengi
                    .padding(paddingValues) // Scaffold içeriğini uygun hizalamak için
            ) {
                MainContent(onItemClick)
            }
        }
    )
}
@Composable
fun MainContent(onItemClick: (FilmItemModel) -> Unit) {
    val viewModel = MainViewModel()
    val upcomingMovies = remember { mutableStateListOf<FilmItemModel>() }
    val newMovies = remember { mutableStateListOf<FilmItemModel>() }
    
    var isLoadingUpcoming by remember { mutableStateOf(true) }
    var isLoadingNewMovies by remember { mutableStateOf(true) }

    // Filmleri yüklem
    LaunchedEffect(Unit) {
        viewModel.loadUpcoming().observeForever { movies ->
            upcomingMovies.clear()
            upcomingMovies.addAll(movies)
            isLoadingUpcoming = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadItems().observeForever { movies ->
            newMovies.clear()
            newMovies.addAll(movies)
            isLoadingNewMovies = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 60.dp, bottom = 100.dp)
    ) {
        // Başlık
        Text(
            text = "What would you like to watch?",
            style = TextStyle(color = Color.White, fontSize = 25.sp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
        )

        // Arama Çubuğu
        SearchBar(hint = "Search for movies")

        // Yeni Filmler
        SectionTitle("New Movies")
        if (isLoadingNewMovies) {
            LoadingIndicator()
        } else {
            MovieList(newMovies, onItemClick)
        }

        // Yaklaşan Filmler
        SectionTitle("Upcoming Movies")
        if (isLoadingUpcoming) {
            LoadingIndicator()
        } else {
            MovieList(upcomingMovies, onItemClick)
        }
    }
}

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MovieList(movies: List<FilmItemModel>, onItemClick: (FilmItemModel) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(movies) { movie ->
            FilmItem(movie, onItemClick)
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(color = Color(0xFFFFC107), fontSize = 18.sp),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, top = 32.dp, bottom = 8.dp)
    )
}
