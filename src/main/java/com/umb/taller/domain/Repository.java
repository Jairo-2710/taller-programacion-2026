package com.umb.taller.domain;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz genérica de repositorio (DIP). Los servicios dependen de
 * esta ABSTRACCIÓN, nunca de una implementación concreta (ej. una
 * base de datos específica). Eso permite cambiar la implementación
 * (en memoria, SQL, MongoDB, etc.) sin tocar la lógica de negocio.
 */
public interface Repository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
