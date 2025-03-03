package com.glyadgzl.yesilcammovie

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}

@Composable
@Preview
fun LoginScreen(){
    Box(
        modifier=Modifier.fillMaxSize().background(color=colorResource(R.color.blackBackground))
    ){

        Image(painter=painterResource(id=R.drawable.bg1),
        contentScale=ContentScale.Crop,
        contentDescription=null,
        modifier=Modifier.matchParentSize()
        )
        Column(
            modifier=Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(horizontal=32.dp,vertical=16.dp)
        ){
            Spacer(modifier=Modifier.height(100.dp))
            Text(text="Log in",
            style=TextStyle(color=Color.White,fontSize=50.sp,fontWeight=FontWeight.Bold),
            modifier=Modifier.fillMaxWidth()
            )
            Spacer(modifier=Modifier.height(128.dp))

        }
    }
}


