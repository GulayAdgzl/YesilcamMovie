package com.glyadgzl.yesilcammovie.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.glyadgzl.yesilcammovie.R

class DetailActivity :BaseActivity() {
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
    background(color=colorResource(id = R.color.blackBackground))
    ){
        if(isLoading.value){
            CircularProgressIndicator(modifier=Modifier.align(Alignment.Center))
        }else{
            Column(modifier=Modifier.fillMaxSize().verticalScroll(scrollState)){
                Box(modifier=Modifier.height(400.dp)){
                    Image(
                        contentDescription = null,
                        painter=painterResource(id = R.drawable.back),
                        modifier=Modifier.padding(start=16.dp,top=48.dp)
                        .clickable{onBackClick()}
                    )
                    Image(
                        contentDescription = null,
                        painter=painterResource(id = R.drawable.fav),
                        modifier=Modifier.padding(end=16.dp,top=48.dp)
                        .align(Alignment.TopEnd)
                    )

                    AsyncImage(
                        model=film.Poster,
                        contentDescription = null,
                        modifier=Modifier.fillMaxSize(),
                        contentScale=ContentScale.Crop,
                        alpha=0.1f
                    )
                    AsyncImage(
                        model=film.Poster,
                        contentDescription = null,
                        modifier=Modifier.
                        size(210.dp,300.dp).clip(RoundedCornerShape(30.dp))
                        .align(Alignment.BottomCenter),
                        contentScale=ContentScale.Crop
                   
                    )
                    Box(modifier=Modifier
                    .height(100.dp).fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush=Brush.linearGradient(
                            color= listOf(
                                colorResource(R.color.black2),
                                colorResource(R.color.black1)
                            ),
                            start=Offset(0f,0f),
                            end=Offset(0f,Float.POSITIVE_INFINITY)

                        )
                    )
                    
                    
                    
                    )

                    Text(
                        text=film.Title,
                        style=TextStyle(color=Color.White,fontSize=25.sp),
                        modifier=Modifier
                        .align(Alignment.BottomCenter)
                        .padding(end=16.dp,top=16.dp)
                    )
                }
                    Spacer(modifier=Modifier.height(16.dp))
                    Column(modifier=Modifier.padding(horizontal=16.dp)){
                        Row(
                            horizontalArrangement=Arrangement.SpaceBetween,
                            verticalAlignment=Alignment.CenterVertically
                        ){
                            Icon(
                                painter=painterResource(id = R.drawable.star),
                                contentDescription=null,
                                tint=Color.White
                                modifier=Modifier.padding(horizontal=8.dp)
                            )
                            Text(
                                text="IMBD: ${film.imdb}",
                                style=TextStyle(color=Color.White)
                            )

                            Icon(
                                painter=painterResource(id = R.drawable.time),
                                contentDescription=null,
                                tint=Color.White
                                modifier=Modifier.padding(horizontal=8.dp)
                            )
                            Text(
                                text="Runtime: ${film.Time}",
                                style=TextStyle(color=Color.White)
                            )

                            Icon(
                                painter=painterResource(id = R.drawable.cal),
                                contentDescription=null,
                                tint=Color.White
                                modifier=Modifier.padding(horizontal=8.dp)
                            )
                            Text(
                                text="Release: ${film.Year}",
                                style=TextStyle(color=Color.White)
                            )
                        }
                        Spacer(modifier=Modifier.height(24.dp))
                        Text(
                            text="Summary ",
                            style=TextStyle(color=Color.White,fontSize=16.sp)
                        )
                        Spacer(modifier=Modifier.height(8.dp))

                        Text(
                            text=film.Description,
                            style=TextStyle(color=Color.White,fontSize=14.sp)
                        )
                        Spacer(modifier=Modifier.height(24.dp))
                        Text(
                            text="Actors",
                            style=TextStyle(color=Color.White,fontSize=16.sp)
                        )
                        Spacer(modifier=Modifier.height(8.dp))

                        LazyRow(contentPadding=PaddingValues(8.dp)){
                            items(film.Casts.size){
                                film.Casts[it].Actor?.let{
                                    Text(
                                        text="$it",
                                        style=TextStyle(color=Color.White,fontSize=14.sp),
                                        modifier=Modifier.padding(end=8.dp)
                                    )
                                }
                            }
                        }
                    }
                    LazyRow(contentPadding=PaddingValues(8.dp)){
                        items(film.Casts.size){
                            AsyncImage(
                                model=film.Casts[it].PicUrl,
                                contentDescription=null,
                                modifier=Modifier.size(75.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .padding(4.dp),
                                contentScale=ContentScale.Crop
                            )
                        }
                          

                
            }
        }
    }
}