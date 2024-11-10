package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve and display the passed message
        String message = getIntent().getStringExtra("EXTRA_MESSAGE");
        TextView textView = findViewById(R.id.textViewSecond);
        textView.setText(message);

        // Set up the "Back to Main Activity" button
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish()); // This will close SecondActivity and return to MainActivity
    }
}
