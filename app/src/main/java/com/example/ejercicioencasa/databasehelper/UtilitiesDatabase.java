package com.example.ejercicioencasa.databasehelper;

public class UtilitiesDatabase {
    static final String DATABASE_NAME = "ejercicio";
    static final int VERSION = 1;

    public class TablaInfoUsuario{
        public static final String TABLE_NAME = "infoUsuario";
        public static final String ID = "id";
        public static final String CODIGO = "codigo";
        public static final String VALOR = "valor";

        public static final String CREATE_TABLE_INFO_USUARIO = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + CODIGO + " TEXT, " + VALOR +
                " TEXT);";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + TABLE_NAME + ";";
    }

    public class TablaEjercicios{
        public static final String TABLE_NAME = "ejercicios";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String GIF = "gif";
        public static final String URL_VIDEO = "url";
        public static final String QUEMA_CALORIAS = "calorias";
        public static final String TIEMPO_REPETICION = "tiempo";
        public static final String DIFICULTAD = "dificultad";
        public static final String MUSCULO = "musculo";
        public static final String RUIDO = "ruido";

        public static final String CREATE_TABLE_EJERCICIOS = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE + " TEXT, " + DESCRIPCION +
                " TEXT, " + GIF + " TEXT, " + URL_VIDEO + " TEXT, " + QUEMA_CALORIAS + " REAL ,"
                + TIEMPO_REPETICION + " INTEGER, " + DIFICULTAD + " INTEGER, " + MUSCULO +" TEXT,"
                + RUIDO + " INTEGER);";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + TABLE_NAME + ";";
    }
}
