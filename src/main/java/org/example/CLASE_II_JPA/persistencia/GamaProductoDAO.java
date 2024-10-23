package org.example.CLASE_II_JPA.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.CLASE_II_JPA.entidades.GamaProducto;

import java.util.List;

public class GamaProductoDAO {
    private final EntityManager em;

    public GamaProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
        em.getTransaction().begin();
        em.persist(gamaProducto);
        em.getTransaction().commit();
    }

    public GamaProducto buscarGamaProducto(int id) throws Exception {
        GamaProducto gamaProducto = null;
        try {
            em.getTransaction().begin();
            gamaProducto = em.find(GamaProducto.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return gamaProducto;
    }

    public GamaProducto modificarGamaProducto(int id, GamaProducto nuevoGamaProducto) throws Exception {
        GamaProducto gamaProducto = null;
        try {
            gamaProducto = buscarGamaProducto(id);
            gamaProducto.setGama((nuevoGamaProducto.getGama()));
            gamaProducto.setImagen(nuevoGamaProducto.getImagen());
            gamaProducto.setDescripcionHtml(nuevoGamaProducto.getDescripcionHtml());
            gamaProducto.setDescripcionTexto(nuevoGamaProducto.getDescripcionTexto());
            em.getTransaction().begin();
            em.merge(gamaProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return gamaProducto;
    }

    public GamaProducto eliminarGamaProducto(int id) throws Exception {
        GamaProducto gamaProducto = null;
        try {
            gamaProducto = buscarGamaProducto(id);
            em.getTransaction().begin();
            em.remove(gamaProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return gamaProducto;
    }

    public List<GamaProducto> listarGamaProductos() throws Exception {
        return em.createQuery("SELECT gp FROM GamaProductoV2 gp", GamaProducto.class).getResultList();
    }
}
