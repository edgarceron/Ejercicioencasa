package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class rest extends AppCompatActivity {
    private Chronometer chronometer;
    public long rest_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        chronometer = findViewById(R.id.cronometro);
        chronometer.setFormat("Time: %s");
        chronometer.start();
    }

    public void stopRest(View v){
        chronometer.stop();
        this.rest_time = (SystemClock.elapsedRealtime() - chronometer.getBase());
        Intent i = new Intent(this, UnitExercise.class);
        startActivity(i);
    }

    public void goToMainActivity(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}