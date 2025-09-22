package com.unh.example.khadka_icebreaker_android_fall2025

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.unh.example.khadka_icebreaker_android_fall2025.ui.theme.Khadka_Icebreaker_Android_Fall2025Theme

class MainActivity : ComponentActivity() {
    private val db = Firebase.firestore
    private var questionBank: MutableList<Questions>? = arrayListOf()
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
        db.collection("Questions")
            .get()
            .addOnSuccessListener{result ->
                questionBank = mutableListOf()
                for (document in result){
                    val question = document.toObject(Questions::class.java)
                    questionBank!!.add(question)
                    Log.d("IcebreakerF2025", "$question")
                }
            }
            .addOnFailureListener{error ->
                Log.d("IcebreakerF2025", "error", error)
            }
    }
    private fun setResponseToFirebase(){
        Log.d("IcebreakerF2025", "Save to Firebase db")
    }
}