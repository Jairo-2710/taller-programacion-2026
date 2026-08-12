package com.umb.taller.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel 3: se lanza cuando se viola una regla de negocio del dominio,
 * como el límite máximo de préstamos activos por usuario.
 */
public class LimitePrestamosExcedidoException extends DomainException {

    private static final Logger logger = LoggerFactory.getLogger(LimitePrestamosExcedidoException.class);

    public LimitePrestamosExcedidoException(String mensaje) {
        super(mensaje);
        logger.warn("LimitePrestamosExcedidoException: {}", mensaje);
    }
}
