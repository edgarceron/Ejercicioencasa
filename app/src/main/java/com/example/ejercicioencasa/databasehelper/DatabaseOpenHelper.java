package com.example.ejercicioencasa.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, UtilitiesDatabase.DATABASE_NAME, null, UtilitiesDatabase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilitiesDatabase.TablaInfoUsuario.CREATE_TABLE_INFO_USUARIO);
        db.execSQL(UtilitiesDatabase.TablaEjercicios.CREATE_TABLE_EJERCICIOS);
        db.execSQL(UtilitiesDatabase.TablaRutinaHeader.CREATE_TABLE_RUTINA_HEADER);
        db.execSQL(UtilitiesDatabase.TablaRutinaBody.CREATE_TABLE_RUTINA_BODY);
        insertEjercicio(db, "Plank bird dog", "","plank_bird_dog",
                "https://www.youtube.com/watch?v=8Fc6ZO8owZk", 0.6f, 3, 1,
                "Abdomen", 0);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.TablaInfoUsuario.TABLE_NAME);
        onCreate(db);
    }

    private void insertEjercicio(SQLiteDatabase db, String nombre, String descripcion, String gif,
                                 String url, float calorias, int tiempo, int dificultad,
                                 String musculo, int ruido){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaEjercicios.NOMBRE, nombre);
        registro.put(UtilitiesDatabase.TablaEjercicios.DESCRIPCION, descripcion);
        registro.put(UtilitiesDatabase.TablaEjercicios.GIF, gif);
        registro.put(UtilitiesDatabase.TablaEjercicios.URL_VIDEO, url);
        registro.put(UtilitiesDatabase.TablaEjercicios.QUEMA_CALORIAS, calorias);
        registro.put(UtilitiesDatabase.TablaEjercicios.TIEMPO_REPETICION, tiempo);
        registro.put(UtilitiesDatabase.TablaEjercicios.DIFICULTAD, dificultad);
        registro.put(UtilitiesDatabase.TablaEjercicios.MUSCULO, musculo);
        registro.put(UtilitiesDatabase.TablaEjercicios.RUIDO, ruido);
        db.insert(UtilitiesDatabase.TablaEjercicios.TABLE_NAME, null, registro);
    }


}
