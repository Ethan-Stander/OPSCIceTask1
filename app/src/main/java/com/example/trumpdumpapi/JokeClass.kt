package com.example.trumpdumpapi

import com.google.android.gms.tasks.Tasks
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class JokeClass {
    var jokeID: String? = null
    var joke: String? = null
    var author: String? = null
    var picture: String? = null

    companion object {
        private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("jokes")

        suspend fun insertJoke(joke: JokeClass) {
            // Generate a new unique ID using push()
            val newJokeRef = database.push()
            // Set the generated ID to the jokeID attribute
            joke.jokeID = newJokeRef.key
            // Push the new JokeClass object to the Firebase database
            newJokeRef.setValue(joke)
        }
        suspend fun getAllJokes(): List<JokeClass> {
            val jokeList = mutableListOf<JokeClass>()

            // Asynchronously fetch the data from Firebase Realtime Database using await()
            val snapshot = database.get().await()

            snapshot?.let {
                for (jokeSnapshot in it.children) {
                    val joke = jokeSnapshot.getValue(JokeClass::class.java)
                    joke?.let { jokeList.add(it) }
                }
            }

            // Return the list inside the let block
            return jokeList
        }
    }

}
