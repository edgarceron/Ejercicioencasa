package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

  //  BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
  //  NavController navController = Navigation.findNavController(this,  R.id.fragment3);
  //  NavigationUI.setupWithNavController(bottomNavigationView, navController);
}