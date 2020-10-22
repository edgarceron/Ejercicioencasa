package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.utilities.AppUtilities;
import com.example.ejercicioencasa.utilities.DialogInfo;

public class HeightInput extends AppCompatActivity {
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.hide();
        setContentView(R.layout.activity_height_input);
        context = getApplicationContext();
    }

    public void btnNext(View view){
        EditText alturaET = (EditText) findViewById(R.id.alturaInput);
        int altura;
        try {
            altura = Integer.parseInt(alturaET.getText().toString());
        }
        catch (NumberFormatException e){
            altura = 0;
        }

        if (altura > 50){
            AppUtilities.alterInfoUsuario(InfoUsuario.ALTURA, String.valueOf(altura), context);
            Intent intent = new Intent(this, WeightInput.class);
            startActivity(intent);
        }
        else {
            DialogInfo dialogInfo = new DialogInfo(getResources().getString(R.string.wrong_weight_input));
            dialogInfo.show(getSupportFragmentManager(), "Wrong height");
        }
    }
}