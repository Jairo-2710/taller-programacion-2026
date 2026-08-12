package com.umb.taller.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel 3: se lanza cuando un dato de entrada no cumple las reglas de
 * validación del dominio (ej. campos vacíos o nulos).
 */
public class ValidationException extends DomainException {

    private static final Logger logger = LoggerFactory.getLogger(ValidationException.class);

    public ValidationException(String mensaje) {
        super(mensaje);
        logger.warn("ValidationException: {}", mensaje);
    }
}
