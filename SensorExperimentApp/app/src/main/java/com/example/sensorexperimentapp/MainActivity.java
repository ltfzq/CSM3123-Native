package com.example.sensorexperimentapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, proximitySensor, lightSensor, rotationVectorSensor;
    private TextView accelerometerData, proximityData, lightData, orientationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView references
        accelerometerData = findViewById(R.id.accelerometerData);
        proximityData = findViewById(R.id.proximityData);
        lightData = findViewById(R.id.lightData);
        orientationData = findViewById(R.id.orientationData);

        // Initialize SensorManager and Sensors
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        // Register listeners for sensors
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (rotationVectorSensor != null) {
            sensorManager.registerListener(this, rotationVectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            orientationData.setText("Rotation Vector Sensor not available");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            accelerometerData.setText("Accelerometer Data: X=" + x + ", Y=" + y + ", Z=" + z);
        } else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float proximity = event.values[0];
            proximityData.setText("Proximity Data: " + proximity);
        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float light = event.values[0];
            lightData.setText("Light Sensor Data: " + light);
        } else if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            // Calculate orientation from rotation vector
            float[] rotationMatrix = new float[9];
            SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);

            float[] orientation = new float[3];
            SensorManager.getOrientation(rotationMatrix, orientation);

            // Convert radians to degrees for azimuth, pitch, and roll
            float azimuth = (float) Math.toDegrees(orientation[0]);
            float pitch = (float) Math.toDegrees(orientation[1]);
            float roll = (float) Math.toDegrees(orientation[2]);

            orientationData.setText("Orientation: Azimuth=" + azimuth +
                    ", Pitch=" + pitch + ", Roll=" + roll);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle sensor accuracy changes if needed
    }
}
