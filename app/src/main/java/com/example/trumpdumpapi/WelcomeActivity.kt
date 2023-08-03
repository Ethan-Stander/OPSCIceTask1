package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome)

        supportActionBar?.hide()
        val button = findViewById<Button>(R.id.btnNext)
        button.setOnClickListener(
            {
                val intent = Intent(this,AcivityAboutUs::class.java)
                startActivity(intent)
            })




    }


}