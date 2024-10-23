package org.example.CLASE_II_JPA.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.CLASE_II_JPA.entidades.Oficina;
import java.util.List;

public class OficinaDAO {
    private final EntityManager em;

    public OficinaDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarOficina(Oficina oficina) {
        em.getTransaction().begin();
        em.persist(oficina);
        em.getTransaction().commit();
    }

    public Oficina buscarOficina(int id) {
        Oficina oficina = null;
        try {
            em.getTransaction().begin();
            oficina = em.find(Oficina.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return oficina;
    }

    public Oficina modificarOficina(int id, Oficina oficina) {
        Oficina oficinaModificada = null;
        try {
            oficinaModificada = buscarOficina(id);
            oficinaModificada.setCodigoOficina(oficina.getCodigoOficina());
            oficinaModificada.setCiudad(oficina.getCiudad());
            oficinaModificada.setPais(oficina.getPais());
            oficinaModificada.setRegion(oficina.getRegion());
            oficinaModificada.setCodigoPostal(oficina.getCodigoPostal());
            oficinaModificada.setTelefono(oficina.getTelefono());
            em.getTransaction().begin();
            oficinaModificada = em.merge(oficina);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return oficinaModificada;
    }

    public Oficina eliminarOficina(int id) throws Exception{
        Oficina oficina = null;
        try {
            oficina = buscarOficina(id);
            em.getTransaction().begin();
            em.remove(oficina);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return oficina;
    }

    public List<Oficina> listarTodas() throws Exception{
        return em.createQuery("SELECT o FROM OficinaV2 o", Oficina.class).getResultList();
    }
}
