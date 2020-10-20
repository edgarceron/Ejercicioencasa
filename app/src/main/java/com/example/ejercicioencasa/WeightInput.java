package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;

public class WeightInput extends AppCompatActivity {

    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.hide();
        setContentView(R.layout.activity_weight_input);
        context = getApplicationContext();
    }

    public void btnNext(View view){
        EditText pesoET = (EditText) findViewById(R.id.pesoInput);
        int peso;
        try {
            peso = Integer.parseInt(pesoET.getText().toString());
        }
        catch (NumberFormatException e){
            peso = 0;
        }

        if (peso > 30){
            AppUtilities.alterInfoUsuario(InfoUsuario.PESO, String.valueOf(peso), context);
            Intent intent = new Intent(this, Friendly.class);
            startActivity(intent);
        }
        else {
            DialogInfo dialogInfo = new DialogInfo(getResources().getString(R.string.wrong_weight_input));
            dialogInfo.show(getSupportFragmentManager(), "Wrong weight");
        }

    }
}