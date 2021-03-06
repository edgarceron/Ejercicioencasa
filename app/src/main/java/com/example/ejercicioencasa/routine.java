package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.view.View;
import android.widget.Toast;

public class routine extends AppCompatActivity {
    private Chronometer chronometer;
    public long routine_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        chronometer = findViewById(R.id.cronometro);
        chronometer.setFormat("Time: %s");
        chronometer.start();
    }

    //Aquí va lo que deben agregarle al botón
    public void stopRoutine(View v) {
        chronometer.stop();
        this.routine_time = (SystemClock.elapsedRealtime() - chronometer.getBase());
        Toast.makeText(this, "¡Completaste el entrenamiento! ¡Felicitaciones!", Toast.LENGTH_SHORT).show();
    }

}