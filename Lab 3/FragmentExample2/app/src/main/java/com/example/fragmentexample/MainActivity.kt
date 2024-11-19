package com.example.fragmentexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load MyFragment by default
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MyFragment())
            .commit()
    }

    fun sendDataToFragment2(data: String) {
        val fragment2 = Fragment2()

        // Replace MyFragment with Fragment2
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .commit()

        // Wait for Fragment2 to be fully created before updating its data
        supportFragmentManager.executePendingTransactions()
        fragment2.updateData(data)
    }
}