package com.example.trumpdumpapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AcivityAboutUs : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        supportActionBar?.hide()

        val button = findViewById<Button>(R.id.btnNext)
        button.setOnClickListener(
            {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            })

    }
}