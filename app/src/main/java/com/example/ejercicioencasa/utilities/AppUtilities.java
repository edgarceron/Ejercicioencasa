package com.example.ejercicioencasa.utilities;

import android.content.Context;
import android.content.Intent;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;
import com.example.ejercicioencasa.daos.RutinaBody;

public class AppUtilities {
    public static void alterInfoUsuario(String codigo, String valor, Context context){
        InfoUsuario infoUsuario = new InfoUsuario(codigo,valor);
        InfoUsuarioDao infoUsuarioDao = new InfoUsuarioDao(context);
        infoUsuarioDao.alterInfoUsuario(infoUsuario);
    }

    public static Intent putInfoIntent(Intent intent, RutinaBody siguiente, int id_rutina_header){
        intent.putExtra("nombre", siguiente.getEjercicio().getNombre());
        intent.putExtra("descripcion", siguiente.getEjercicio().getDescripcion());
        intent.putExtra("gif", siguiente.getEjercicio().getGif());
        intent.putExtra("url", siguiente.getEjercicio().getUrl());
        intent.putExtra("id_ejercicio", siguiente.getEjercicio().getId());
        intent.putExtra("id_rutina_header", id_rutina_header);
        intent.putExtra("repeticiones", siguiente.getRepeticiones());
        intent.putExtra("tiempo", siguiente.getRepeticiones() * siguiente.getEjercicio().getTiempoRepeticion());
        return  intent;
    }
}
