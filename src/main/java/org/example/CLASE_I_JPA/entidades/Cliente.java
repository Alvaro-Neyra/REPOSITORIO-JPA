package org.example.CLASE_I_JPA.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="ClienteV1")
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "codigo_cliente")
    private int codigoCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "apellido_contacto")
    private String apellidoContacto;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fax")
    private String fax;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String pais;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "limite_credito")
    private double limiteCredito;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<Pago> pagos;

    public Cliente(int idCliente, int codigoCliente, String nombreCliente, String nombreContacto,
                   String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
                   String codigoPostal, Empleado empleado, double limiteCredito) {
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.empleado = empleado;
        this.limiteCredito = limiteCredito;
    }

    public Cliente(int codigoCliente, String nombreCliente, String nombreContacto,
                   String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
                   String codigoPostal, Empleado empleado, double limiteCredito) {
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.empleado = empleado;
        this.limiteCredito = limiteCredito;
    }

    public Cliente() {
    }

    // Getters y Setters corregidos
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idCliente != cliente.idCliente) return false;
        if (codigoCliente != cliente.codigoCliente) return false;
        if (Double.compare(cliente.limiteCredito, limiteCredito) != 0) return false;
        if (!nombreCliente.equals(cliente.nombreCliente)) return false;
        if (!nombreContacto.equals(cliente.nombreContacto)) return false;
        if (!apellidoContacto.equals(cliente.apellidoContacto)) return false;
        if (!telefono.equals(cliente.telefono)) return false;
        if (!fax.equals(cliente.fax)) return false;
        if (!ciudad.equals(cliente.ciudad)) return false;
        if (!region.equals(cliente.region)) return false;
        if (!pais.equals(cliente.pais)) return false;
        if (!codigoPostal.equals(cliente.codigoPostal)) return false;
        return empleado != null ? empleado.equals(cliente.empleado) : cliente.empleado == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idCliente;
        result = 31 * result + codigoCliente;
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (nombreContacto != null ? nombreContacto.hashCode() : 0);
        result = 31 * result + (apellidoContacto != null ? apellidoContacto.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        result = 31 * result + (empleado != null ? empleado.hashCode() : 0);
        temp = Double.doubleToLongBits(limiteCredito);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", codigoCliente=" + codigoCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", apellidoContacto='" + apellidoContacto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fax='" + fax + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", region='" + region + '\'' +
                ", pais='" + pais + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", empleado=" + empleado +
                ", limiteCredito=" + limiteCredito +
                '}';
    }
}
