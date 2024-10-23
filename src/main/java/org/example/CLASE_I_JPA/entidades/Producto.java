package org.example.CLASE_I_JPA.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="ProductoV1")
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad_en_stock")
    private int cantidadEnStock;

    @Column(name = "precio_venta")
    private int precioVenta;

    @Column(name = "precio_proveedor")
    private int precioProveedor;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallesPedido;

    public Producto(int idProducto, String codigoProducto, String nombre, GamaProducto gamaProducto, String dimensiones, String proveedor, String descripcion, int cantidadEnStock, int precioVenta, int precioProveedor) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.gamaProducto = gamaProducto;
        this.dimensiones = dimensiones;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public Producto(String codigoProducto, String nombre, GamaProducto gamaProducto, String dimensiones, String proveedor, String descripcion, int cantidadEnStock, int precioVenta, int precioProveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.gamaProducto = gamaProducto;
        this.dimensiones = dimensiones;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(int precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }

    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombre + '\'' +
                ", idGamaProducto=" + gamaProducto.getIdGama() +
                ", dimensiones='" + dimensiones + '\'' +
                ", precioProveedor=" + precioProveedor +
                ", precioVenta=" + precioVenta +
                ", stock=" + cantidadEnStock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Producto producto = (Producto) obj;

        return idProducto == producto.idProducto &&
                gamaProducto.getIdGama() == producto.getGamaProducto().getIdGama() &&
                cantidadEnStock == producto.cantidadEnStock &&
                Double.compare(producto.precioVenta, precioVenta) == 0 &&
                Double.compare(producto.precioProveedor, precioProveedor) == 0 &&
                codigoProducto.equals(producto.codigoProducto) &&
                nombre.equals(producto.nombre) &&
                dimensiones.equals(producto.dimensiones) &&
                proveedor.equals(producto.proveedor) &&
                descripcion.equals(producto.descripcion);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(idProducto);
        result = 31 * result + codigoProducto.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + Integer.hashCode(gamaProducto.getIdGama());
        result = 31 * result + dimensiones.hashCode();
        result = 31 * result + proveedor.hashCode();
        result = 31 * result + descripcion.hashCode();
        result = 31 * result + Integer.hashCode(cantidadEnStock);
        long precioVentaBits = Double.doubleToLongBits(precioVenta);
        result = 31 * result + Long.hashCode(precioVentaBits);
        long precioProveedorBits = Double.doubleToLongBits(precioProveedor);
        result = 31 * result + Long.hashCode(precioProveedorBits);
        return result;
    }

}