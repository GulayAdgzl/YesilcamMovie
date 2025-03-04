package com.glyadgzl.yesilcammovie

import FilmItemModel
import MainViewModel
import SearchBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glyadgzl.yesilcammovie.ui.theme.YesilcamMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YesilcamMovieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  MainContent  ()
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
        Text(text="What would you like to watch",style= TextStyle(color= Color. White,fontSize=25. sp),
        modifier=Modifier.align(Alignment.CenterHorizontally).padding(start=16.dp,bottom=16.dp).fillMaxWidth())
        SearchBar(hint="Search for movies")
        SectionTitle("New Moview")
        if(showNewMoview){
            Box(
                modifier=Modifier.fillMaxWidth().height(50.dp),contentAlignment=Alignment.Center
                ){
                CircularProgressIndicator()
               }
        }else{
            LazyRow(
                horizontalArrangement=Arrangement.spacedBy(8.dp),
                centerPadding=PaddingValues(horizontal=16.dp)
            ){
                items(newMoview){
                    item->
                }
            }
        }
    }

}

@Composable
fun SectionTitle(title:String){
    Text(
        text=title,
        style= TextStyle(color= Color(0xffffc107),fontSize=18. sp),
        modifier=Modifier.padding(start=16.dp,top=32.dp,bottom=8.dp),
        fontWeight=FontWeight.Bold
    )
}