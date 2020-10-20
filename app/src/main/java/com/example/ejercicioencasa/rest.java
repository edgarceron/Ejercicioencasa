package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class rest extends AppCompatActivity {
    private Chronometer chronometer;
    public long rest_time;
    private String url;
    String nombre;
    String descripcion;
    String gif;
    int id_ejercicio;
    int id_rutina_header;
    int repeticiones;
    int tiempo;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        descripcion = intent.getStringExtra("descripcion");
        gif = intent.getStringExtra("gif");
        this.url = intent.getStringExtra("url");
        this.id_ejercicio = intent.getIntExtra("id_ejercicio",0);
        this.id_rutina_header = intent.getIntExtra("id_rutina_header",0);
        repeticiones = intent.getIntExtra("repeticiones",0);
        tiempo = intent.getIntExtra("tiempo",0);

        context = getApplicationContext();

        chronometer = findViewById(R.id.cronometro);
        chronometer.setFormat("Time: %s");
        chronometer.start();
    }

    public void stopRest(View v){
        chronometer.stop();
        this.rest_time = (SystemClock.elapsedRealtime() - chronometer.getBase());
        Intent intent = new Intent(this, UnitExercise.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("gif", gif);
        intent.putExtra("url", url);
        intent.putExtra("id_ejercicio", id_ejercicio);
        intent.putExtra("id_rutina_header", id_rutina_header);
        intent.putExtra("repeticiones", repeticiones);
        intent.putExtra("tiempo", tiempo);
        startActivity(intent);
    }

    public void goToMainActivity(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}