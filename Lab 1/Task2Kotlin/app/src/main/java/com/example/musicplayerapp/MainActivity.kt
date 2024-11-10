package com.example.musicplayerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            startService(intent) // Start the foreground service
        }

        binding.stopMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            stopService(intent) // Stop the foreground service
        }
    }
}
