package com.umb.taller.domain;
// Clase que representa una revista, hereda de MaterialBibliografico
// Debe tener numero de edicion
// El prestamo de una revista dura 7 dias

public class Revista extends MaterialBibliografico {
    private int numeroEdicion;

    public Revista(String isbn, String titulo, int numeroEdicion) {
        super(isbn, titulo);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 7; // El prestamo de una revista dura 7 dias
    }

    @Override
    public String describirMaterial() {
        return "Revista: " + getTitulo() + ", Edición número: " + numeroEdicion + ".";
    }
}

