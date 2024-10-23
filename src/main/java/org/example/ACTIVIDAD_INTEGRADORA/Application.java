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
            Autor autorGuardado = autorServicio.buscarAutor(1);  // Reemplaza con el ID generado si lo imprimes
            if (autorGuardado != null) {
                System.out.println("ID del autor guardado: " + autorGuardado.getIdAutor());
                autorServicio.modificarAutor(autorGuardado.getIdAutor(), new Autor("Gabriel Márquez", true));
                autorServicio.darBajaAutor(autorGuardado.getIdAutor());
                autorServicio.eliminarAutor(autorGuardado.getIdAutor());
            }

            // Guardar y obtener el ID generado para Editorial
            System.out.println("---- Prueba Servicio Editorial ----");
            editorialServicio.guardarEditorial("Editorial Planeta", true);
            Editorial editorialGuardada = editorialServicio.buscarEditorial(1);  // Reemplaza con el ID generado si lo imprimes
            if (editorialGuardada != null) {
                System.out.println("ID de la editorial guardada: " + editorialGuardada.getId());
                editorialServicio.modificarEditorial(editorialGuardada.getId(), new Editorial("Editorial Random House", true));
                editorialServicio.darBajaEditorial(editorialGuardada.getId());
                editorialServicio.eliminarEditorial(editorialGuardada.getId());
            }

            // Guardar y obtener el ID generado para Libro
            System.out.println("---- Prueba Servicio Libro ----");
            libroServicio.guardarLibro(9781234567897L, "Cien años de soledad", 1967, 500, true);
            Libro libroGuardado = libroServicio.buscarLibro(1);  // Reemplaza con el ID generado si lo imprimes
            if (libroGuardado != null) {
                System.out.println("ID del libro guardado: " + libroGuardado.getIdLibro());
                libroServicio.modificarLibro(libroGuardado.getIdLibro(), new Libro(9781234567897L, "Cien años de soledad (Edición especial)", 1967, 600, true));
                libroServicio.darBajaLibro(libroGuardado.getIdLibro());
                libroServicio.eliminarLibro(libroGuardado.getIdLibro());
            }

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

