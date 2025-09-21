package com.unh.example.khadka_icebreaker_android_fall2025

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top=100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Icebreaker!",
            fontSize = 36.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MaterialTheme{
        MainScreen()
    }
}

