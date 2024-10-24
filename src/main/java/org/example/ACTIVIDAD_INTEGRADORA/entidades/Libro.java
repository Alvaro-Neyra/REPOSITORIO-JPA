package org.example.ACTIVIDAD_INTEGRADORA.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity()
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idLibro;

    @Column(name = "isbn")
    private long isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anio")
    private int anio;

    @Column(name = "ejemplares")
    private int ejemplares;

    @Column(name = "alta")
    private boolean alta;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    public Libro(int idLibro, long isbn, String titulo, int anio, int ejemplares, boolean alta) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
    }

    public Libro(long isbn, String titulo, int anio, int ejemplares, boolean alta) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
    }

    public Libro() {

    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", ejemplares=" + ejemplares +
                ", alta=" + alta +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro, isbn, titulo, anio, ejemplares, alta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(idLibro, libro.idLibro) &&
                Objects.equals(isbn, libro.isbn) &&
                Objects.equals(titulo, libro.titulo) &&
                Objects.equals(anio, libro.anio) &&
                Objects.equals(ejemplares, libro.ejemplares) &&
                Objects.equals(alta, libro.alta);
    }
}
