package com.example.ejercicioencasa.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicioencasa.databasehelper.DatabaseOpenHelper;
import com.example.ejercicioencasa.databasehelper.UtilitiesDatabase;

import java.util.ArrayList;
import java.util.Random;

public class RutinaHeaderDao {

    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;
    private EjercicioDao ejercicioDao;
    private InfoUsuarioDao infoUsuarioDao;
    private RutinaBodyDao rutinaBodyDao;

    public RutinaHeaderDao(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
        ejercicioDao = new EjercicioDao(context);
        infoUsuarioDao = new InfoUsuarioDao(context);
        rutinaBodyDao = new RutinaBodyDao(context);
    }

    public int crearRutina(int duracion){
        String amigable = infoUsuarioDao.consultarInfo(InfoUsuario.AMIGABLE).valor;
        String objetivo = infoUsuarioDao.consultarInfo(InfoUsuario.OBJETIVO).valor;
        String calentamiento = infoUsuarioDao.consultarInfo(InfoUsuario.CALENTAMIENTO).valor;
        String dificultad = infoUsuarioDao.consultarInfo(InfoUsuario.DIFICULTAD).valor;

        duracion = duracion * 60;

        RutinaHeader rutinaHeader = new RutinaHeader(duracion, 0);
        rutinaHeader.setId((int) insertRutinaHeader(rutinaHeader));

        ArrayList<Ejercicio> ejercicios = ejercicioDao.getEjercicios(
                Integer.parseInt(dificultad), objetivo, Integer.parseInt(amigable));

        ArrayList<Ejercicio> calentamientos = new ArrayList<>();
        if(calentamiento.equals("Si")){
            calentamientos = ejercicioDao.getEjercicios(
                    Integer.parseInt(dificultad), objetivo, Integer.parseInt(amigable));
        }

        ArrayList<RutinaBody> rutinaBodies = new ArrayList<>();
        int totalSeconds = 0;
        int seleccionado;
        int size = calentamientos.size();
        java.util.Random random = new Random();

        if (size > 0){
            seleccionado = random.nextInt(size);
            Ejercicio ejercicioCalentamiento = calentamientos.get(seleccionado);
            rutinaBodies.add(new RutinaBody(15, rutinaHeader, ejercicioCalentamiento, 0));
            totalSeconds += 15 * ejercicioCalentamiento.tiempoRepeticion;
        }

        while(totalSeconds < duracion && ejercicios.size() > 0){
            seleccionado = random.nextInt(ejercicios.size());
            totalSeconds += 15 * ejercicios.get(seleccionado).tiempoRepeticion;
            rutinaBodies.add(new RutinaBody(15, rutinaHeader, ejercicios.get(seleccionado), 0));
            ejercicios.remove(seleccionado);
        }

        for(int i = 0; i < rutinaBodies.size(); i++){
            rutinaBodyDao.insertRutinaBody(rutinaBodies.get(i));
        }

        return rutinaHeader.id;
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
