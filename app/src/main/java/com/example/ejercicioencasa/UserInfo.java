package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ejercicioencasa.daos.Ejercicio;
import com.example.ejercicioencasa.daos.EjercicioDao;
import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;

public class UserInfo extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        context = getApplicationContext();
        InfoUsuarioDao infoUsuarioDao = new InfoUsuarioDao(context);
        String sexo = infoUsuarioDao.consultarInfo(InfoUsuario.SEXO).getValor();
        String altura = infoUsuarioDao.consultarInfo(InfoUsuario.ALTURA).getValor();
        String peso = infoUsuarioDao.consultarInfo(InfoUsuario.PESO).getValor();
        String calentamiento = infoUsuarioDao.consultarInfo(InfoUsuario.CALENTAMIENTO).getValor();
        String amigable = infoUsuarioDao.consultarInfo(InfoUsuario.AMIGABLE).getValor();
        String dificultad = infoUsuarioDao.consultarInfo(InfoUsuario.DIFICULTAD).getValor();
        String objetivo = infoUsuarioDao.consultarInfo(InfoUsuario.OBJETIVO).getValor();

        TextView userObj = findViewById(R.id.user_muscular);
        userObj.setText(objetivo);

        TextView userDif = findViewById(R.id.user_dificult);
        userDif.setText(dificultad);

        TextView userFriendly = findViewById(R.id.user_amig);
        userFriendly.setText(amigable);

        TextView userCalent = findViewById(R.id.user_calent);
        userCalent.setText(calentamiento);

        TextView userAltura = findViewById(R.id.user_altura);
        userAltura.setText(altura);

        TextView userPeso = findViewById(R.id.user_peso);
        userPeso.setText(peso);

        if(sexo.equals("M")) sexo = "Maculino";
        else sexo = "Femenino";
        TextView userSexo = findViewById(R.id.user_sexo);
        userSexo.setText(sexo);
    }

    public void cambiarInfoBtn(View view){
        //Lanzar la actividad gender select *
    }

    public void temporalPrueba(View view){

    }
}