package com.example.sqlitedemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Add global variables inside the class
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var addButton: Button
    private lateinit var viewButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Set the layout before accessing views

        // Initialize DatabaseHelper
        databaseHelper = DatabaseHelper(this)

        // Initialize UI components
        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        resultTextView = findViewById(R.id.tv_result)
        addButton = findViewById(R.id.btn_add)
        viewButton = findViewById(R.id.btn_view)
        updateButton = findViewById(R.id.btn_update)
        deleteButton = findViewById(R.id.btn_delete)

        // Set button click listeners
        addButton.setOnClickListener {
            addUser()
        }

        viewButton.setOnClickListener {
            viewUsers()
        }

        updateButton.setOnClickListener {
            updateUser()
        }

        deleteButton.setOnClickListener {
            deleteUser()
        }
    }


    // addUser Function
    private fun addUser() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isNotEmpty() && age != null) {
            val success = databaseHelper.addUser(name, age)
            if (success) {
                Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                ageEditText.text.clear()
            } else {
                Toast.makeText(this, "Failed to add user", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter a valid name and age", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUser() {
        val id = nameEditText.text.toString().toIntOrNull()  // Or use an ID input field
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull()

        if (id != null && name.isNotEmpty() && age != null) {
            val success = databaseHelper.updateUser(id, name, age)
            if (success) {
                Toast.makeText(this, "User updated successfully!", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                ageEditText.text.clear()
            } else {
                Toast.makeText(this, "Failed to update user", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter valid ID, name, and age", Toast.LENGTH_SHORT).show()
        }
    }
    private fun deleteUser() {
        val id = nameEditText.text.toString().toIntOrNull()  // Or use an ID input field

        if (id != null) {
            val success = databaseHelper.deleteUser(id)
            if (success) {
                Toast.makeText(this, "User deleted successfully!", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
            } else {
                Toast.makeText(this, "Failed to delete user", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter a valid ID", Toast.LENGTH_SHORT).show()
        }
    }
    // viewUsers Function
    private fun viewUsers() {
        val users = databaseHelper.getAllUsers()
        resultTextView.text = if (users.isNotEmpty()) {
            users.joinToString("\n")
        } else {
            "No users found"
        }
    }
}
