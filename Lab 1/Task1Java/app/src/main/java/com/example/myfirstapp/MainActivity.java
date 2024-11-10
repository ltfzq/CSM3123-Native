package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Button buttonNavigate = findViewById(R.id.buttonNavigate);

        // Change text and color when the button is clicked and show a Toast
        button.setOnClickListener(v -> {
            textView.setText("Button Clicked!");
            textView.setTextColor(Color.RED);
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show();
        });

        // Navigate to SecondActivity when buttonNavigate is clicked
        buttonNavigate.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!");
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}
