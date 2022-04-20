package com.example.scuffedtictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Btn = findViewById<Button>(R.id.Btn)

        Btn.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)

        }

    }
}