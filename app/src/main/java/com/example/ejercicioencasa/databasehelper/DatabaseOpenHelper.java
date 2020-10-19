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

    private static String ABDOMEN = "Abdomen";
    private static String PIERNAS = "Piernas";
    private static String GLUETO = "Gluteo";
    private static String HOMBRO = "Hombro";
    private static String BICEPS = "Biceps";
    private static String TRICEPS = "Triceps";
    private static String PECHO = "Pecho";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilitiesDatabase.TablaInfoUsuario.CREATE_TABLE_INFO_USUARIO);
        db.execSQL(UtilitiesDatabase.TablaEjercicios.CREATE_TABLE_EJERCICIOS);
        db.execSQL(UtilitiesDatabase.TablaRutinaHeader.CREATE_TABLE_RUTINA_HEADER);
        db.execSQL(UtilitiesDatabase.TablaRutinaBody.CREATE_TABLE_RUTINA_BODY);
        insertEjercicio(db, "Plank bird dog", "1. Start on your hands and knees" +
                        " with the hands under the shoulders and the knees under the hips.\n" +
                        "2. Extend one leg and the opposite arm at the same time.\n" +
                        "3. Pause for 3 to 5 seconds, return to the starting position and switch sides.\n" +
                        "4. Continue alternating sides until set is complete.","plank-bird-dog",
                "https://www.youtube.com/watch?v=8Fc6ZO8owZk", 0.6f, 3, 1,
                ABDOMEN, 0);
        insertEjercicio(db, "Bulgarian split squat", "1. Place a step or a box " +
                        "behind you and stand up tall.\n" + "2. Position your right foot on top of the " +
                        "step, bend your knees and lower the hips until your left thigh is parallel " +
                        "to the floor.\n" + "3. Return to the starting position and repeat.\n" +
                        "4. Switch legs.","bulgarian-split-squat",
                "https://www.youtube.com/watch?v=q4iZhYpVOOA", 0.6f, 3, 1,
                PIERNAS, 0);
        insertEjercicio(db, "Chest press", "1. Lie down on a mat with your knees " +
                        "bent and a dumbbell in each hand.\n" + "2. Push the dumbbells up toward the " +
                        "ceiling so that your arms are directly over your shoulders and your palms are " +
                        "facing your feet.\n3. Lower your arms and repeat the movement.","chest-press",
                "https://www.youtube.com/watch?v=VmB1G1K7v94", 0.45f, 3, 2,
                PECHO, 0);
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
