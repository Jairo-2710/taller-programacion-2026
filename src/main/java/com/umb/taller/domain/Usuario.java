package com.umb.taller.domain;

// Clase que representa un usuario de la biblioteca
// Debe tener codigo de estudiante, nombre completo
// Debe controlar que no pueda pedir mas de 3 prestamos a la vez

public class Usuario {
    private String codigoEstudiante;
    private String nombreCompleto;
    private int prestamosActivos;

    public Usuario(String codigoEstudiante, String nombreCompleto) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreCompleto = nombreCompleto;
        this.prestamosActivos = 0; // Inicialmente no tiene prestamos activos
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }
    
    public boolean puedeSolicitarPrestamo() {
        return prestamosActivos < 3;
    }

    public boolean realizarPrestamo() {
        if (prestamosActivos < 3) {
            prestamosActivos++;
        return true;

    } else {
        return false;
        }
    }

    // Método para devolver un préstamo
    public void devolverPrestamo() {
        if (prestamosActivos > 0) {
            prestamosActivos--;
        }
    }
}
