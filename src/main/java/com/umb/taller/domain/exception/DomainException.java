package com.umb.taller.domain.exception;

/**
 * Excepción de nivel 2: agrupa todos los errores relacionados con
 * reglas del dominio de la biblioteca (a diferencia de errores técnicos
 * como fallos de red o de base de datos, que serían otra rama distinta).
 */
public abstract class DomainException extends AppException {

    protected DomainException(String mensaje) {
        super(mensaje);
    }
}
