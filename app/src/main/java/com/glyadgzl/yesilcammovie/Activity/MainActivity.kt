package com.glyadgzl.yesilcammovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.glyadgzl.yesilcammovie.ui.theme.YesilcamMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YesilcamMovieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(onItemClick:(FilmItemModel)->Unit){

    val viewModel=MainViewModel()
    val upcoming=remember{mutableStateOf<FilmItemModel>()}
    val newMoview=remember{mutableStateOf<FilmItemModel>()}

    var showUpcoming by remember{mutableStateOf(true)}
    var showNewMoview by remember{mutableStateOf(true)}

    LaunchedEffect( Unit){
        viewModel.loadUpcoming().observeForever{
            upcoming.clear()
            upcoming.addAll(it)
            showUpcoming=false
        }
       
    }

    LaunchedEffect( Unit){
        viewModel.loadItems().observeForever{
            newMoview.clear()
            newMoview.addAll(it)
            showNewMoview=false
        }
       
    }






    Column(
        modifier=Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(top=60.dp,bottom=100.dp)
    ){
        Text(text="What would you like to watch",style=TextStyle(color=Color.White,fontSize=25.sp),
        modifier=Modifier.align(Alignment.CenterHorizontally).padding(start=16.dp,bottom=16.dp).fillMaxWidth())
        SearchBar(hint="Search for movies")
    }

}