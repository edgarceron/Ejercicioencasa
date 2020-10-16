package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ejercicioencasa.daos.EjercicioDao;
import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class GenderSelect extends AppCompatActivity {

    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_select);
        context = getApplicationContext();
    }

    public void btnMale(View view){
        AppUtilities.alterInfoUsuario(InfoUsuario.SEXO, "M", context);
        this.btnNext(view);
    }

    public void btnFemale(View view){
        AppUtilities.alterInfoUsuario(InfoUsuario.SEXO, "F", context);
        this.btnNext(view);
    }

    public void btnNext(View view){
        Intent intent = new Intent(this, WeightInput.class);
        startActivity(intent);
    }
}