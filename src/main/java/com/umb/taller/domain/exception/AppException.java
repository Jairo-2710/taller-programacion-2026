package com.umb.taller.domain.exception;

/**
 * Excepción base abstracta de toda la aplicación. Nivel 1 de la jerarquía.
 * Todas las excepciones propias del proyecto heredan de esta.
 */
public abstract class AppException extends RuntimeException {

    protected AppException(String mensaje) {
        super(mensaje);
    }

    protected AppException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
