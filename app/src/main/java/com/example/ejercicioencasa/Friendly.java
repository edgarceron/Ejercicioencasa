package com.example.ejercicioencasa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Friendly extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendly);
    }

    public void btnNo(View view) {
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }

    public void btnYes(View view) {
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }
}
