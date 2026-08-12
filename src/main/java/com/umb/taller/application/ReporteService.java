package com.umb.taller.application;

import com.umb.taller.domain.Prestamo;

import java.util.List;

/**
 * Responsabilidad ÚNICA (SRP): generar reportes sobre préstamos.
 * Separada de PrestamoService: la lógica de "cómo se ve un reporte"
 * no debería mezclarse con la lógica de "cómo se crea un préstamo".
 */
public class ReporteService {

    public String generarReportePrestamosActivos(List<Prestamo> prestamos) {
        StringBuilder reporte = new StringBuilder("=== Reporte de préstamos activos ===\n");
        for (Prestamo prestamo : prestamos) {
            reporte.append(prestamo.getUsuario().getNombreCompleto())
                    .append(" - ")
                    .append(prestamo.getMaterial().describirMaterial())
                    .append(" (vence: ")
                    .append(prestamo.getFechaLimiteDevolucion())
                    .append(")\n");
        }
        return reporte.toString();
    }
}
