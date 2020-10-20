package com.example.ejercicioencasa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class Friendly extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendly);
        context = getApplicationContext();
    }



    public void setFriendly(int type){
        if(type == 1){
            AppUtilities.alterInfoUsuario(InfoUsuario.AMIGABLE, "1", context);
        }
        else {
            AppUtilities.alterInfoUsuario(InfoUsuario.AMIGABLE, "0", context);
        }
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }

    public void btnNo(View view) {
        setFriendly(1);
    }

    public void btnYes(View view) {
        setFriendly(0);
    }
}
