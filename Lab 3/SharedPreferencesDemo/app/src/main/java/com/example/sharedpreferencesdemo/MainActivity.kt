package com.example.sharedpreferencesdemo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var greetingTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var loadButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        greetingTextView = findViewById(R.id.tv_greeting)
        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        cityEditText = findViewById(R.id.et_city)
        saveButton = findViewById(R.id.btn_save)
        loadButton = findViewById(R.id.btn_load)
        clearButton = findViewById(R.id.btn_clear)

        // Set up button click listeners
        saveButton.setOnClickListener {
            saveData()
        }

        loadButton.setOnClickListener {
            loadData()
        }

        clearButton.setOnClickListener {
            clearData()
        }
    }

    // Function to save the name, age, and city in SharedPreferences
    private fun saveData() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString()
        val city = cityEditText.text.toString()

        // Check if any input is empty
        if (name.isEmpty() || age.isEmpty() || city.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Get the SharedPreferences object
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        // Open the editor to write to SharedPreferences
        val editor = sharedPreferences.edit()

        // Save the data with keys
        editor.putString("userName", name)
        editor.putString("userAge", age)
        editor.putString("userCity", city)

        // Apply changes to save the data
        editor.apply()

        // Show a confirmation message
        greetingTextView.text = "Data saved!"
    }

    // Function to load the name, age, and city from SharedPreferences
    private fun loadData() {
        // Get the SharedPreferences object
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        // Retrieve the saved data using keys
        val savedName = sharedPreferences.getString("userName", "No name saved")
        val savedAge = sharedPreferences.getString("userAge", "No age saved")
        val savedCity = sharedPreferences.getString("userCity", "No city saved")

        // Display the saved data in the TextView
        greetingTextView.text = "Welcome, $savedName!\nAge: $savedAge\nCity: $savedCity"
    }

    // Function to clear the saved data from SharedPreferences
    private fun clearData() {
        // Get the SharedPreferences object
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        // Open the editor to clear the saved data
        val editor = sharedPreferences.edit()

        // Clear all saved data
        editor.clear()

        // Apply changes to clear the data
        editor.apply()

        // Show a confirmation message
        greetingTextView.text = "Data cleared!"
    }
}
