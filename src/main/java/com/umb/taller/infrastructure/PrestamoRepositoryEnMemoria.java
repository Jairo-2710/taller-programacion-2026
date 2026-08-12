package com.umb.taller.infrastructure;

import com.umb.taller.domain.Prestamo;
import com.umb.taller.domain.Repository;

import java.util.*;

public class PrestamoRepositoryEnMemoria implements Repository<Prestamo, String> {

    private final Map<String, Prestamo> almacenamiento = new HashMap<>();

    @Override
    public Prestamo save(Prestamo entity) {
        almacenamiento.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Prestamo> findById(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Prestamo> findAll() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void deleteById(String id) {
        almacenamiento.remove(id);
    }
}
