package com.unh.example.khadka_icebreaker_android_fall2025

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
            text = stringResource(R.string.header_text),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.header_sub_text),
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal
        )

        var firstName by remember { mutableStateOf("firstName") }

        OutlinedTextField(
            enabled = true,
            singleLine = true,
            modifier = Modifier.padding(top = 50.dp),
            value = firstName,
            onValueChange = {firstName=it},
            label = {Text(stringResource(R.string.first_name_text))}
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

