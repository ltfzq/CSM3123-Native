package com.example.imageexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private boolean isBackgroundOne = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        Button switchBackgroundButton =
                findViewById(R.id.switchBackgroundButton);
        switchBackgroundButton.setOnClickListener(v -> {
            if (isBackgroundOne) {

                layout.setBackgroundResource(R.drawable.background_image2);
            } else {

                layout.setBackgroundResource(R.drawable.background_image1);
            }
            isBackgroundOne = !isBackgroundOne;
        });
    }
}
