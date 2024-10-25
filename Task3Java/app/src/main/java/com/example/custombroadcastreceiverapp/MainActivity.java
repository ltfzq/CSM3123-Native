package com.example.custombroadcastreceiverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.example.custombroadcastreceiverapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyCustomBroadcastReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myReceiver = new MyCustomBroadcastReceiver();

        binding.sendBroadcastButton.setOnClickListener(view -> {
            // Create an intent with the custom action
            Intent intent = new Intent("com.example.CUSTOM_ACTION");
            // Send the broadcast
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register the receiver with the intent filter
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(myReceiver, new IntentFilter("com.example.CUSTOM_ACTION"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unregister the receiver to prevent memory leaks
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
    }
}
