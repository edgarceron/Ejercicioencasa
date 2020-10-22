package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class WarmUpActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_up);
        context = getApplicationContext();
    }

    public void btnOmitir(View view){
        setWarnUp(0);
    }

    public void btnNoOmitir(View view){
        setWarnUp(1);
    }

    public void setWarnUp(int type){
        if(type == 1){
            AppUtilities.alterInfoUsuario(InfoUsuario.CALENTAMIENTO, "1", context);
        }
        else {
            AppUtilities.alterInfoUsuario(InfoUsuario.CALENTAMIENTO, "0", context);
        }

        AppUtilities.alterInfoUsuario(InfoUsuario.GUARDADO, "1", context);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}