package com.umb.taller.domain;

/**
 * Interfaz funcional para validar si un préstamo puede realizarse.
 * Permite implementar distintas reglas de validación como expresiones
 * lambda sin necesidad de crear una clase nueva por cada regla.
 */
@FunctionalInterface
public interface ValidadorPrestamo {
    boolean esValido(Usuario usuario, MaterialBibliografico material);
}
