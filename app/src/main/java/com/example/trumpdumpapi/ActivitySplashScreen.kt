package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.constraintlayout.widget.ConstraintLayout

class ActivitySplashScreen : AppCompatActivity() {
   @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()


        val layout = findViewById<ConstraintLayout>(R.id.clSplashScreen)

        layout.setOnClickListener()
        {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}