package org.example.ACTIVIDAD_INTEGRADORA.servicios;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Libro;
import org.example.ACTIVIDAD_INTEGRADORA.persistencia.LibroDAO;
import org.example.ACTIVIDAD_INTEGRADORA.Validaciones;

public class LibroServicio {
    private final LibroDAO libroDAO;

    public LibroServicio(EntityManager e) {
        this.libroDAO = new LibroDAO(e);
    }

    public void guardarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Boolean alta) {
        try {
            Validaciones.validarNumeroVacio(isbn, "El ISBN no puede estar vacio");
            Validaciones.validarCadenaVacia(titulo, "El título no puede estar vacío");
            Validaciones.validarNumeroVacio(anio, "El año no puede estar vacío");
            Validaciones.validarNumeroVacio(ejemplares, "El número de ejemplares no puede estar vacío");
            Validaciones.validarBooleanVacio(alta, "El estado 'alta' no puede ser nulo");

            Libro nuevoLibro = new Libro();
            nuevoLibro.setIsbn(isbn);
            nuevoLibro.setTitulo(titulo);
            nuevoLibro.setAnio(anio);
            nuevoLibro.setEjemplares(ejemplares);
            nuevoLibro.setAlta(alta);
            libroDAO.guardarLibro(nuevoLibro);
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al guardar el libro!");
            e.printStackTrace();
        }
    }

    public Libro buscarLibro(Integer id) {
        Libro libro = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            libro = libroDAO.buscarLibro(id);
            if (libro != null) {
                System.out.println("Libro encontrado!! " + libro.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al buscar libro!");
            e.printStackTrace();
        }
        return libro;
    }

    public Libro modificarLibro(Integer id, Libro libro) {
        Libro libroModificado = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");
            Validaciones.validarCadenaVacia(libro.getTitulo(), "El título no puede estar vacío");
            Validaciones.validarNumeroVacio(libro.getIsbn(), "El ISBN no puede estar vacio");
            Validaciones.validarNumeroVacio(libro.getAnio(), "El anio no puede estar vacio");
            Validaciones.validarBooleanVacio(libro.getAlta(), "El estado 'alta' no puede ser nulo");
            Validaciones.validarNumeroVacio(libro.getEjemplares(), "Los ejemplares no puede estar vacio");

            libroModificado = libroDAO.modificarLibro(id, libro);
            if (libroModificado != null) {
                System.out.println("Libro modificado!! " + libroModificado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al modificar libro!");
            e.printStackTrace();
        }
        return libroModificado;
    }

    public Libro eliminarLibro(Integer id) {
        Libro libroEliminado = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            libroEliminado = libroDAO.eliminarLibro(id);
            if (libroEliminado != null) {
                System.out.println("Libro eliminado!! " + libroEliminado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al eliminar libro!");
            e.printStackTrace();
        }
        return libroEliminado;
    }

    public Libro darBajaLibro(Integer id) {
        Libro libroDarBaja = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            libroDarBaja = libroDAO.darBaja(id);
            if (libroDarBaja != null) {
                System.out.println("Libro dado de baja!! " + libroDarBaja.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al dar la baja de libro!");
            e.printStackTrace();
        }
        return libroDarBaja;
    }
}

