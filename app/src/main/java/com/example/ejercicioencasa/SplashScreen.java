package com.example.ejercicioencasa;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreen extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context = getApplicationContext();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(verifyUserData()){
                    intent = new Intent(SplashScreen.this, MainActivity.class);
                }
                else {
                    intent = new Intent(SplashScreen.this, GenderSelect.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public boolean verifyUserData(){
        InfoUsuarioDao infoUsuarioDao = new InfoUsuarioDao(context);

        String[] fields = new String[]{InfoUsuario.ALTURA, InfoUsuario.OBJETIVO, InfoUsuario.AMIGABLE,
                InfoUsuario.PESO, InfoUsuario.SEXO};

        for (String field : fields) {
            if (infoUsuarioDao.consultarinfo(field) == null) {
                return false;
            }
        }
        return true;
    }
}