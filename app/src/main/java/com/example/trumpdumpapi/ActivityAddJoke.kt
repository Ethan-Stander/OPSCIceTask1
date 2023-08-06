package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import android.widget.Toast


class ActivityAddJoke  : AppCompatActivity() {


    private lateinit var jokeEditText: EditText
    private lateinit var authorEditText: EditText
    private lateinit var pictureEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)

        supportActionBar?.hide()


        jokeEditText = findViewById(R.id.txtAddJoke)
        authorEditText = findViewById(R.id.txtName)
        pictureEditText = findViewById(R.id.imageView2)
        val addButton: Button = findViewById(R.id.btnAdd)


        addButton.setOnClickListener {
            val jokeText = jokeEditText.text.toString()
            val author = authorEditText.text.toString()
            val pictureUrl = pictureEditText.text.toString()

            val joke = JokeClass()
            joke.joke = jokeText
            joke.author = author
            joke.picture = pictureUrl

            addJokeToFirebase(joke)
        }
    }

    private fun addJokeToFirebase(joke: JokeClass) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                JokeClass.insertJoke(joke)

                runOnUiThread {
                    Toast.makeText(this@ActivityAddJoke, "Joke added successfully!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this@ActivityAddJoke, "Error adding joke!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}