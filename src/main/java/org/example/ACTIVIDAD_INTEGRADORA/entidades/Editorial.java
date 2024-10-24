package org.example.ACTIVIDAD_INTEGRADORA.entidades;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "alta")
    private boolean alta;

    @Column(name = "libros")
    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial(int id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Editorial(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Editorial() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, alta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editorial editorial = (Editorial) o;
        return Objects.equals(id, editorial.id) &&
                Objects.equals(nombre, editorial.nombre) &&
                Objects.equals(alta, editorial.alta);
    }
}
