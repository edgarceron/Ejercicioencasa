package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
                    intent = new Intent(SplashScreen.this, UserInfo.class);
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
        InfoUsuario infoUsuario;
        infoUsuario = infoUsuarioDao.consultarInfo(InfoUsuario.GUARDADO);
        if (infoUsuario != null && infoUsuario.getValor().equals("1")) return true;
        return false;
    }
}