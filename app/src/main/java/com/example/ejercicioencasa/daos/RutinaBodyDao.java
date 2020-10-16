package com.example.ejercicioencasa.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicioencasa.databasehelper.DatabaseOpenHelper;
import com.example.ejercicioencasa.databasehelper.UtilitiesDatabase;

public class RutinaBodyDao {

    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;
    private Context context;

    public RutinaBodyDao(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
        this.context = context;
    }

    public long insertRutinaBody(RutinaBody rutinaBody){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaRutinaBody.HEADER, rutinaBody.header.id);
        registro.put(UtilitiesDatabase.TablaRutinaBody.EJERCICIO, rutinaBody.ejercicio.id);
        registro.put(UtilitiesDatabase.TablaRutinaBody.REPETICIONES, rutinaBody.repeticiones);
        registro.put(UtilitiesDatabase.TablaRutinaBody.ESTADO, rutinaBody.estado);
        return db.insert(UtilitiesDatabase.TablaRutinaBody.TABLE_NAME, null, registro);
    }

    public long updateRutinaBody(RutinaBody rutinaBody){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDatabase.TablaRutinaBody.HEADER, rutinaBody.header.id);
        registro.put(UtilitiesDatabase.TablaRutinaBody.EJERCICIO, rutinaBody.ejercicio.id);
        registro.put(UtilitiesDatabase.TablaRutinaBody.REPETICIONES, rutinaBody.repeticiones);
        registro.put(UtilitiesDatabase.TablaRutinaBody.ESTADO, rutinaBody.estado);
        String where = UtilitiesDatabase.TablaRutinaBody.HEADER + "=?, "
                + UtilitiesDatabase.TablaRutinaBody.EJERCICIO  + "=?";
        String[] args = new String[]{
                String.valueOf(rutinaBody.header.id),
                String.valueOf(rutinaBody.ejercicio.id),
        };
        return db.update(UtilitiesDatabase.TablaRutinaBody.TABLE_NAME, registro, where, args);
    }

    public RutinaBody consultarRutinaBody(int header_id){
        RutinaBody rutinaBody = null;
        String[] campos = new String[]{
                UtilitiesDatabase.TablaRutinaBody.HEADER,
                UtilitiesDatabase.TablaRutinaBody.EJERCICIO,
                UtilitiesDatabase.TablaRutinaBody.REPETICIONES,
                UtilitiesDatabase.TablaRutinaBody.ESTADO,
        };

        String[] parametros = new String[]{UtilitiesDatabase.TablaRutinaBody.HEADER};
        String[] argumentos = new String[]{String.valueOf(header_id)};
        Cursor cursor = db.query(UtilitiesDatabase.TablaRutinaBody.TABLE_NAME, campos, parametros[0] + "=?", argumentos,
                null, null, null);
        if(cursor.moveToNext()){
            EjercicioDao ejercicioDao = new EjercicioDao(context);
            Ejercicio ejercicio = ejercicioDao.getEjercicio(cursor.getInt(1));
            RutinaHeaderDao headerDao = new RutinaHeaderDao(context);
            RutinaHeader rutinaHeader = headerDao.getRutinaHeader(cursor.getInt(0));
            rutinaBody = new RutinaBody(cursor.getInt(2), rutinaHeader, ejercicio, cursor.getInt(3));
        }
        cursor.close();
        return rutinaBody;
    }

}
