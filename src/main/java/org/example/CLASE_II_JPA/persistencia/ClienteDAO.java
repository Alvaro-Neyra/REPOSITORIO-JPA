package org.example.CLASE_II_JPA.persistencia;

import jakarta.persistence.EntityManager;
import org.example.CLASE_II_JPA.entidades.Cliente;

import java.util.List;

public class ClienteDAO {
    private final EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarCliente(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public Cliente buscarCliente(int id) throws Exception {
        Cliente cliente = null;
        try {
            em.getTransaction().begin();
            cliente = em.find(Cliente.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return cliente;
    }

    public Cliente modificarCliente(int id, Cliente cliente) throws Exception {
        Cliente clienteAux = null;
        try {
            clienteAux = buscarCliente(id);
            clienteAux.setCodigoCliente(cliente.getCodigoCliente());
            clienteAux.setNombreCliente(cliente.getNombreCliente());
            clienteAux.setCiudad(cliente.getCiudad());
            clienteAux.setApellidoContacto(cliente.getApellidoContacto());
            clienteAux.setCodigoPostal(cliente.getCodigoPostal());
            clienteAux.setFax(cliente.getFax());
            clienteAux.setLimiteCredito(cliente.getLimiteCredito());
            clienteAux.setNombreContacto(cliente.getNombreContacto());
            clienteAux.setPais(cliente.getPais());
            clienteAux.setRegion(cliente.getRegion());
            clienteAux.setTelefono(cliente.getTelefono());
            clienteAux.setEmpleado(cliente.getEmpleado());

            em.getTransaction().begin();
            cliente = em.merge(clienteAux);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return clienteAux;
    }

    public Cliente eliminarCliente(int id) throws Exception {
        Cliente cliente = null;
        try {
            cliente = buscarCliente(id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return cliente;
    }

    public List<Cliente> listarClientes() throws Exception {
        return em.createQuery("SELECT c FROM ClienteV2 c", Cliente.class).getResultList();
    }

    public List<Cliente> listarClientesPorNombre(String nombreABuscar) throws Exception {
        return em.createQuery("SELECT c FROM ClienteV2 c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
                .setParameter("nombre", "%" + nombreABuscar + "%").getResultList();
    }

    public List<Cliente> listarClientesPorCiudad(String ciudad) throws Exception {
        return em.createQuery("SELECT cli FROM ClienteV2 cli WHERE ciudad LIKE :ciudad", Cliente.class)
                .setParameter("ciudad", "%" + ciudad + "%").getResultList();
    }

    public List<Cliente> listarClientesPorEmpleado(int idEmpleado) throws Exception {
        return em.createQuery("SELECT cli FROM ClienteV2 cli WHERE id = :idEmpleado", Cliente.class)
                .setParameter("idEmpleado", idEmpleado).getResultList();
    }
}
