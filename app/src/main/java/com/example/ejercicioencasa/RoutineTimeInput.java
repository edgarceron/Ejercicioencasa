package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class RoutineTimeInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_time_input);
    }

    public void btnNext(View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroupTime);
        int idSelected = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idSelected);
        String textRadio = (String) radioButton.getText();
        String tiempo = "";
        if ( textRadio.equals(getResources().getString(R.string.minutes_5))){
            tiempo = "5";
        }
        else if ( textRadio.equals(getResources().getString(R.string.minutes_10))){
            tiempo = "10";
        }
        else if ( textRadio.equals(getResources().getString(R.string.minutes_15))){
            tiempo = "15";
        }

        //TODO Guardar tiempo de rutina
        Intent intent = new Intent(this, Friendly.class);
        startActivity(intent);
    }
}