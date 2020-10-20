package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class GoalSelect extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_select);
        context = getApplicationContext();
    }

    public void btnSig(View view) {
        RadioGroup radioGroup = findViewById(R.id.radioGroupGoal);
        int idSelected = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idSelected);
        String textRadio = (String) radioButton.getText();

        AppUtilities.alterInfoUsuario(InfoUsuario.OBJETIVO, textRadio, context);
        AppUtilities.alterInfoUsuario(InfoUsuario.GUARDADO, "1", context);

        Intent intent = new Intent(this, UserInfo.class);
        startActivity(intent);
    }

}