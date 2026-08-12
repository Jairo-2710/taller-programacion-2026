package com.umb.taller.application;
import com.umb.taller.domain.MaterialBibliografico;
import com.umb.taller.domain.Usuario;
import com.umb.taller.domain.ValidadorPrestamo;

/**
 * Demuestra el uso de ValidadorPrestamo con dos expresiones lambda
 * distintas y una method reference, tal como pide la guía.
 */

public class ValidadoresPrestamo {

public static final ValidadorPrestamo MATERIAL_DISPONIBLE =
        (usuario, material) -> material.isDisponible();

public static final ValidadorPrestamo USUARIO_PUEDE_PEDIR_PRESTAMO =
        (usuario, material) -> usuario.puedeSolicitarPrestamo();

public static final ValidadorPrestamo VALIDACION_COMPLETA =
        ValidadoresPrestamo::validarAmbasCondiciones;

private static boolean validarAmbasCondiciones(Usuario usuario, MaterialBibliografico material) {
        return MATERIAL_DISPONIBLE.esValido(usuario, material)
                && USUARIO_PUEDE_PEDIR_PRESTAMO.esValido(usuario, material);
}       
}
