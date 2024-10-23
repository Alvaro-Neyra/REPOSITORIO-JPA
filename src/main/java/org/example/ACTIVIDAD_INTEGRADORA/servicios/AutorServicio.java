package org.example.ACTIVIDAD_INTEGRADORA.servicios;

import com.google.protobuf.ValueOrBuilder;
import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Autor;
import org.example.ACTIVIDAD_INTEGRADORA.persistencia.AutorDAO;
import org.example.ACTIVIDAD_INTEGRADORA.Validaciones;

public class AutorServicio {
    private final AutorDAO autorDAO;

    public AutorServicio(EntityManager em) {
        autorDAO = new AutorDAO(em);
    }

    public void guardarAutor(String nombre, Boolean alta) {
        try {
            Validaciones.validarCadenaVacia(nombre, "El nombre no puede estar vacío");
            Validaciones.validarBooleanVacio(alta, "El estado 'alta' no puede ser nulo");

            Autor nuevoAutor = new Autor();
            nuevoAutor.setNombre(nombre);
            nuevoAutor.setAlta(alta);
            autorDAO.guardarAutor(nuevoAutor);
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al guardar autor!");
            e.printStackTrace();
        }
    }

    public Autor buscarAutor(Integer id) {
        Autor autorBuscado = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            autorBuscado = autorDAO.buscarAutor(id);
            if (autorBuscado != null) {
                System.out.println("Autor encontrado!: " + autorBuscado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al buscar autor!");
            e.printStackTrace();
        }
        return autorBuscado;
    }

    public Autor modificarAutor(Integer id, Autor autor) {
        Autor autorModificado = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");
            Validaciones.validarCadenaVacia(autor.getNombre(), "El nombre no puede estar vacío");
            Validaciones.validarBooleanVacio(autor.getAlta(), "El estado 'alta' no puede ser nulo");

            autorModificado = autorDAO.modificarAutor(id, autor);
            if (autorModificado != null) {
                System.out.println("Autor modificado!: " + autorModificado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al modificar autor!");
            e.printStackTrace();
        }
        return autorModificado;
    }

    public Autor eliminarAutor(Integer id) {
        Autor autorEliminado = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            autorEliminado = autorDAO.eliminarAutor(id);
            if (autorEliminado != null) {
                System.out.println("Autor eliminado correctamente!: " + autorEliminado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al eliminar autor!");
            e.printStackTrace();
        }
        return autorEliminado;
    }

    public Autor darBajaAutor(Integer id) {
        Autor autorDarBaja = null;
        try {
            Validaciones.validarNumeroVacio(id, "El ID no puede estar vacío");

            autorDarBaja = autorDAO.darBaja(id);
            if (autorDarBaja != null) {
                System.out.println("Autor se ha desactivado correctamente!: " + autorDarBaja.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al dar baja al autor!");
            e.printStackTrace();
        }
        return autorDarBaja;
    }
}

