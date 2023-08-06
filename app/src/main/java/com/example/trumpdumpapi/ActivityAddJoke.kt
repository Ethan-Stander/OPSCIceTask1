package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class ActivityAddJoke  : AppCompatActivity() {


    private lateinit var jokeEditText: EditText
    private lateinit var authorEditText: EditText
    private lateinit var pictureEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_joke)

        supportActionBar?.hide()




        val imgMenu = findViewById<ImageView>(R.id.imgAddJoke)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout_addjoke)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        imgMenu.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_about -> {
                    // Handle click for About item
                    val intent = Intent(this, AcivityAboutUs::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }


                // Handle other navigation items as needed

                else -> false
            }
        }




        jokeEditText = findViewById(R.id.txtAddJoke)
        authorEditText = findViewById(R.id.txtName)

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