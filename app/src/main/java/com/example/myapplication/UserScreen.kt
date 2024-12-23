package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserScreen(text:String){
    Column {
        Text(text = text)
    }
}