package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Autor;

public class AutorDAO {
    private final EntityManager em;

    public AutorDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarAutor(Autor autor) throws Exception {
        try {
            em.persist(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarAutor(Integer id) throws Exception {
        Autor autor = null;
        try {
            autor = em.find(Autor.class, id);
        } catch (Exception e) {
            throw e;
        }
        return autor;
    }

    public Autor modificarAutor(Integer id, Autor autor) throws Exception {
        Autor autorModificado = buscarAutor(id);
        if (autorModificado == null) {
            throw new Exception("El autor con ID " + id + " no existe.");
        }
        try {
            autorModificado.setNombre(autor.getNombre());
            autorModificado.setAlta(autor.getAlta());
            em.merge(autorModificado);
        } catch (Exception e) {
            throw e;
        }
        return autorModificado;
    }

    public Autor eliminarAutor(Integer id) throws Exception {
        Autor autor = buscarAutor(id);
        if (autor == null) {
            throw new Exception("El autor con ID " + id + " no existe.");
        }
        try {
            em.remove(autor);
        } catch (Exception e) {
            throw e;
        }
        return autor;
    }

    public Autor darBaja(Integer id) throws Exception {
        Autor autor = buscarAutor(id);
        if (autor == null) {
            throw new Exception("El autor con ID " + id + " no existe.");
        }
        try {
            autor.setAlta(false);
            em.merge(autor);
        } catch (Exception e) {
            throw e;
        }
        return autor;
    }
}
