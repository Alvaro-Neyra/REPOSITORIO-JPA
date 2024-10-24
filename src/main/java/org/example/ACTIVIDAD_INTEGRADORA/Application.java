package org.example.ACTIVIDAD_INTEGRADORA;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.example.ACTIVIDAD_INTEGRADORA.entidades.Libro;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Autor;
import org.example.ACTIVIDAD_INTEGRADORA.entidades.Editorial;
import org.example.ACTIVIDAD_INTEGRADORA.servicios.EditorialServicio;
import org.example.ACTIVIDAD_INTEGRADORA.servicios.LibroServicio;
import org.example.ACTIVIDAD_INTEGRADORA.servicios.AutorServicio;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String dbPassword = dotenv.get("DB_PASSWORD");

        if (dbPassword == null) {
            throw new RuntimeException("DB_PASSWORD not found");
        }

        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/libreria?serverTimezone=UTC");
        properties.put("jakarta.persistence.jdbc.user", "root");
        properties.put("jakarta.persistence.jdbc.password", dbPassword);
        properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "true");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU", properties);
        EntityManager em = emf.createEntityManager();

        AutorServicio autorServicio = new AutorServicio(em);
        LibroServicio libroServicio = new LibroServicio(em);
        EditorialServicio editorialServicio = new EditorialServicio(em);

        try {
            em.getTransaction().begin();

            // Guardar y obtener el ID generado para Autor
            System.out.println("---- Prueba Servicio Autor ----");
            autorServicio.guardarAutor("Gabriel García Márquez", true);
            Autor autorGuardado = autorServicio.buscarAutor(11);  // Reemplaza con el ID generado si lo imprimes
            System.out.println("Autor guardado: " + autorGuardado.toString());
            autorServicio.modificarAutor(autorGuardado.getIdAutor(), new Autor("Gabriel Márquez", true));
            Autor autorModificado = autorServicio.buscarAutor(11);
            System.out.println("Autor modificado: " + autorModificado.toString());
            autorServicio.darBajaAutor(autorGuardado.getIdAutor());
            Autor autorDadoDeBaja = autorServicio.buscarAutor(11);
            System.out.println("Autor dado de baja: " + autorDadoDeBaja.toString());
            Autor autorEliminado = autorServicio.eliminarAutor(autorGuardado.getIdAutor());
            System.out.println("Autor eliminado: " + autorEliminado.toString());

            // Guardar y obtener el ID generado para Editorial
            System.out.println("---- Prueba Servicio Editorial ----");
            editorialServicio.guardarEditorial("Editorial Planeta", true);
            Editorial editorialGuardada = editorialServicio.buscarEditorial(11);  // Reemplaza con el ID generado si lo imprimes
            System.out.println("Editorial guardada: " + editorialGuardada.toString());
            editorialServicio.modificarEditorial(editorialGuardada.getId(), new Editorial("Editorial Random House", true));
            Editorial editorialModificada = editorialServicio.buscarEditorial(11);
            System.out.println("Editorial modificada: " + editorialModificada.toString());
            editorialServicio.darBajaEditorial(editorialModificada.getId());
            Editorial editorialDadoDeBaja = editorialServicio.buscarEditorial(11);
            System.out.println("Editorial dado de baja: " + editorialDadoDeBaja.toString());
            Editorial editorialEliminada = editorialServicio.eliminarEditorial(editorialGuardada.getId());
            System.out.println("Editorial eliminada: " + editorialEliminada.toString());

            // Guardar y obtener el ID generado para Libro
            System.out.println("---- Prueba Servicio Libro ----");
            libroServicio.guardarLibro(9781234567897L, "Cien años de soledad", 1967, 500, true);
            Libro libroGuardado = libroServicio.buscarLibro(11);  // Reemplaza con el ID generado si lo imprimes
            System.out.println("Libro guardado: " + libroGuardado.toString());
            libroServicio.modificarLibro(libroGuardado.getIdLibro(), new Libro(9781234567897L, "Cien años de soledad (Edición especial)", 1967, 600, true));
            Libro libroModificado = libroServicio.buscarLibro(libroGuardado.getIdLibro());
            System.out.println("Libro modificado: " + libroModificado.toString());
            libroServicio.darBajaLibro(libroGuardado.getIdLibro());
            Libro libroDadoDeBaja = libroServicio.buscarLibro(11);
            System.out.println("Libro dado de baja: " + libroDadoDeBaja.toString());
            Libro libroEliminado = libroServicio.eliminarLibro(libroGuardado.getIdLibro());
            System.out.println("Libro eliminado: " + libroEliminado.toString());

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

