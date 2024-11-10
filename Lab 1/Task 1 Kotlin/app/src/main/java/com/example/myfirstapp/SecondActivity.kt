package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Retrieve and display the passed message
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textView: TextView = findViewById(R.id.textViewSecond)
        textView.text = message

        // Set up the "Back to Main Activity" button
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish() // This will close SecondActivity and return to MainActivity
        }
    }
}
