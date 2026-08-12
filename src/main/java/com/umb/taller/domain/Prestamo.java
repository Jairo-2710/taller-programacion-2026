package com.umb.taller.domain;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa el préstamo de un material a un usuario. Demuestra
 * ASOCIACIÓN: relaciona dos objetos de otras clases (Usuario y
 * MaterialBibliografico) sin que ninguna dependa de Prestamo para existir.
 */
public class Prestamo {

    private final String id;
    private final Usuario usuario;
    private final MaterialBibliografico material;
    private final LocalDate fechaPrestamo;
    private final LocalDate fechaLimiteDevolucion;

    public Prestamo(Usuario usuario, MaterialBibliografico material) {
        this.id = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = LocalDate.now();
        this.fechaLimiteDevolucion = fechaPrestamo.plusDays(material.calcularDiasPrestamo());

        usuario.realizarPrestamo();
        material.setDisponible(false);
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaLimiteDevolucion);
    }

    public void devolver() {
        usuario.devolverPrestamo();
        material.setDisponible(true);
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public MaterialBibliografico getMaterial() {
        return material;
    }

    public LocalDate getFechaLimiteDevolucion() {
        return fechaLimiteDevolucion;
    }
}
