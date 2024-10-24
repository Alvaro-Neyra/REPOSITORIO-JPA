package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Libro;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

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

    public Libro buscarLibro(int id) throws Exception {
        Libro libro = null;
        try {
            libro = em.find(Libro.class, id);
        } catch (Exception e) {
            throw e;
        }
        return libro;
    }

    public Libro modificarLibro(int id, Libro libro) throws Exception {
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

    public Libro eliminarLibro(int id) throws Exception {
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

    public Libro darBaja(int id) throws Exception {
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

    public List<Libro> listarLibros() throws Exception {
        List<Libro> libros = new ArrayList<>();
        try {
            libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
            if (!libros.isEmpty()) {
                System.out.println("Libros encontrados");
            }
        } catch (Exception e) {
            throw e;
        }
        return libros;
    }

    public List<Libro> buscarPorTitulo(String titulo) throws Exception {
        List<Libro> libros = new ArrayList<>();
        try {
            libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class).setParameter("titulo", titulo).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return libros;
    }
}
