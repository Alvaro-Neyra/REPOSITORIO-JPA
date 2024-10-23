package org.example.CLASE_II_JPA.servicios;
import jakarta.persistence.EntityManager;
import org.example.CLASE_II_JPA.entidades.Empleado;
import org.example.CLASE_II_JPA.persistencia.EmpleadoDAO;

import java.util.List;

public class EmpleadoServicio {
    private EmpleadoDAO empleadoDAO;

    public EmpleadoServicio(EntityManager em) {
        empleadoDAO = new EmpleadoDAO(em);
    }

    public void guardarEmpleado(int codigoEmpleado, String nombre, String apellido, String extension, String email, int idJefe, String puesto) {
        try {
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setCodigoEmpleado(codigoEmpleado);
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setApellido(apellido);
            nuevoEmpleado.setExtension(extension);
            nuevoEmpleado.setEmail(email);
            nuevoEmpleado.setIdJefe(idJefe);
            nuevoEmpleado.setPuesto(puesto);
            verificarEmpleado(nuevoEmpleado);
            empleadoDAO.guardarEmpleado(nuevoEmpleado);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al guardar el empleado");
            e.printStackTrace();
        }
    }

    public Empleado buscarEmpleado(int id) {
        Empleado empleado = null;
        try {
            empleado = empleadoDAO.buscarEmpleado(id);
            if (empleado != null) {
                System.out.println("Empleado encontrado!: " + empleado.toString());
            } else {
                System.out.println("Empleado no encontrado!");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al buscar el empleado");
            e.printStackTrace();
        }
        return empleado;
    }

    public Empleado modificarEmpleado(int id, Empleado empleado) {
        Empleado empleadoAux = null;
        try {
            verificarEmpleado(empleado);
            empleadoAux = empleadoDAO.modificarEmpleado(id, empleado);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al modificar el empleado");
            e.printStackTrace();
        }
        return empleadoAux;
    }

    public Empleado eliminarEmpleado(int id) {
        Empleado empleado = null;
        try {
            empleado = empleadoDAO.eliminarEmpleado(id);
            if (empleado != null) {
                System.out.println("Empleado eliminado!: " + empleado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al eliminar el empleado");
            e.printStackTrace();
        }
        return empleado;
    }

    public void listarEmpleados() throws Exception{
        List<Empleado> empleadosListados = empleadoDAO.listarEmpleados();
        imprimirEmpleados(empleadosListados);
    }

    public void listarEmpleados(int oficinaId) throws Exception{
        List<Empleado> empleadosPorOficinaID = empleadoDAO.listarEmpleadosPorIdOficina(oficinaId);
        imprimirEmpleados(empleadosPorOficinaID);
    }

    public void imprimirEmpleados(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }

    public void listarJefes(int id) throws Exception{
        List<Empleado> jefes = empleadoDAO.listarJefes();
    }

    private void verificarEmpleado(Empleado empleado) throws Exception {
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo");
        }

        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }

        if (empleado.getApellido() == null || empleado.getApellido().isEmpty()) {
            throw new Exception("El apellido no puede ser nulo o vacío");
        }

        if (empleado.getEmail() == null || empleado.getEmail().isEmpty()) {
            throw new Exception("El email no puede ser nulo o vacío");
        }

        if (empleado.getExtension() == null || empleado.getExtension().isEmpty()) {
            throw new Exception("La extensión no puede ser nula o vacía");
        }

        if (empleado.getPuesto() == null || empleado.getPuesto().isEmpty()) {
            throw new Exception("El puesto no puede ser nulo o vacío");
        }

        if (empleado.getIdJefe() < 0) {
            throw new Exception("El ID del jefe no puede ser negativo");
        }

        if (empleado.getCodigoEmpleado() < 0) {
            throw new Exception("El código del empleado no puede ser negativo");
        }

        if (empleado.getOficina() == null) {
            throw new Exception("La oficina no puede ser nula");
        }
    }

}
