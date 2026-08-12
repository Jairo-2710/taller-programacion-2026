package com.umb.taller.application;
import com.umb.taller.domain.MaterialBibliografico;
import com.umb.taller.domain.Prestamo;
import com.umb.taller.domain.Repository;
import com.umb.taller.domain.Usuario;
import com.umb.taller.domain.exception.LimitePrestamosExcedidoException;
import com.umb.taller.domain.exception.MaterialNoDisponibleException;

/**
 * Responsabilidad ÚNICA (SRP): gestionar la creación y devolución de
 * préstamos. No sabe nada de notificaciones, reportes ni persistencia.
 *
 * Aplica DIP: depende de la ABSTRACCIÓN Repository<Prestamo, String>,
 * inyectada por constructor, en vez de crear su propia implementación
 * concreta de persistencia.
 */

public class PrestamoService {

    private final Repository<Prestamo, String> prestamoRepository;

    public PrestamoService(Repository<Prestamo, String> prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Prestamo crearPrestamo(Usuario usuario, MaterialBibliografico material) {
        if (!material.isDisponible()) {
            throw new MaterialNoDisponibleException(
                    "El material '" + material.getTitulo() + "' no está disponible.");
        }
        if (!usuario.puedeSolicitarPrestamo()) {
            throw new LimitePrestamosExcedidoException(
                    "El usuario " + usuario.getNombreCompleto() + " ya alcanzó el límite de préstamos.");
        }
        Prestamo prestamo = new Prestamo(usuario, material);
        return prestamoRepository.save(prestamo);
    }

    public void devolverPrestamo(Prestamo prestamo) {
        prestamo.devolver();
    }
}
