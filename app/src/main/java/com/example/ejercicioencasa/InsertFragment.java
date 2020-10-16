package com.example.ejercicioencasa;

import androidx.fragment.app.Fragment;

import com.example.ejercicioencasa.daos.InfoUsuario;
import com.example.ejercicioencasa.daos.InfoUsuarioDao;

public class InsertFragment extends Fragment {

    public InsertFragment() {

    }

    public void alterInfoUsuario(String codigo, String valor){
        InfoUsuario infoUsuario = new InfoUsuario(codigo,valor);
        InfoUsuarioDao infoUsuarioDao = new InfoUsuarioDao(getContext());
        infoUsuarioDao.alterInfoUsuario(infoUsuario);
    }
}
