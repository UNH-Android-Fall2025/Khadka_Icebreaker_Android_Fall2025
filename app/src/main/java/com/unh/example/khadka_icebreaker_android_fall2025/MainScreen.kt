package com.unh.example.khadka_icebreaker_android_fall2025

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(modifier: Modifier=Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var prefName by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

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

        OutlinedTextField(
            enabled = true,
            singleLine = true,
            modifier = Modifier.padding(top = 10.dp),
            value = firstName,
            onValueChange = {firstName=it},
            label = {Text(stringResource(R.string.first_name_text))}
        )

        OutlinedTextField(
            enabled = true,
            singleLine = true,
            modifier = Modifier.padding(top = 10.dp),
            value = lastName,
            onValueChange = {lastName=it},
            label = {Text(stringResource(R.string.last_name_text))}
        )

        OutlinedTextField(
            enabled = true,
            singleLine = true,
            modifier = Modifier.padding(top = 10.dp),
            value = prefName,
            onValueChange = {prefName=it},
            label = {Text(stringResource(R.string.pref_name_text))}
        )

        Button(
            onClick = {
                Log.d("IcebreakerFall2025", "Pressed")
            },
            modifier = Modifier.padding(top=20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            )
        ){
            Text(
                text = "Get a New Random Question",
                fontSize = 18.sp
            )
        }
        Text(
            text = question,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        )
        OutlinedTextField(
            enabled = true,
            singleLine = true,
            modifier = Modifier.padding(top = 10.dp),
            value = answer,
            onValueChange = {answer=it},
            label = {Text(stringResource(R.string.answer_text))}
        )
        Button(
            onClick = {
                Log.d("IcebreakerFall2025", "Pressed")
            },
            modifier = Modifier.padding(top=20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            )
        ){
            Text(
                text = "Submit",
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MaterialTheme{
        MainScreen()
    }
}

