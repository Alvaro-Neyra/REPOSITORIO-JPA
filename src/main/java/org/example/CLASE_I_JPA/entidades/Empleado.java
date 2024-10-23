package org.example.CLASE_I_JPA.entidades;

import jakarta.persistence.*;


@Entity(name="EmpleadoV1")
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "codigo_empleado")
    private int codigoEmpleado;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "extension", length = 10)
    private String extension;

    @Column(name = "id_jefe")
    private int idJefe;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "jefe")
    private boolean jefe;

    @ManyToOne
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    public Empleado() {
    }

    public Empleado(int idEmpleado, int codigoEmpleado, String nombre, String apellido, String extension, String email, int idJefe, String puesto) {
        this.idEmpleado = idEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.extension = extension;
        this.email = email;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    public Empleado(int codigoEmpleado, String nombre, String apellido, String extension, String email, int idJefe, String puesto) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.extension = extension;
        this.email = email;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }


    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }


    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getExtension() {
        return extension;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getIdJefe() {
        return idJefe;
    }


    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }


    public String getPuesto() {
        return puesto;
    }


    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    public Oficina getOficina() {
        return oficina;
    }


    public void setOficina(Oficina oficina) {
        oficina = oficina;
    }

    @Override
    public String toString() {
        return "Empleado: " +
                "Id Empleado: " + idEmpleado +
                ", Codigo Empleado: " + codigoEmpleado +
                ", Nombre: " + nombre + "\n" +
                ", Apellido: " + apellido + "\n" +
                ", Extension: " + extension + "\n" +
                ", Email: " + email + "\n" +
                ", Jefe: " + idJefe + "\n" +
                ", Puesto: " + puesto + "\n" +
                ", Oficina: " + (oficina!= null ? oficina.getIdOficina() : "Sin oficina") + "\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idEmpleado;
        result = prime * result + codigoEmpleado;
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((extension == null) ? 0 : extension.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + idJefe;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((oficina == null) ? 0 : oficina.hashCode());
        result = prime * result + ((puesto == null) ? 0 : puesto.hashCode());
        result = prime * result + codigoEmpleado;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Empleado other = (Empleado) obj;
        if (idEmpleado != other.idEmpleado) return false;
        if (codigoEmpleado != other.codigoEmpleado) return false;
        if (apellido == null) {
            if (other.apellido != null) return false;
        }
        else if (!apellido.equals(other.apellido)) return false;
        if (extension == null) {
            if (other.extension != null) return false;
        }
        else if (!extension.equals(other.extension)) return false;
        if (email == null) {
            if (other.email != null) return false;
        }
        else if (!email.equals(other.email)) return false;
        if (idJefe!=other.idJefe) return false;
        if (nombre == null) {
            if (other.nombre != null) return false;
        }
        else if (!nombre.equals(other.nombre)) return false;
        if (oficina == null) {
            if (other.oficina != null) return false;
        }
        else if (!oficina.equals(other.getOficina())) return false;
        if (puesto == null) {
            if (other.puesto != null) return false;
        }
        else if (!puesto.equals(other.puesto)) return false;
        return true;
    }
}


