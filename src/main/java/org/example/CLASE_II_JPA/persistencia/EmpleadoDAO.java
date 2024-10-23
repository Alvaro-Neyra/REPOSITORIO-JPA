package org.example.CLASE_II_JPA.persistencia;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.CLASE_II_JPA.entidades.Empleado;

public class EmpleadoDAO {
    private final EntityManager em;

    public EmpleadoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarEmpleado(Empleado empleado) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public Empleado buscarEmpleado(int id) throws Exception {
        Empleado empleado = null;
        try {
            em.getTransaction().begin();
            empleado = em.find(Empleado.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return empleado;
    }

    public Empleado modificarEmpleado(int id, Empleado empleado) throws Exception {
        Empleado empleadoAux = null;
        try {
            empleadoAux = buscarEmpleado(id);
            empleadoAux.setCodigoEmpleado(empleado.getCodigoEmpleado());
            empleadoAux.setNombre(empleado.getNombre());
            empleadoAux.setApellido(empleado.getApellido());
            empleadoAux.setEmail(empleado.getEmail());
            empleadoAux.setExtension(empleado.getExtension());
            empleadoAux.setOficina(empleado.getOficina());
            empleadoAux.setPuesto(empleado.getPuesto());
            empleadoAux.setIdJefe(empleado.getIdJefe());
            em.getTransaction().begin();
            em.merge(empleadoAux);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return empleadoAux;
    }

    public Empleado eliminarEmpleado(int id) throws Exception {
        Empleado empleado = null;
        try {
            em.getTransaction().begin();
            empleado = buscarEmpleado(id);
            em.remove(empleado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return empleado;
    }

    public List<Empleado> listarEmpleados() throws Exception {
        return em.createQuery("SELECT e FROM EmpleadoV2 e", Empleado.class).getResultList();
    }

    public List<Empleado> listarEmpleadosPorIdOficina(int idOficina) throws Exception {
        return em.createQuery("SELECT e FROM EmpleadoV2 e WHERE e.oficina.idOficina = :idOficina", Empleado.class)
                .setParameter("idOficina", idOficina).getResultList();
    }

    public List<Empleado> listarEmpleadosPorNombreOficina(String nombreOficina) throws Exception {
        return em.createQuery("SELECT e FROM EmpleadoV2 e WHERE e.nombre LIKE :nombreOficina", Empleado.class)
                .setParameter("nombreOficina", "%" + nombreOficina + "%").getResultList();
    }

    public List<Empleado> listarJefes() throws Exception {
        return em.createQuery("SELECT e FROM EmpleadoV2 e WHERE e.idJefe <= 0", Empleado.class).getResultList();
    }
}
