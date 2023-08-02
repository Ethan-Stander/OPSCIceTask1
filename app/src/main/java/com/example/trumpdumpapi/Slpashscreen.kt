package com.example.trumpdumpapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Slpashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slpashscreen)

        supportActionBar?.hide()
    }
}