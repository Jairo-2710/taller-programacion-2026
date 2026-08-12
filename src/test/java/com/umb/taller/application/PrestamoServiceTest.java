package com.umb.taller.application;

import com.umb.taller.domain.*;
import com.umb.taller.domain.exception.LimitePrestamosExcedidoException;
import com.umb.taller.domain.exception.MaterialNoDisponibleException;
import com.umb.taller.infrastructure.MaterialRepositoryEnMemoria;
import com.umb.taller.infrastructure.PrestamoRepositoryEnMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrestamoServiceTest {

    private PrestamoService prestamoService;
    private Usuario usuario;
    private MaterialBibliografico libro;

    @BeforeEach
    void setUp() {
        prestamoService = new PrestamoService(new PrestamoRepositoryEnMemoria());
        usuario = new Usuario("EST-001", "Jairo Esteban Ojeda");
        libro = new Libro("ISBN-001", "Clean Code", "Robert C. Martin", 464);
    }

    @Test
    void deberiaCrearPrestamoCuandoMaterialDisponibleYUsuarioSinLimite() {
        Prestamo prestamo = prestamoService.crearPrestamo(usuario, libro);

        assertThat(prestamo).isNotNull();
        assertThat(prestamo.getUsuario()).isEqualTo(usuario);
        assertThat(libro.isDisponible()).isFalse();
    }

    @Test
    void deberiaLanzarExcepcionCuandoMaterialNoEstaDisponible() {
        libro.setDisponible(false);

        assertThatThrownBy(() -> prestamoService.crearPrestamo(usuario, libro))
                .isInstanceOf(MaterialNoDisponibleException.class)
                .hasMessageContaining("no está disponible");
    }

    @Test
    void deberiaLanzarExcepcionCuandoUsuarioExcedeLimiteDePrestamos() {
        prestamoService.crearPrestamo(usuario, new Libro("ISBN-002", "Libro 2", "Autor", 100));
        prestamoService.crearPrestamo(usuario, new Libro("ISBN-003", "Libro 3", "Autor", 100));
        prestamoService.crearPrestamo(usuario, new Libro("ISBN-004", "Libro 4", "Autor", 100));

        MaterialBibliografico cuartoLibro = new Libro("ISBN-005", "Libro 5", "Autor", 100);

        assertThatThrownBy(() -> prestamoService.crearPrestamo(usuario, cuartoLibro))
                .isInstanceOf(LimitePrestamosExcedidoException.class);
    }

    @Test
    void jerarquiaDeExcepcionesDeberiaExtenderAppException() {
        MaterialNoDisponibleException excepcion = new MaterialNoDisponibleException("prueba");

        assertThat(excepcion).isInstanceOf(RuntimeException.class);
        assertThat(excepcion.getMessage()).isEqualTo("prueba");
    }

    @Test
    void devolverPrestamoDeberiaLiberarElMaterial() {
        Prestamo prestamo = prestamoService.crearPrestamo(usuario, libro);
        assertThat(libro.isDisponible()).isFalse();

        prestamoService.devolverPrestamo(prestamo);

        assertThat(libro.isDisponible()).isTrue();
        assertThat(usuario.getPrestamosActivos()).isZero();
    }
}
