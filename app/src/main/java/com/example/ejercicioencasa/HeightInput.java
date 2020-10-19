package com.example.ejercicioencasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class HeightInput extends AppCompatActivity {
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_input);
        context = getApplicationContext();
    }

    public void btnNext(View view){
        EditText alturaET = findViewById(R.id.alturaInput);
        int altura;
        try {
            altura = Integer.parseInt(alturaET.getText().toString());
        }
        catch (NumberFormatException e){
            altura = 0;
        }

        if (altura > 50){
            AppUtilities.alterInfoUsuario(InfoUsuario.PESO, String.valueOf(altura), context);
            Intent intent = new Intent(this, WarmUpActivity.class);
            startActivity(intent);
        }
        else {
            DialogInfo dialogInfo = new DialogInfo(getResources().getString(R.string.wrong_weight_input));
            dialogInfo.show(getSupportFragmentManager(), "Wrong height");
        }
    }
}