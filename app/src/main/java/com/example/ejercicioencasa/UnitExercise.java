package com.example.ejercicioencasa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ejercicioencasa.daos.RutinaBody;
import com.example.ejercicioencasa.daos.RutinaBodyDao;
import com.example.ejercicioencasa.daos.RutinaHeaderDao;
import com.example.ejercicioencasa.utilities.AppUtilities;
import com.example.ejercicioencasa.utilities.DialogInfo;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pl.droidsonroids.gif.GifTextView;

public class UnitExercise extends AppCompatActivity {

    private String url;
    int id_ejercicio;
    int id_rutina_header;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_exercise);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");
        String gif = intent.getStringExtra("gif");
        this.url = intent.getStringExtra("url");
        this.id_ejercicio = intent.getIntExtra("id_ejercicio",0);
        this.id_rutina_header = intent.getIntExtra("id_rutina_header",0);
        int repeticiones = intent.getIntExtra("repeticiones",0);
        int tiempo = intent.getIntExtra("tiempo",0);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        context = getApplicationContext();

        TextView nombreEjercicio = findViewById(R.id.nombre_ejercicio);
        nombreEjercicio.setText(nombre);
        TextView textDescrip = findViewById(R.id.text_descrip);
        textDescrip.setText(descripcion);
        TextView textTime = findViewById(R.id.text_time);
        textTime.setText(String.valueOf(tiempo));
        TextView textRepeat = findViewById(R.id.text_repeat);
        textRepeat.setText(String.valueOf(repeticiones));

        GifTextView gifView = findViewById(R.id.gifContainer);
        gifView.setBackgroundResource(getResources().getIdentifier(gif, "drawable", getPackageName()));
    }

    public void onFinish(View view){
        RutinaBodyDao rutinaBodyDao = new RutinaBodyDao(context);
        RutinaBody rutinaBody = rutinaBodyDao.consultarRutinaBody(id_rutina_header, id_ejercicio);
        rutinaBody.setEstado(1);
        rutinaBodyDao.updateRutinaBody(rutinaBody);

        ArrayList<RutinaBody> pendientes = rutinaBodyDao.getPendientes(id_rutina_header);
        if(pendientes.size() > 0){
            RutinaBody siguiente = pendientes.get(0);
            Intent intent = new Intent(this, rest.class);
            intent = AppUtilities.putInfoIntent(intent, siguiente, id_rutina_header);
            startActivity(intent);
        }
        else{
            DialogInfo dialogInfo = new DialogInfo("Ir a intent de finalización");
            dialogInfo.show(getSupportFragmentManager(), "End");
            //Ir a activity de felicitación
        }
    }

    public void ytbBtn(View view){
        StringTokenizer stringTokenizer = new StringTokenizer(url,"=");
        stringTokenizer.nextElement();
        String id = (String) stringTokenizer.nextElement();
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        appIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
    }
}