package org.example.ACTIVIDAD_INTEGRADORA.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity()
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Column(name = "alta")
    private Boolean alta;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    public Libro(Integer idLibro, Long isbn, String titulo, Integer anio, Integer ejemplares, Boolean alta) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Boolean alta) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
    }

    public Libro() {

    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
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
