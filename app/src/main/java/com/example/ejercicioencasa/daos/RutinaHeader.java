package com.example.ejercicioencasa.daos;

public class RutinaHeader {

    int id;
    int duracion;
    int estado;



    public RutinaHeader(int id, int duracion, int estado) {
        this.id = id;
        this.duracion = duracion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
}
