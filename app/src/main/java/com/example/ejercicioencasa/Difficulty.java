package com.example.ejercicioencasa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
    }

    public void btnEasy(View view) {
        Intent intent = new Intent(this, GoalSelect.class);
        startActivity(intent);
    }

    public void btnMedium(View view) {
        Intent intent = new Intent(this, GoalSelect.class);
        startActivity(intent);
    }

    public void btnHard(View view) {
        Intent intent = new Intent(this, GoalSelect.class);
        startActivity(intent);
    }

}
