package org.example.ACTIVIDAD_INTEGRADORA.entidades;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idAutor;
    @Column(name = "nombre")
    private String nombre;
    @Column (name = "alta")
    private boolean alta;

    @Column(name = "autores")
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor(int idAutor, String nombre, boolean alta) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor() {}

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
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
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor, nombre, alta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(idAutor, autor.idAutor) &&
                Objects.equals(nombre, autor.nombre) &&
                Objects.equals(alta, autor.alta);
    }
}
