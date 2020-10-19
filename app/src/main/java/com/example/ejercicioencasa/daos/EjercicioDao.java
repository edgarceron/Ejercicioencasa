package com.example.ejercicioencasa.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicioencasa.databasehelper.DatabaseOpenHelper;
import com.example.ejercicioencasa.databasehelper.UtilitiesDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EjercicioDao {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public EjercicioDao(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    public long insertInfoEjercicio(Ejercicio ejercicio){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaEjercicios.NOMBRE, ejercicio.nombre);
        registro.put(UtilitiesDatabase.TablaEjercicios.DESCRIPCION, ejercicio.descripcion);
        registro.put(UtilitiesDatabase.TablaEjercicios.GIF, ejercicio.gif);
        registro.put(UtilitiesDatabase.TablaEjercicios.URL_VIDEO, ejercicio.url);
        registro.put(UtilitiesDatabase.TablaEjercicios.QUEMA_CALORIAS, ejercicio.calorias);
        registro.put(UtilitiesDatabase.TablaEjercicios.TIEMPO_REPETICION, ejercicio.tiempoRepeticion);
        registro.put(UtilitiesDatabase.TablaEjercicios.DIFICULTAD, ejercicio.dificultad);
        registro.put(UtilitiesDatabase.TablaEjercicios.MUSCULO, ejercicio.musuclo);
        registro.put(UtilitiesDatabase.TablaEjercicios.RUIDO, ejercicio.ruido);

        return db.insert(UtilitiesDatabase.TablaEjercicios.TABLE_NAME, null, registro);
    }

    public Ejercicio getEjercicio(int id){
        Ejercicio ejercicio = null;
        String[] campos = new String[]{
                UtilitiesDatabase.TablaEjercicios.ID,
                UtilitiesDatabase.TablaEjercicios.NOMBRE,
                UtilitiesDatabase.TablaEjercicios.DESCRIPCION,
                UtilitiesDatabase.TablaEjercicios.GIF,
                UtilitiesDatabase.TablaEjercicios.URL_VIDEO,
                UtilitiesDatabase.TablaEjercicios.QUEMA_CALORIAS,
                UtilitiesDatabase.TablaEjercicios.TIEMPO_REPETICION
        };
        String parametros = UtilitiesDatabase.TablaEjercicios.ID + "?";
        String[] argumentos = new String[]{String.valueOf(id)};
        Cursor cursor = db.query(UtilitiesDatabase.TablaEjercicios.TABLE_NAME, campos, parametros,
                argumentos, null, null, null) ;

        while(cursor.moveToNext()){
            ejercicio = new Ejercicio(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getFloat(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getColumnName(8),
                        cursor.getInt(9)
                );
        }
        cursor.close();
        return  ejercicio;
    }

    public ArrayList<Ejercicio> getEjercicios(int dificultad, String musculo, int ruido){
        String[] campos = new String[]{
                UtilitiesDatabase.TablaEjercicios.ID,
                UtilitiesDatabase.TablaEjercicios.NOMBRE,
                UtilitiesDatabase.TablaEjercicios.DESCRIPCION,
                UtilitiesDatabase.TablaEjercicios.GIF,
                UtilitiesDatabase.TablaEjercicios.URL_VIDEO,
                UtilitiesDatabase.TablaEjercicios.QUEMA_CALORIAS,
                UtilitiesDatabase.TablaEjercicios.TIEMPO_REPETICION
        };
        String parametros =
                UtilitiesDatabase.TablaEjercicios.DIFICULTAD + "=? ," +
                UtilitiesDatabase.TablaEjercicios.MUSCULO + "=? ," +
                UtilitiesDatabase.TablaEjercicios.RUIDO + "=? ,";
        String[] argumentos = new String[]{
                String.valueOf(dificultad), musculo, String.valueOf(ruido)};
        Cursor cursor = db.query(UtilitiesDatabase.TablaEjercicios.TABLE_NAME, campos, parametros,
                argumentos, null, null, null) ;

        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        while(cursor.moveToNext()){
            ejercicios.add(
                    new Ejercicio(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getFloat(5),
                            cursor.getInt(6),
                            cursor.getInt(7),
                            cursor.getColumnName(8),
                            cursor.getInt(9)
                    )
            );
        }
        cursor.close();
        return  ejercicios;
    }
}
