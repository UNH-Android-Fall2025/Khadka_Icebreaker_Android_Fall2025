package com.unh.example.khadka_icebreaker_android_fall2025

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.unh.example.khadka_icebreaker_android_fall2025.ui.theme.Khadka_Icebreaker_Android_Fall2025Theme

class MainActivity : ComponentActivity() {
    private val db = Firebase.firestore
    private var questionBank: MutableList<Questions>? = arrayListOf()
    private var className = "android-fall25"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Khadka_Icebreaker_Android_Fall2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        queryDbOnStart = {getQuestionsFromFirebase()},
                        onGetQuestionClicked = {getQuestion()},
                        onSubmitClicked = { first, last, pref, question, answer ->
                            setResponseToFirebase(first, last, pref, answer, question)
                        }
                    )
                }
            }
        }
    }

    private fun getQuestion():String{
        Log.d("IcebreakerF2025", "Getting a random question...")
        return if (questionBank?.isNotEmpty() == true){
            questionBank!!.random().text
        }else{
            "No questions available."
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
    private fun setResponseToFirebase(
        firstName:String,
        lastName:String,
        prefName:String,
        answer:String,
        question:String,
        onSuccess: () -> Unit = {},
        onFailure: (Exception) -> Unit = {}
    ){
        Log.d("IcebreakerF2025", "Save to Firebase db")

        val student = hashMapOf(
            "firstname" to firstName,
            "lastname" to lastName,
            "prefname" to prefName,
            "answer" to answer,
            "class" to className,
            "question" to question
        )

        db.collection("Students")
            .add(student)
            .addOnSuccessListener { documentReference ->
                Log.d("IcebreakerF2025", "Saved to Firestore with ID: ${documentReference.id}")
                onSuccess()
            }
            .addOnFailureListener { error ->
                Log.w("IcebreakerF2025", "Error saving", error)
                onFailure(error)
            }
    }
}