package org.example.CLASE_II_JPA;

import java.util.Map;
import java.util.HashMap;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.CLASE_II_JPA.entidades.Cliente;
import org.example.CLASE_II_JPA.entidades.GamaProducto;
import org.example.CLASE_II_JPA.entidades.Oficina;
import org.example.CLASE_II_JPA.servicios.ClienteServicio;
import org.example.CLASE_II_JPA.servicios.GamaProductoServicio;
import org.example.CLASE_II_JPA.servicios.OficinaServicio;
import org.example.CLASE_II_JPA.entidades.Empleado;
import org.example.CLASE_II_JPA.servicios.EmpleadoServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String dbPassword = dotenv.get("DB_PASSWORD");

        if (dbPassword == null) {
            throw new RuntimeException("DB_PASSWORD not found");
        }

        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/vivero-jpa?serverTimezone=UTC");
        properties.put("jakarta.persistence.jdbc.user", "root");
        properties.put("jakarta.persistence.jdbc.password", dbPassword);
        properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "true");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU", properties);
        EntityManager em = emf.createEntityManager();

        OficinaServicio oficina = new OficinaServicio(em);
        GamaProductoServicio gama = new GamaProductoServicio(em);
        ClienteServicio cliente = new ClienteServicio(em);
        EmpleadoServicio empleado = new EmpleadoServicio(em);

        oficina.guardarOficina("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111",
                "CP5000");
        gama.guardarGamaProducto("Electrónica", "Descripción en texto", "<p>Descripción en HTML</p>", "imagen.jpg");
        cliente.guardarCliente(1001, "Cliente Ejemplo", "Juan", "Pérez", "123456789", "987654321",
                "Buenos Aires", "Capital Federal", "Argentina", "C1000",
                new Empleado(), 50000.0);

        System.out.println("Usando buscar entidades!!: ");
        Oficina oficinaEncontrada = oficina.buscarOficina(1);
        if (oficinaEncontrada != null) {
            System.out.println(oficinaEncontrada.toString());
        }
        Cliente clienteEncontrada = cliente.buscarCliente(6);
        if (clienteEncontrada != null) {
            System.out.println(clienteEncontrada.toString());
        }
        GamaProducto gamaProductoEncontrada = gama.buscarGamaProducto(1);
        if (gamaProductoEncontrada != null) {
            System.out.println(gamaProductoEncontrada.toString());
        }
        System.out.println("Modificando los productos: ");
        GamaProducto nuevaGamaProducto = new GamaProducto("Nueva gama", "Descripción en texto", "Descripción en HTML", "imagen.jpg");
        GamaProducto gamaProductoModificado = gama.modificarGamaProducto(1, nuevaGamaProducto);
        if (gamaProductoModificado != null) {
            System.out.println(gamaProductoModificado.toString());
        }

        try {
            System.out.println("Lista clientes: ");
            cliente.listarClientes();
            System.out.println("Lista de oficinas: ");
            oficina.listarOficinas();
            System.out.println("Lista de gamas: ");
            gama.listarGamaProductos();
            System.out.println("Lista de clientes por nombre: ");
            cliente.listarClientes("Victoria");
            System.out.println("Lista de empleados por idOficina: ");
            empleado.listarEmpleados(14);
            System.out.println("Listar clientes por ciudad: ");
            cliente.listarClientesPorCiudad("Madrid");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error al lista oficinas");
            e.printStackTrace();
        }
    }
}
