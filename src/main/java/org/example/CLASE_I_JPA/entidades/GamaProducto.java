package org.example.CLASE_I_JPA.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="GamaProductoV1")
@Table(name = "gama_producto")
public class GamaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idGama;


    @Column(name = "gama")
    private String gama;


    @Column(name = "descripcion_texto")
    private String descripcionTexto;


    @Column(name = "descripcion_html")
    private String descripcionHtml;


    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "gamaProducto")
    private List<Producto> productos;

    public GamaProducto(int idGama, String gama, String descripcionTexto, String descripcionHtml, String imagen) {
        this.idGama = idGama;
        this.gama = gama;
        this.descripcionTexto = descripcionTexto;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public GamaProducto(String gama,  String descripcionTexto, String descripcionHtml, String imagen) {
        this.gama = gama;
        this.descripcionTexto = descripcionTexto;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public GamaProducto() {
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "GamaProducto{" +
                "idGama=" + idGama +
                ", gama='" + gama + '\'' +
                ", descripcionTexto='" + descripcionTexto + '\'' +
                ", descripcionHtml='" + descripcionHtml + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamaProducto that = (GamaProducto) o;

        if (idGama != that.idGama) return false;
        if (!gama.equals(that.gama)) return false;
        if (!descripcionTexto.equals(that.descripcionTexto)) return false;
        if (!descripcionHtml.equals(that.descripcionHtml)) return false;
        return imagen.equals(that.imagen);
    }

    @Override
    public int hashCode() {
        int result = idGama;
        result = 31 * result + gama.hashCode();
        result = 31 * result + descripcionTexto.hashCode();
        result = 31 * result + descripcionHtml.hashCode();
        result = 31 * result + imagen.hashCode();
        return result;
    }
}