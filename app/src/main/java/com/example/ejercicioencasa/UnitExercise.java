package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pl.droidsonroids.gif.GifTextView;

public class UnitExercise extends AppCompatActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_exercise);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");
        String gif = intent.getStringExtra("gif");
        this.url = intent.getStringExtra("url");
        int id_rutina_body = intent.getIntExtra("id",0);
        int id_rutina_header = intent.getIntExtra("id_rutina_header",0);
        int repeticiones = intent.getIntExtra("repeticiones",0);
        int tiempo = intent.getIntExtra("tiempo",0);

        TextView nombreEjercicio = findViewById(R.id.nombre_ejercicio);
        nombreEjercicio.setText(nombre);
        TextView textDescrip = findViewById(R.id.text_descrip);
        textDescrip.setText(descripcion);
        TextView textTime = findViewById(R.id.text_time);
        textTime.setText(tiempo);
        TextView textRepeat = findViewById(R.id.text_repeat);
        textTime.setText(tiempo);

        GifTextView gifView = findViewById(R.id.gifContainer);
        gifView.setBackgroundResource(getResources().getIdentifier(gif, "drawable", getPackageName()));
    }

    public void onFinsih(){
        //Ir a la actividad de descanso
    }
}