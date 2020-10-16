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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.TablaInfoUsuario.TABLE_NAME);
        onCreate(db);
    }
}
