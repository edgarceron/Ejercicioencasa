package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn(View view){
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
    NavController navController = Navigation.findNavController(this,  R.id.fragment3);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
}