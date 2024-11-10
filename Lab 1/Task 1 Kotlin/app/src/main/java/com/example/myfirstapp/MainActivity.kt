package com.example.myfirstapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val buttonNavigate = findViewById<Button>(R.id.buttonNavigate)

        // Change text and color when the button is clicked and show a Toast
        button.setOnClickListener {
            textView.text = "Button Clicked!"
            textView.setTextColor(Color.RED)
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        // Navigate to SecondActivity when buttonNavigate is clicked
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!")
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
