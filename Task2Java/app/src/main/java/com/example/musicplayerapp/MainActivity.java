package com.example.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.musicplayerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startMusicButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MusicService.class);
            startService(intent); // Start the foreground service
        });

        binding.stopMusicButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MusicService.class);
            stopService(intent); // Stop the foreground service
        });
    }
}
