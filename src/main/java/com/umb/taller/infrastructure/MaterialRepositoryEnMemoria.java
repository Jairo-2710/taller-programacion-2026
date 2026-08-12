package com.umb.taller.infrastructure;

import com.umb.taller.domain.MaterialBibliografico;
import com.umb.taller.domain.Repository;

import java.util.*;

public class MaterialRepositoryEnMemoria implements Repository<MaterialBibliografico, String> {

    private final Map<String, MaterialBibliografico> almacenamiento = new HashMap<>();

    @Override
    public MaterialBibliografico save(MaterialBibliografico entity) {
        almacenamiento.put(entity.getIsbn(), entity);
        return entity;
    }

    @Override
    public Optional<MaterialBibliografico> findById(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<MaterialBibliografico> findAll() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void deleteById(String id) {
        almacenamiento.remove(id);
    }
}
