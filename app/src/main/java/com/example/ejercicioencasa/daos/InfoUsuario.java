package com.example.ejercicioencasa.daos;

public class InfoUsuario {
    String codigo;
    String valor;

    public static final String SEXO = "sexo";
    public static final String PESO = "peso";
    public static final String ALTURA = "altura";
    public static final String AMIGABLE = "amigable";
    public static final String OBJETIVO = "objetivo";
    public static final String CALENTAMIENTO = "calentamiento";
    public static final String DIFICULTAD = "dificultad";

    public InfoUsuario(String codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
