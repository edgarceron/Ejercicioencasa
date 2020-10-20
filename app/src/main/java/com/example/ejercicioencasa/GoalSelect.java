package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GoalSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_select);
    }

    public void btnSig(View view) {
        Intent intent = new Intent(this, WarmUpActivity.class);
        startActivity(intent);
    }

}