package com.umb.taller.infrastructure;
import com.umb.taller.domain.Repository;
import com.umb.taller.domain.Usuario;
import java.util.*;

/**
 * Implementación CONCRETA del repositorio de usuarios, en memoria.
 * Los servicios nunca dependen de esta clase directamente, sino de
 * la interfaz Repository<Usuario, String> (DIP).
 */
public class UsuarioRepositoryEnMemoria implements Repository<Usuario, String> {

    private final Map<String, Usuario> almacenamiento = new HashMap<>();

    @Override
    public Usuario save(Usuario entity) {
        almacenamiento.put(entity.getCodigoEstudiante(), entity);
        return entity;
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void deleteById(String id) {
        almacenamiento.remove(id);
    }
}
