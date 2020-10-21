package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        if(sexo.equals("M")) sexo = "Maculino";
        else sexo = "Femenino";
        TextView userSexo = findViewById(R.id.user_sex);
        userSexo.setText(sexo);


    }

    public void cambiarInfoBtn(View view){
        //Lanzar la actividad gender select *
    }

    public void temporalPrueba(View view){

    }
}