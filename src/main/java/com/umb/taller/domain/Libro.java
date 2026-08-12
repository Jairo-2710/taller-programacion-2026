package com.umb.taller.domain;

// Clase que representa un libro, hereda de MaterialBibliografico
// Debe tener autor y numero de paginas
// El prestamo de un libro dura 15 dias

public class Libro extends MaterialBibliografico {
    private String autor;
    private int numeroPaginas;

    public Libro(String isbn, String titulo, String autor, int numeroPaginas) {
        super(isbn, titulo);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 15; // El prestamo de un libro dura 15 dias
    }

    @Override
    public String describirMaterial() {
        return "Libro: " + getTitulo() + " por " + autor + ", " + numeroPaginas + " páginas.";
    }
}   