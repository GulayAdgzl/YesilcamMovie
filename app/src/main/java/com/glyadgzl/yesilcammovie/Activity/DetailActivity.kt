package com.glyadgzl.yesilcammovie.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.glyadgzl.yesilcammovie.R

class DetailActivity : AppCompatActivity() {
    private lateinit var filItem:FilmItemModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filmItem=(intent.getSerializableExtra("object") as FilmItemModel)

        setContent{
            DetailScreen(filmItem,onBackClick = {finish()})
        }
    }
}


@Composable
fun DeatilScreen(film:FilItemModel,onBackClick:()->Unit){
    val scrollState = rememberScrollState()
    val isLoading=remember{mutableStateOf(false)}

    Box(modifier=Modifier.fillMaxSize().
    background(color=colorResource(id = R.color.background))
    )
}