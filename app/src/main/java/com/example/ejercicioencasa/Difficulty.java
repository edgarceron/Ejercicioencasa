package com.example.ejercicioencasa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class Difficulty extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        context = getApplicationContext();
    }

    public void btnEasy(View view) {
        setDifficulty("1");
    }

    public void btnMedium(View view) {
        setDifficulty("2");
    }

    public void btnHard(View view) {
        setDifficulty("3");
    }

    public void setDifficulty(String difficulty){
        AppUtilities.alterInfoUsuario(InfoUsuario.DIFICULTAD, difficulty, context);
        Intent intent = new Intent(this, GoalSelect.class);
        startActivity(intent);
    }

}
