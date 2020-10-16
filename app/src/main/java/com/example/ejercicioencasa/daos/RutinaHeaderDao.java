package com.example.ejercicioencasa.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicioencasa.databasehelper.DatabaseOpenHelper;
import com.example.ejercicioencasa.databasehelper.UtilitiesDatabase;

import java.util.ArrayList;

public class RutinaHeaderDao {

    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public RutinaHeaderDao(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    public long insertRutinaHeader(RutinaHeader rutinaHeader){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaRutinaHeader.DURACION, rutinaHeader.duracion);
        registro.put(UtilitiesDatabase.TablaRutinaHeader.ESTADO, rutinaHeader.estado);
        return db.insert(UtilitiesDatabase.TablaRutinaHeader.TABLE_NAME, null, registro);
    }

    public long updateRutinaHeader(RutinaHeader rutinaHeader){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaRutinaHeader.DURACION, rutinaHeader.duracion);
        registro.put(UtilitiesDatabase.TablaRutinaHeader.ESTADO, rutinaHeader.estado);
        String where = UtilitiesDatabase.TablaRutinaHeader.ID + "=?";
        String[] args = new String[]{
                String.valueOf(rutinaHeader.id),
        };
        return db.update(UtilitiesDatabase.TablaRutinaHeader.TABLE_NAME, registro, where, args);
    }

    public RutinaHeader getRutinaHeader(int id){
        RutinaHeader rutinaHeader = null;
        String[] campos = new String[]{
                UtilitiesDatabase.TablaRutinaHeader.ID,
                UtilitiesDatabase.TablaRutinaHeader.DURACION,
                UtilitiesDatabase.TablaRutinaHeader.ESTADO,
        };

        String[] parametros = new String[]{UtilitiesDatabase.TablaRutinaHeader.ID};
        String[] argumentos = new String[]{String.valueOf(id)};
        Cursor cursor = db.query(UtilitiesDatabase.TablaRutinaHeader.TABLE_NAME, campos, parametros[0] + "=?", argumentos,
                null, null, null);
        if(cursor.moveToNext()){
            rutinaHeader = new RutinaHeader(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2));
        }
        cursor.close();
        return rutinaHeader;
    }

    public ArrayList<RutinaHeader> consultarInfoUsuario(){
        ArrayList<RutinaHeader> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery(UtilitiesDatabase.TablaRutinaHeader.CONSULTAR_ALL_TABLE, null);
        while (cursor.moveToNext()){
            lista.add(new RutinaHeader(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)));
        }

        cursor.close();
        return lista;
    }

    public void deleteRutinaHeader(int id){
        db.delete(
                UtilitiesDatabase.TablaRutinaHeader.TABLE_NAME,
                "id=?",
                new String[]{String.valueOf(id)});
    }
}
