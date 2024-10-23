package org.example.CLASE_I_JPA.entidades;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name="PagoV1")
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pago")
    private int idPago;

    @Column(name="forma_pago")
    private String formaPago;

    @Column(name = "id_transaccion")
    private String idTransaccion;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_pago")
    private Date fechaPago;

    @Column(name="total")
    private double total;

    @ManyToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Pago(int idPago, String formaPago, Date fechaPago, double total, Cliente cliente) {
        this.idPago = idPago;
        this.formaPago = formaPago;
        this.fechaPago = fechaPago;
        this.total = total;
        this.cliente = cliente;
    }

    public Pago(String formaPago, Date fechaPago, double total, Cliente cliente) {
        this.formaPago = formaPago;
        this.fechaPago = fechaPago;
        this.total = total;
        this.cliente = cliente;
    }

    public Pago() {

    }

    // Getters y setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", formaPago='" + formaPago + '\'' +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", fechaPago=" + fechaPago +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pago pago = (Pago) o;

        if (idPago != pago.idPago) return false;
        if (Double.compare(pago.total, total) != 0) return false;
        if (!formaPago.equals(pago.formaPago)) return false;
        if (!idTransaccion.equals(pago.idTransaccion)) return false;
        if (!fechaPago.equals(pago.fechaPago)) return false;
        return cliente.equals(pago.cliente);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPago;
        result = 31 * result + formaPago.hashCode();
        result = 31 * result + idTransaccion.hashCode();
        result = 31 * result + fechaPago.hashCode();
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cliente.hashCode();
        return result;
    }
}