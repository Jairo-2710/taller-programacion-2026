package com.umb.taller.application;

import com.umb.taller.domain.Repository;
import com.umb.taller.domain.Usuario;

/**
 * Responsabilidad ÚNICA (SRP): enviar notificaciones a usuarios.
 * Separada de PrestamoService para que un cambio en la lógica de envío
 * de correos no afecte la lógica de negocio de los préstamos.
 *
 * Aplica DIP: depende de la ABSTRACCIÓN Repository<Usuario, String>,
 * inyectada por constructor, para poder buscar usuarios sin acoplarse
 * a una implementación concreta de almacenamiento.
 */

public class NotificacionService {

    private final Repository<Usuario, String> usuarioRepository;

    public NotificacionService(Repository<Usuario, String> usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void notificarPorCodigoEstudiante(String codigoEstudiante, String tituloMaterial) {
        Usuario usuario = usuarioRepository.findById(codigoEstudiante)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        notificarPrestamoRealizado(usuario, tituloMaterial);
    }

    public void notificarPrestamoRealizado(Usuario usuario, String tituloMaterial) {
        // En una implementación real, aquí iría la integración con un
        // servicio de correo (SMTP, SendGrid, etc.)
        System.out.println("Notificación para " + usuario.getNombreCompleto()
                + ": préstamo de '" + tituloMaterial + "' realizado con éxito.");
    }

    public void notificarProximoVencimiento(Usuario usuario, String tituloMaterial) {
        System.out.println("Recordatorio para " + usuario.getNombreCompleto()
                + ": '" + tituloMaterial + "' está próximo a vencer.");
    }
}
