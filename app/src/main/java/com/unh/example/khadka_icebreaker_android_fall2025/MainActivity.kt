package com.unh.example.khadka_icebreaker_android_fall2025

import android.os.Bundle
import android.util.Log
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
import com.unh.example.khadka_icebreaker_android_fall2025.ui.theme.Khadka_Icebreaker_Android_Fall2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Khadka_Icebreaker_Android_Fall2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onGetQuestionClicked = {getQuestionsFromFirebase()},
                        onSubmitClicked = {setResponseToFirebase()}
                        )
                }
            }
        }
    }
    private fun getQuestionsFromFirebase(){
        Log.d("IcebreakerF2025", "Get from Firebase db")
    }
    private fun setResponseToFirebase(){
        Log.d("IcebreakerF2025", "Save to Firebase db")
    }
}