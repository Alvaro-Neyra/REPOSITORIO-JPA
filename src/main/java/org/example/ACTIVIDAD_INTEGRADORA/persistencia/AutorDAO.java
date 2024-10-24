package org.example.ACTIVIDAD_INTEGRADORA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Autor;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;

import java.util.ArrayList;
import java.util.List;

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

    public Autor buscarAutor(int id) throws Exception {
        Autor autor = null;
        try {
            autor = em.find(Autor.class, id);
        } catch (Exception e) {
            throw e;
        }
        return autor;
    }

    public Autor modificarAutor(int id, Autor autor) throws Exception {
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

    public Autor eliminarAutor(int id) throws Exception {
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

    public Autor darBaja(int id) throws Exception {
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

    public List<Autor> listarAutores() throws Exception {
        List<Autor> autores = new ArrayList<Autor>();
        try {
            autores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
            if (!autores.isEmpty()) {
                System.out.println("Autores encontrados");
            }
        } catch (Exception e) {
            throw e;
        }
        return autores;
    }

    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        List<Autor> autores = new ArrayList<Autor>();
        try {
            autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
            if (!autores.isEmpty()) {
                System.out.println("Autor encontrado");
            }
        } catch (Exception e) {
            throw e;
        }
        return autores;
    }
}
