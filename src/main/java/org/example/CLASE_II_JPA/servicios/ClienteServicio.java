package org.example.CLASE_II_JPA.servicios;

import jakarta.persistence.EntityManager;
import org.example.CLASE_II_JPA.persistencia.ClienteDAO;
import org.example.CLASE_II_JPA.entidades.Cliente;
import org.example.CLASE_II_JPA.entidades.Empleado;

import java.util.List;


public class ClienteServicio {
    private final ClienteDAO clienteDAO;
    public ClienteServicio(EntityManager em) {
        this.clienteDAO = new ClienteDAO(em);
    }

    public void guardarCliente(int codigoCliente, String nombreCliente, String nombreContacto,
                               String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
                               String codigoPostal, Empleado empleado, double limiteCredito) {
        try {
            Cliente cliente = new Cliente();
            cliente.setCodigoCliente(codigoCliente);
            cliente.setNombreCliente(nombreCliente);
            cliente.setNombreContacto(nombreContacto);
            cliente.setApellidoContacto(apellidoContacto);
            cliente.setTelefono(telefono);
            cliente.setFax(fax);
            cliente.setCiudad(ciudad);
            cliente.setRegion(region);
            cliente.setPais(pais);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setLimiteCredito(limiteCredito);
            cliente.setEmpleado(empleado);
            clienteDAO.guardarCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al guardar cliente!");
            e.printStackTrace();
        }
    }

    public Cliente buscarCliente(int id) {
        Cliente clienteBuscado = null;
        try {
            clienteBuscado = clienteDAO.buscarCliente(id);
            if (clienteBuscado != null) {
                System.out.println("Cliente encontrado!: " + clienteBuscado.toString());
            } else {
                System.out.println("Cliente no encontrado!");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " Error al buscar cliente!");
            e.printStackTrace();
        }
        return clienteBuscado;
    }

    public void listarClientes() throws Exception{
        List<Cliente> listaClientes = clienteDAO.listarClientes();
        imprimirListaClientes(listaClientes);
    }

    public void imprimirListaClientes(List<Cliente> clientes) {
        for(Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void listarClientes(String nombreRecibido) throws Exception{
        List<Cliente> listaClientes = clienteDAO.listarClientesPorNombre(nombreRecibido);
        imprimirListaClientes(listaClientes);
    }

    public void listarClientesPorCiudad(String ciudad) throws Exception {
        List<Cliente> listarClientesPorCiudad = clienteDAO.listarClientesPorCiudad(ciudad);
        imprimirListaClientes(listarClientesPorCiudad);
    }

    public void listarClientesPorEmpleado(int idEmpleado) throws Exception{
        List<Cliente> listarClientesPorEmpleado = clienteDAO.listarClientesPorEmpleado(idEmpleado);
        imprimirListaClientes(listarClientesPorEmpleado);
    }

    private void verificarCliente(Cliente cliente) throws Exception {
        if (cliente.getCodigoCliente() <= 0) {
            throw new Exception("El campo 'codigoCliente' debe ser un número positivo.");
        }

        if (cliente.getNombreCliente() == null || cliente.getNombreCliente().trim().isEmpty()) {
            throw new Exception("El campo 'nombreCliente' no puede ser nulo o vacío.");
        }

        if (cliente.getNombreContacto() == null || cliente.getNombreContacto().trim().isEmpty()) {
            throw new Exception("El campo 'nombreContacto' no puede ser nulo o vacío.");
        }

        if (cliente.getApellidoContacto() == null || cliente.getApellidoContacto().trim().isEmpty()) {
            throw new Exception("El campo 'apellidoContacto' no puede ser nulo o vacío.");
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            throw new Exception("El campo 'telefono' no puede ser nulo o vacío.");
        }

        if (cliente.getFax() == null || cliente.getFax().trim().isEmpty()) {
            throw new Exception("El campo 'fax' no puede ser nulo o vacío.");
        }

        if (cliente.getCiudad() == null || cliente.getCiudad().trim().isEmpty()) {
            throw new Exception("El campo 'ciudad' no puede ser nulo o vacío.");
        }

        if (cliente.getRegion() == null || cliente.getRegion().trim().isEmpty()) {
            throw new Exception("El campo 'region' no puede ser nulo o vacío.");
        }

        if (cliente.getPais()== null || cliente.getPais().trim().isEmpty()) {
            throw new Exception("El campo 'pais' no puede ser nulo o vacío.");
        }

        if (cliente.getCodigoPostal() == null || cliente.getCodigoPostal().trim().isEmpty()) {
            throw new Exception("El campo 'codigoPostal' no puede ser nulo o vacío.");
        }
    }
}
