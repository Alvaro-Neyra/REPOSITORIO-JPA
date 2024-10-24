package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Autor;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;

import java.util.ArrayList;
import java.util.List;

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

    public Editorial buscarEditorial(int id) throws Exception {
        Editorial editorial = null;
        try {
            editorial = em.find(Editorial.class, id);
        } catch (Exception e) {
            throw e;
        }
        return editorial;
    }

    public Editorial modificarEditorial(int id, Editorial editorial) throws Exception {
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

    public Editorial eliminarEditorial(int id) throws Exception {
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

    public Editorial darBaja(int id) throws Exception {
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

    public List<Editorial> listarEditoriales() throws Exception {
        List<Editorial> editoriales = new ArrayList<Editorial>();
        try {
            editoriales = em.createQuery("SELECT e from Editorial e", Editorial.class).getResultList();
            if (!editoriales.isEmpty()) {
                System.out.println("Editoriales encontrados");
            }
        } catch (Exception e) {
            throw e;
        }
        return editoriales;
    }

    public List<Editorial> buscarPorNombre(String nombre) throws Exception {
        List<Editorial> editoriales = new ArrayList<>();
        try {
            editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre", Editorial.class).setParameter("nombre", nombre).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return editoriales;
    }
}
