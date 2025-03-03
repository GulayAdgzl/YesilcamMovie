package com.glyadgzl.yesilcammovie
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IntroScreen(onGetInClick = {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            })
        }
    }
}


@Composable
@Preview
fun IntroScreenPreview(){
    IntroScreen(onGetInClick={})
}



@Composable
fun IntroScreen(onGetInClick:()->Unit){
    Box(
        modifier=Modifier.fillMaxSize().background(color= colorResource(R.color
            .blackBackground))
    ){
        Column(
            modifier=Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ){
            HeaderSection()
            FootorSection(onGetInClick)

        }
    }
}

@Composable
fun HeaderSection(){
    Box(modifier=Modifier.fillMaxWidth().height(650. dp)){
        Image(painter = painterResource(id=R.drawable.bg1), contentDescription = null,
            contentScale=ContentScale.Crop,
            modifier=Modifier.matchParentSize())
        Column(
horizontalAlignment= Alignment.CenterHorizontally,
verticalArrangement= Arrangement.Center,
modifier=Modifier.matchParentSize()
        ){
Image(painter=painterResource(id=R.drawable.woman), contentDescription=null,
modifier=Modifier.size(360.dp))
Spacer(modifier=Modifier.height(32.dp))
            
        }
    }
}
@Composable
fun FootorSection(onGetInClick:()->Unit){
    Box(modifier=Modifier.fillMaxWidth().height(200.dp)){
        Image(painter=painterResource(id=R.drawable.bg2), contentDescription=null,
            contentScale=ContentScale.Crop,
            modifier=Modifier.matchParentSize())
       Button(
        modifier=Modifier.size(200.dp,50.dp).align(Alignment.Center),
        shape= RoundedCornerShape(50.dp),
        onClick=onGetInClick,
        border= BorderStroke(
            width=4.dp,
            brush= Brush.linearGradient(
                colors=listOf(
                    colorResource(id=R.color.purple_200),
                    colorResource(id=R.color.green)
                )
            )

           // colors=ButtonDefaults.buttonColors(containerColor=Color.Transparent,contentColor=Color.White)
        ),colors= ButtonDefaults.buttonColors(containerColor= Color.Transparent,contentColor=Color.White)
       ){
Text(text="Get Started",fontSize=18. sp,color=Color.White)
       }
    
    }}