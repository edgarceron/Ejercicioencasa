package com.example.ejercicioencasa.daos;

public class Ejercicio {
    int id;
    String nombre;
    String descripcion;
    String gif;
    String url;
    float calorias;
    int tiempoRepeticion;
    int dificultad;
    String musuclo;
    int ruido;

    public Ejercicio(int id, String nombre, String descripcion, String gif, String url, float calorias, int tiempoRepeticion, int dificultad, String musuclo, int ruido) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gif = gif;
        this.url = url;
        this.calorias = calorias;
        this.tiempoRepeticion = tiempoRepeticion;
        this.dificultad = dificultad;
        this.musuclo = musuclo;
        this.ruido = ruido;
    }

    public Ejercicio(String nombre, String descripcion, String gif, String url, float calorias, int tiempoRepeticion, int dificultad, String musuclo, int ruido) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gif = gif;
        this.url = url;
        this.calorias = calorias;
        this.tiempoRepeticion = tiempoRepeticion;
        this.dificultad = dificultad;
        this.musuclo = musuclo;
        this.ruido = ruido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGif() {
        return gif;
    }

    public String getUrl() {
        return url;
    }

    public float getCalorias() {
        return calorias;
    }

    public int getTiempoRepeticion() {
        return tiempoRepeticion;
    }

    public int getDificultad() {
        return dificultad;
    }

    public String getMusuclo() {
        return musuclo;
    }

    public int getRuido() {
        return ruido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public void setTiempoRepeticion(int tiempoRepeticion) {
        this.tiempoRepeticion = tiempoRepeticion;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void setMusuclo(String musuclo) {
        this.musuclo = musuclo;
    }

    public void setRuido(int ruido) {
        this.ruido = ruido;
    }
}
