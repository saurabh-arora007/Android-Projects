package com.example.bechdo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            intent = Intent(applicationContext,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}