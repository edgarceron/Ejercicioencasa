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

    public static String ABDOMEN = "Abdomen";
    public static String PIERNAS = "Piernas";
    public static String GLUETO = "Gluteo";
    public static String HOMBRO = "Hombro";
    public static String BICEPS = "Biceps";
    public static String TRICEPS = "Triceps";
    public static String PECHO = "Pecho";
    public static String ESPALDA = "Espalda";

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
        insertEjercicio(db, "DIPS DE MARIPOSA", "1. Siéntese en la colchoneta con " +
                        "los pies juntos, coloque las manos detrás de usted con los dedos mirando hacia" +
                        " adelante, doble las rodillas y deje que los muslos se abran.\n" + "2. Estire " +
                        "los brazos mientras presiona las caderas hacia arriba y junte ambas rodillas.\n" +
                        "3. Doble los codos y baje el cuerpo a la posición inicial.\n" + "4. Repita " +
                        "hasta completar el conjunto.","butterfly_dips",
                "https://www.youtube.com/watch?v=1d7XGAqSKJ4&ab_channel=HildaH.Salha", 0.6f, 3, 2, TRICEPS, 0);
        insertEjercicio(db, "TRICEP DE UN BRAZO HACIA ARRIBA", "1. Acuéstese sobre " +
                        "su lado derecho con los pies, las caderas y los hombros juntos. Coloque la palma " +
                        "de su mano izquierda sobre la colchoneta frente a su hombro derecho y abrace su " +
                        "cintura con su brazo derecho.\n" + "2. Estire su brazo izquierdo y empuje su torso " +
                        "hacia arriba.\n" + "3. Doble el brazo y baje el torso hacia la colchoneta.\n" +
                        "4. Repita y luego cambie de lado.","one_arm_tricep",
                "https://www.youtube.com/watch?v=jOVCDAfv8xk&ab_channel=ChristinaJensen",
                0.55f, 3, 2, TRICEPS, 0);
        insertEjercicio(db, "ARRIBA ABAJO TABLÓN", "1. Empiece en posición de plancha," +
                        " con las muñecas debajo de los hombros y los pies separados a la altura de las " +
                        "caderas.\n" + "2. Doble su brazo izquierdo, coloque su codo izquierdo sobre la " +
                        "colchoneta y luego doble su brazo derecho y coloque su codo derecho sobre la " +
                        "colchoneta.\n" + "3. Coloque su mano izquierda sobre el tapete, estire su brazo " +
                        "izquierdo y luego coloque su mano derecha sobre el tapete y enderece su brazo " +
                        "derecho.\n" + "4. Cambie de lado y repita este movimiento hacia arriba y hacia " +
                        "abajo hasta completar el conjunto.","up_down_plank",
                "https://www.youtube.com/watch?v=AAPpXm-q7lc&ab_channel=DAREBEE",
                0.85f, 3, 2, TRICEPS, 0);
        insertEjercicio(db, "DIPS TRICEP DE UNA PIERNA", "1. Siéntese en la colchoneta " +
                        "con las rodillas dobladas, los pies juntos y coloque las manos detrás de usted con " +
                        "los dedos hacia adelante.\n" + "2. Levante las caderas del tapete, levante la pierna" +
                        " derecha y comience a doblar los codos.\n" + "3. Baje el cuerpo hasta que los glúteos" +
                        " casi toquen la colchoneta y luego levante las caderas extendiendo los brazos.\n" +
                        "4. Cambie de pierna y repita.","single_leg_tricep",
                "https://www.youtube.com/watch?v=SCqjnTJ_q5k&ab_channel=CHEERFIT",
                0.55f, 3, 2, TRICEPS, 0);
        insertEjercicio(db, "DIPS TRICEP", "1. Coloque sus manos detrás de usted en una " +
                        "silla, de modo que sus dedos miren hacia adelante.\n" + "2. Extienda las piernas y " +
                        "comience a doblar los codos.\n" + "3. Baje el cuerpo hasta que los brazos formen un ángulo" +
                        " de 90 grados.\n" + "4. Levante su cuerpo hacia arriba hasta que sus brazos estén " +
                        "rectos.\n" + "5. Repita.","tricep_dips",
                "https://www.youtube.com/watch?v=3ydgLFLK8e0&ab_channel=WahooFitness",
                0.45f, 3, 2, TRICEPS, 0);
        insertEjercicio(db, "SENTADILLAS DE SALTO DE 180º", "1. Párese con los pies " +
                        "un poco más separados que el ancho de los hombros, los dedos de los pies apuntando" +
                        " ligeramente hacia afuera y recuéstese.\n" + "2. Empuje los talones para saltar, " +
                        "girando 180 grados hacia la izquierda.\n" + "3. Aterrice de puntillas con las " +
                        "rodillas ligeramente flexionadas y agáchese.\n" + "4. Salte rápidamente, girando " +
                        "hacia la derecha y vuelva a la posición de sentadilla.\n" + "5. Repita hasta completar" +
                        " el conjunto.","jump_squat",
                "https://www.youtube.com/watch?v=On1Uf0xCdp8&ab_channel=SWATHealth",
                0.65f, 3, 2, PIERNAS, 0);

        insertEjercicio(db, "SENTADILLA DE OSO", "1. Póngase de rodillas, con las " +
                        "muñecas debajo de los hombros y las rodillas separadas al ancho de las caderas.\n" +
                        "2. Estire las piernas y levante las caderas hacia el techo.\n" +
                        "3. Regrese a la posición inicial y repita hasta completar la serie.","bear_squat",
                "https://www.youtube.com/watch?v=iZoaF6Unr9o&ab_channel=W10PersonalTrainingGym",
                0.55f, 3, 2, PIERNAS, 0);
        insertEjercicio(db, "CÍRCULOS EN EL CIELO", "1. Acuéstese boca arriba con " +
                        "las piernas extendidas y las manos apoyando la cabeza.\n" + "2. Levante los " +
                        "hombros del suelo, levante la pierna derecha en un ángulo de 90 grados y levante " +
                        "la pierna izquierda a sólo unos centímetros del suelo.\n" + "3. Gire lentamente " +
                        "la pierna derecha, haciendo pequeños círculos en el sentido de las agujas del reloj " +
                        "de aproximadamente 1 pie de diámetro.\n" + "4. Complete una serie en una dirección" +
                        " y luego cambie, girando en sentido antihorario.\n" + "5. Baje ambas piernas, cambie " +
                        "de lado y repita.","circles_sky",
                "https://www.youtube.com/watch?v=N5tz2ZYBWSk&ab_channel=NibiruLLC",
                0.45f, 3, 2, PIERNAS, 0);
        insertEjercicio(db, "SENTADILLA COSSACK", "1. Párese con los pies en una " +
                        "posición amplia y con los dedos de los pies apuntando hacia los lados.\n" +
                        "2. Póngase en cuclillas hacia la derecha, bajando tanto como le resulte cómodo.\n" +
                        "3. Regrese a la posición inicial y repita en el lado izquierdo.","cossack_squat",
                "https://www.youtube.com/watch?v=dhDjKmTX8tU&ab_channel=FunctionalBodybuilding",
                0.6f, 3, 2, PIERNAS, 0);
        insertEjercicio(db, "BURPEES", "1. Párese derecho con los pies separados " +
                        "a la altura de los hombros.\n" + "2. Póngase en cuclillas y coloque las manos " +
                        "delante de los pies.\n" + "3. Salte hacia atrás hasta que sus piernas estén " +
                        "completamente extendidas y su cuerpo esté en posición de tabla.\n" + "4. Haga" +
                        " una lagartija, salte hacia adelante y luego empuje con los talones para " +
                        "regresar a la posición inicial.\n" + "5. Repita hasta completar el conjunto.","burpees",
                "https://www.youtube.com/watch?v=Uy2nUNX38xE&ab_channel=Foroatletismo",
                0.65f, 3, 2, PIERNAS, 0);
        insertEjercicio(db, "DIPS DE MARIPOSA", "1. Siéntese en la colchoneta con los pies juntos, coloque las manos detrás de usted con los dedos mirando hacia adelante, doble las rodillas y deje que los muslos se abran.\n" + "2. Estire los brazos mientras presiona las caderas hacia arriba y junte ambas rodillas.\n" + "3. Doble los codos y baje el cuerpo a la posición inicial.\n" + "4. Repita hasta completar el conjunto.","butterfly_dips",
                "https://www.youtube.com/watch?v=1d7XGAqSKJ4&ab_channel=HildaH.Salha", 0.6f, 3, 2,
                TRICEPS, 0);
        insertEjercicio(db, "TRICEP DE UN BRAZO HACIA ARRIBA", "1. Acuéstese sobre su lado derecho con los pies, las caderas y los hombros juntos. Coloque la palma de su mano izquierda sobre la colchoneta frente a su hombro derecho y abrace su cintura con su brazo derecho.\n" + "2. Estire su brazo izquierdo y empuje su torso hacia arriba.\n" + "3. Doble el brazo y baje el torso hacia la colchoneta.\n" + "4. Repita y luego cambie de lado.","one_arm_tricep",
                "https://www.youtube.com/watch?v=jOVCDAfv8xk&ab_channel=ChristinaJensen", 0.55f, 3, 2,
                TRICEPS, 0);
        insertEjercicio(db, "ARRIBA ABAJO TABLÓN", "1. Empiece en posición de plancha, con las muñecas debajo de los hombros y los pies separados a la altura de las caderas.\n" + "2. Doble su brazo izquierdo, coloque su codo izquierdo sobre la colchoneta y luego doble su brazo derecho y coloque su codo derecho sobre la colchoneta.\n" + "3. Coloque su mano izquierda sobre el tapete, estire su brazo izquierdo y luego coloque su mano derecha sobre el tapete y enderece su brazo derecho.\n" + "4. Cambie de lado y repita este movimiento hacia arriba y hacia abajo hasta completar el conjunto.","up_down_plank",
                "https://www.youtube.com/watch?v=AAPpXm-q7lc&ab_channel=DAREBEE", 0.85f, 3, 2,
                TRICEPS, 0);
        insertEjercicio(db, "DIPS TRICEP DE UNA PIERNA", "1. Siéntese en la colchoneta con las rodillas dobladas, los pies juntos y coloque las manos detrás de usted con los dedos hacia adelante.\n" + "2. Levante las caderas del tapete, levante la pierna derecha y comience a doblar los codos.\n" + "3. Baje el cuerpo hasta que los glúteos casi toquen la colchoneta y luego levante las caderas extendiendo los brazos.\n" + "4. Cambie de pierna y repita.","single_leg_tricep",
                "https://www.youtube.com/watch?v=SCqjnTJ_q5k&ab_channel=CHEERFIT", 0.55f, 3, 2,
                TRICEPS, 0);
        insertEjercicio(db, "DIPS TRICEP", "1. Coloque sus manos detrás de usted en una silla, de modo que sus dedos miren hacia adelante.\n" + "2. Extienda las piernas y comience a doblar los codos.\n" + "3. Baje el cuerpo hasta que los brazos formen un ángulo de 90 grados.\n" + "4. Levante su cuerpo hacia arriba hasta que sus brazos estén rectos.\n" + "5. Repita.","tricep_dips",
                "https://www.youtube.com/watch?v=3ydgLFLK8e0&ab_channel=WahooFitness", 0.45f, 3, 2,
                TRICEPS, 0);
        insertEjercicio(db, "SENTADILLAS DE SALTO DE 180º", "1. Párese con los pies un poco más separados que el ancho de los hombros, los dedos de los pies apuntando ligeramente hacia afuera y recuéstese.\n" + "2. Empuje los talones para saltar, girando 180 grados hacia la izquierda.\n" + "3. Aterrice de puntillas con las rodillas ligeramente flexionadas y agáchese.\n" + "4. Salte rápidamente, girando hacia la derecha y vuelva a la posición de sentadilla.\n" + "5. Repita hasta completar el conjunto.","jump_squat",
                "https://www.youtube.com/watch?v=On1Uf0xCdp8&ab_channel=SWATHealth", 0.65f, 3, 2,
                PIERNAS, 0);
        insertEjercicio(db, "SENTADILLA DE OSO", "1. Póngase de rodillas, con las muñecas debajo de los hombros y las rodillas separadas al ancho de las caderas.\n" + "2. Estire las piernas y levante las caderas hacia el techo.\n" + "3. Regrese a la posición inicial y repita hasta completar la serie.","bear_squat",
                "https://www.youtube.com/watch?v=iZoaF6Unr9o&ab_channel=W10PersonalTrainingGym", 0.55f, 3, 2,
                PIERNAS, 0);
        insertEjercicio(db, "CÍRCULOS EN EL CIELO", "1. Acuéstese boca arriba con las piernas extendidas y las manos apoyando la cabeza.\n" + "2. Levante los hombros del suelo, levante la pierna derecha en un ángulo de 90 grados y levante la pierna izquierda a sólo unos centímetros del suelo.\n" + "3. Gire lentamente la pierna derecha, haciendo pequeños círculos en el sentido de las agujas del reloj de aproximadamente 1 pie de diámetro.\n" + "4. Complete una serie en una dirección y luego cambie, girando en sentido antihorario.\n" + "5. Baje ambas piernas, cambie de lado y repita.","circles_sky",
                "https://www.youtube.com/watch?v=N5tz2ZYBWSk&ab_channel=NibiruLLC", 0.45f, 3, 2,
                PIERNAS, 0);
        insertEjercicio(db, "SENTADILLA COSSACK", "1. Párese con los pies en una posición amplia y con los dedos de los pies apuntando hacia los lados.\n" + "2. Póngase en cuclillas hacia la derecha, bajando tanto como le resulte cómodo.\n" + "3. Regrese a la posición inicial y repita en el lado izquierdo.","cossack_squat",
                "https://www.youtube.com/watch?v=dhDjKmTX8tU&ab_channel=FunctionalBodybuilding", 0.6f, 3, 2,
                PIERNAS, 0);
        insertEjercicio(db, "BURPEES", "1. Párese derecho con los pies separados a la altura de los hombros.\n" + "2. Póngase en cuclillas y coloque las manos delante de los pies.\n" + "3. Salte hacia atrás hasta que sus piernas estén completamente extendidas y su cuerpo esté en posición de tabla.\n" + "4. Haga una lagartija, salte hacia adelante y luego empuje con los talones para regresar a la posición inicial.\n" + "5. Repita hasta completar el conjunto.","burpees",
                "https://www.youtube.com/watch?v=Uy2nUNX38xE&ab_channel=Foroatletismo", 0.65f, 3, 2,
                PIERNAS, 0);
        insertEjercicio(db, "PULSADORES DE TOBILLO", "1. Comience en una posición de lagartija, con las manos debajo de los hombros y las piernas extendidas hacia atrás.\n" + "2. Empiece a doblar los codos y baje el pecho hasta que esté justo por encima del suelo.\n" + "3. Mientras empuja hacia la posición inicial, levante las caderas y toque el tobillo izquierdo con la mano derecha.\n" + "4. Regrese a la posición de lagartija y repita en el lado opuesto.\n" + "5. Siga alternando lados hasta que el conjunto esté completo.","ankle_tap",
                "https://www.youtube.com/watch?v=CSUIqyd89-A&ab_channel=ForoatletismoForoatletismo", 0.65f, 3, 2,
                PECHO, 0);
        insertEjercicio(db, "PUSH UPS HINDÚ", "1. Con las manos separadas a la altura de los hombros, el cuerpo en forma de V y los pies separados a la altura de las caderas.\n" + "2. Doble los codos y baje el pecho hasta que esté justo por encima del suelo, adoptando una postura de tabla baja.\n" + "3. Estire los brazos, levante el torso y adopte la postura del perro hacia arriba.\n" + "4. Baja el torso, levanta las caderas y vuelve a la postura del perro boca abajo.\n" + "5. Repita hasta completar el conjunto.","hindu_push",
                "https://www.youtube.com/watch?v=o4SKwIg3RMY&ab_channel=VeronicaTudor", 0.7f, 3, 2,
                PECHO, 0);
        insertEjercicio(db, "EMPUJE ASIMÉTRICO HACIA ARRIBA", "1. Comience en una posición de lagartija con las piernas extendidas hacia atrás y las manos debajo de los hombros.\n" + "2. Coloque su antebrazo izquierdo sobre la colchoneta, con el codo directamente debajo del hombro, y comience a doblar el codo derecho hasta que su pecho esté justo por encima del piso.\n" + "3. Vuelva a la posición inicial, repita y luego cambie de lado.","asymmetrical_push",
                "https://www.youtube.com/watch?v=iAfKvLJBAOM&ab_channel=Musqle", 0.45f, 3, 2,
                PECHO, 0);
        insertEjercicio(db, "FLEXIONES SPIDERMAN", "1. Coloque las manos debajo de los hombros y extienda las piernas hacia atrás.\n" + "2. Empiece a doblar los codos y, al mismo tiempo, lleve la rodilla izquierda al hombro izquierdo.\n" + "3. Empuje hacia arriba y vuelva a la posición inicial.\n" + "4. Repita en el lado derecho hasta completar el fraguado.","spiderman_push",
                "https://www.youtube.com/watch?v=DYONORexgpY&ab_channel=LivestrongWoman", 0.65f, 3, 2,
                PECHO, 0);
        insertEjercicio(db, "FLEXIONES DECLINADAS", "1. Empiece en posición de plancha, con las muñecas debajo de los hombros y los pies separados a la altura de las caderas, y coloque los pies sobre un escalón.\n" + "2. Doble los codos y baje el pecho hasta que esté justo por encima del suelo.\n" + "3. Vuelva a la posición inicial y repita hasta completar la serie.","decline_push",
                "https://www.youtube.com/watch?v=5QFjmotLfW4&ab_channel=shawnadair", 0.55f, 3, 2,
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
