package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragment3);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageButton imageButton = findViewById(R.id.button_routine);
        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        empezarRutina(view);
                    }
                }
        );
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks jere. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.userInfo) {
            Intent i = new Intent(this, UserInfo.class);
            startActivity(i);
            return true;
        } else return false;
    }*/

    public void btn(View view){
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    public void empezarRutina(View view){
        Intent intent = new Intent(this, RoutineTimeInput.class);
        startActivity(intent);
    }
}