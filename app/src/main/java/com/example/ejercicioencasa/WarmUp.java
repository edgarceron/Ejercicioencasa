package com.example.ejercicioencasa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WarmUp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_up);
    }

    public void btnOmit(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void btnNo(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}
