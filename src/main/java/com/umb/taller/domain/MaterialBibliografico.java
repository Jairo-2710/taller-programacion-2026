package com.umb.taller.domain;
 
 // Clase abstracta que representa un material bibliográfico de una biblioteca
    // Debe tener isbn/codigo, titulo, disponibilidad, y métodos abstractos
    // para calcular días de préstamo y describir el material

    public abstract class MaterialBibliografico {
        private String isbn;
        private String titulo;
        private boolean disponible;

        public MaterialBibliografico(String isbn, String titulo) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.disponible = true; // Por defecto, el material está disponible
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public boolean isDisponible() {
            return disponible;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

        // Método abstracto para calcular los días de préstamo
        public abstract int calcularDiasPrestamo();

        // Método abstracto para describir el material
        public abstract String describirMaterial();
    }