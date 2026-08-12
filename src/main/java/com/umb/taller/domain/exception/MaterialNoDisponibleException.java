package com.umb.taller.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel 3: se lanza cuando se busca un material o usuario que no existe
 * en el sistema. Incluye logging con SLF4J en el punto de creación,
 * para dejar rastro del error sin obligar a quien la captura a loguear.
 */
public class MaterialNoDisponibleException extends DomainException {

    private static final Logger logger = LoggerFactory.getLogger(MaterialNoDisponibleException.class);

    public MaterialNoDisponibleException(String mensaje) {
        super(mensaje);
        logger.warn("MaterialNoDisponibleException: {}", mensaje);
    }
}
