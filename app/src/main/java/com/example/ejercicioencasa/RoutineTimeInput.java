package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ejercicioencasa.daos.Ejercicio;
import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.RutinaBody;
import com.example.ejercicioencasa.daos.RutinaBodyDao;
import com.example.ejercicioencasa.daos.RutinaHeader;
import com.example.ejercicioencasa.daos.RutinaHeaderDao;
import com.example.ejercicioencasa.utilities.AppUtilities;
import com.example.ejercicioencasa.utilities.DialogInfo;

import java.util.ArrayList;

public class RoutineTimeInput extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_time_input);
        context = getApplicationContext();
    }

    public void btnNext(View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroupTime);
        int idSelected = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idSelected);
        String textRadio = (String) radioButton.getText();
        int tiempo = 0;
        if ( textRadio.equals(getResources().getString(R.string.minutes_5))){
            tiempo = 5;
        }
        else if ( textRadio.equals(getResources().getString(R.string.minutes_10))){
            tiempo = 10;
        }
        else if ( textRadio.equals(getResources().getString(R.string.minutes_15))){
            tiempo = 15;
        }

        RutinaHeaderDao rutinaHeaderDao = new RutinaHeaderDao(context);
        int idRutina =  rutinaHeaderDao.crearRutina(tiempo);

        RutinaBodyDao rutinaBodyDao = new RutinaBodyDao(context);
        Intent intent = new Intent(this, UnitExercise.class);
        ArrayList<RutinaBody> pendientes = rutinaBodyDao.getPendientes(idRutina);
        if(pendientes.size() > 0){
            RutinaBody siguiente = pendientes.get(0);
            intent = AppUtilities.putInfoIntent(intent, siguiente, idRutina);
            startActivity(intent);
        }
        else {
            DialogInfo dialogInfo = new DialogInfo("No se encontraron ejercicios en la base de datos, cambie de objetivo");
            dialogInfo.show(getSupportFragmentManager(), "End");
        }
    }
}