package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;

public class EditorialDAO {
    private final EntityManager em;

    public EditorialDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarEditorial(Editorial editorial) throws Exception {
        try {
            em.persist(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial buscarEditorial(Integer id) throws Exception {
        Editorial editorial = null;
        try {
            editorial = em.find(Editorial.class, id);
        } catch (Exception e) {
            throw e;
        }
        return editorial;
    }

    public Editorial modificarEditorial(Integer id, Editorial editorial) throws Exception {
        Editorial editorialModificada = buscarEditorial(id);
        if (editorialModificada == null) {
            throw new Exception("La editorial con ID " + id + " no existe.");
        }
        try {
            editorialModificada.setAlta(editorial.getAlta());
            editorialModificada.setNombre(editorial.getNombre());
            em.merge(editorialModificada);
        } catch (Exception e) {
            throw e;
        }
        return editorialModificada;
    }

    public Editorial eliminarEditorial(Integer id) throws Exception {
        Editorial editorial = buscarEditorial(id);
        if (editorial == null) {
            throw new Exception("La editorial con ID " + id + " no existe.");
        }
        try {
            em.remove(editorial);
        } catch (Exception e) {
            throw e;
        }
        return editorial;
    }

    public Editorial darBaja(Integer id) throws Exception {
        Editorial editorial = buscarEditorial(id);
        if (editorial == null) {
            throw new Exception("La editorial con ID " + id + " no existe.");
        }
        try {
            editorial.setAlta(false);
            em.merge(editorial);
        } catch (Exception e) {
            throw e;
        }
        return editorial;
    }
}
