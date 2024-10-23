package org.example.CLASE_II_JPA.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="OficinaV2")
@Table(name = "oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column( name="id_oficina")
    private int idOficina;

    @Column (name="ciudad", length = 30)
    private String ciudad;

    @Column (name="codigo_oficina", length = 10)
    private String codigoOficina;

    @Column (name="pais", length = 50)
    private String pais;

    @Column (name="region", length = 50)
    private String region;

    @Column (name="codigo_postal", length = 10)
    private String codigoPostal;

    @Column (name="telefono", length = 20)
    private String telefono;

    @OneToMany(mappedBy = "oficina")
    private List<Empleado> empleados;

    public Oficina(int idOficina, String codigoOficina, String ciudad, String pais, String region, String codigoPostal, String telefono) {
        this.idOficina = idOficina;
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }
    public Oficina(String codigoOficina, String ciudad, String pais, String region, String codigoPostal, String telefono) {
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }
    public Oficina() {}

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Oficina{" +
                "idOficina=" + idOficina +
                ", codigoOficina='" + codigoOficina + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oficina oficina = (Oficina) o;

        if (idOficina != oficina.idOficina) return false;
        if (!codigoOficina.equals(oficina.codigoOficina)) return false;
        if (!ciudad.equals(oficina.ciudad)) return false;
        if (!pais.equals(oficina.pais)) return false;
        if (!region.equals(oficina.region)) return false;
        if (!codigoPostal.equals(oficina.codigoPostal)) return false;
        return telefono.equals(oficina.telefono);
    }

    @Override
    public int hashCode() {
        int result = idOficina;
        result = 31 * result + (codigoOficina != null ? codigoOficina.hashCode() : 0);
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        return result;
    }
}
