package com.example.ejercicioencasa.utilities;

import android.content.Context;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;

public class AppUtilities {
    public static void alterInfoUsuario(String codigo, String valor, Context context){
        InfoUsuario infoUsuario = new InfoUsuario(codigo,valor);
        InfoUsuarioDao infoUsuarioDao = new InfoUsuarioDao(context);
        infoUsuarioDao.alterInfoUsuario(infoUsuario);
    }
}
