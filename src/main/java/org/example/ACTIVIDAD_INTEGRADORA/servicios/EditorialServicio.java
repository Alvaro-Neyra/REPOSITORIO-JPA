package org.example.ACTIVIDAD_INTEGRADORA.servicios;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.Validaciones;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;
import org.example.ACTIVIDAD_INTEGRADORA.persistencia.EditorialDAO;

public class EditorialServicio {
    private final EditorialDAO editorialDAO;

    public EditorialServicio(EntityManager e) {
        editorialDAO = new EditorialDAO(e);
    }

    public void guardarEditorial(String nombre, boolean alta) {
        try {
            Validaciones.validarCadenaVacia(nombre, "El nombre no puede estar vacío");
            Validaciones.validarBooleanVacio(alta, "El estado 'alta' no puede ser nulo");

            Editorial nuevaEditorial = new Editorial();
            nuevaEditorial.setNombre(nombre);
            nuevaEditorial.setAlta(alta);
            editorialDAO.guardarEditorial(nuevaEditorial);
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al guardar la editorial!");
            e.printStackTrace();
        }
    }

    public Editorial buscarEditorial(int id) {
        Editorial editorial = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            editorial = editorialDAO.buscarEditorial(id);
            if (editorial != null) {
                System.out.println("Editorial encontrado!! " + editorial.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al buscar la editorial!");
            e.printStackTrace();
        }
        return editorial;
    }

    public Editorial modificarEditorial(int id, Editorial editorial) {
        Editorial editorialModificada = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");
            Validaciones.validarCadenaVacia(editorial.getNombre(), "El nombre no puede estar vacío");
            Validaciones.validarBooleanVacio(editorial.getAlta(), "El estado 'alta' no puede ser nulo");

            editorialModificada = editorialDAO.modificarEditorial(id, editorial);
            if (editorialModificada != null) {
                System.out.println("Editorial modificada!! " + editorialModificada.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al modificar la editorial!");
            e.printStackTrace();
        }
        return editorialModificada;
    }

    public Editorial eliminarEditorial(int id) {
        Editorial editorialEliminada = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            editorialEliminada = editorialDAO.eliminarEditorial(id);
            if (editorialEliminada != null) {
                System.out.println("Editorial eliminada!! " + editorialEliminada.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al eliminar la editorial!");
            e.printStackTrace();
        }
        return editorialEliminada;
    }

    public Editorial darBajaEditorial(int id) {
        Editorial editorialDarBaja = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            editorialDarBaja = editorialDAO.darBaja(id);
            if (editorialDarBaja != null) {
                System.out.println("Editorial dada de baja!! " + editorialDarBaja.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al dar de baja la editorial!");
            e.printStackTrace();
        }
        return editorialDarBaja;
    }
}

