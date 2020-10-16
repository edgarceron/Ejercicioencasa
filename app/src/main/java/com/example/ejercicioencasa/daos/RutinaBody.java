package com.example.ejercicioencasa.daos;

public class RutinaBody {
    int repeticiones;
    RutinaHeader header;
    Ejercicio ejercicio;
    int estado;

    public RutinaBody(int repeticiones, RutinaHeader header, Ejercicio ejercicio, int estado) {
        this.repeticiones = repeticiones;
        this.header = header;
        this.ejercicio = ejercicio;
        this.estado = estado;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setHeader(RutinaHeader header) {
        this.header = header;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public RutinaHeader getHeader() {
        return header;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public int getEstado() {
        return estado;
    }
}
