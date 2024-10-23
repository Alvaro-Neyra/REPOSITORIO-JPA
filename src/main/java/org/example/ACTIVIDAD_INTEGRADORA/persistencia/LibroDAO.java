package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Libro;

public class LibroDAO {
    private final EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarLibro(Libro libro) throws Exception {
        try {
            em.persist(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public Libro buscarLibro(Integer id) throws Exception {
        Libro libro = null;
        try {
            libro = em.find(Libro.class, id);
        } catch (Exception e) {
            throw e;
        }
        return libro;
    }

    public Libro modificarLibro(Integer id, Libro libro) throws Exception {
        Libro libroModificado = buscarLibro(id);
        if (libroModificado == null) {
            throw new Exception("El libro con ID " + id + " no existe.");
        }
        try {
            libroModificado.setTitulo(libro.getTitulo());
            libroModificado.setAlta(libro.getAlta());
            libroModificado.setAnio(libro.getAnio());
            libroModificado.setEjemplares(libro.getEjemplares());
            libroModificado.setIsbn(libro.getIsbn());
            em.merge(libroModificado);
        } catch (Exception e) {
            throw e;
        }
        return libroModificado;
    }

    public Libro eliminarLibro(Integer id) throws Exception {
        Libro libro = buscarLibro(id);
        if (libro == null) {
            throw new Exception("El libro con ID " + id + " no existe.");
        }
        try {
            em.remove(libro);
        } catch (Exception e) {
            throw e;
        }
        return libro;
    }

    public Libro darBaja(Integer id) throws Exception {
        Libro libro = buscarLibro(id);
        if (libro == null) {
            throw new Exception("El libro con ID " + id + " no existe.");
        }
        try {
            libro.setAlta(false);
            em.merge(libro);
        } catch (Exception e) {
            throw e;
        }
        return libro;
    }
}
