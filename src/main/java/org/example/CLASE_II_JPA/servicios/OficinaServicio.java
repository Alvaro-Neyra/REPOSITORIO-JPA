package org.example.CLASE_II_JPA.servicios;

import java.util.List;

import jakarta.persistence.EntityManager;
import org.example.CLASE_II_JPA.entidades.Oficina;
import org.example.CLASE_II_JPA.persistencia.OficinaDAO;

public class OficinaServicio {
    private final OficinaDAO daoOficina;

    public OficinaServicio(EntityManager em) {
        this.daoOficina = new OficinaDAO(em);
    }

    public void guardarOficina(String codigodOficina, String ciudad, String pais,
                            String region, String telefono, String codigoPostal) {
        try {
            Oficina oficinaNueva = new Oficina();
            oficinaNueva.setCodigoOficina(codigodOficina);
            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigoPostal(codigoPostal);
            daoOficina.guardarOficina(oficinaNueva);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
            e.printStackTrace();
        }
    }

    public Oficina buscarOficina(int id){
        Oficina oficina = null;
        try {
            oficina = daoOficina.buscarOficina(id);
            if (oficina != null) {
                System.out.println("Oficina encontrada!: " + oficina.toString());
            } else {
                System.out.println("Oficina no encontrada!");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + "No se puede buscar oficina");
            e.printStackTrace();
        }
        return oficina;
    }

    public void listarOficinas() throws Exception {
        List<Oficina> todasOficinas = daoOficina.listarTodas();
        imprimirLista(todasOficinas);
    }

    public void imprimirLista(List<Oficina> oficinas) {
        for (Oficina oficina : oficinas) {
            System.out.println(oficina.toString());
        }
    }
    private void verificarOficina(Oficina oficina) throws Exception {
        if (oficina.getCodigoOficina() == null || oficina.getCodigoOficina().trim().isEmpty()) {
            throw new Exception("El campo 'codigoOficina' no puede ser nulo o vacío.");
        }

        if (oficina.getCiudad() == null || oficina.getCiudad().trim().isEmpty()) {
            throw new Exception("El campo 'ciudad' no puede ser nulo o vacío.");
        }

        if (oficina.getPais() == null || oficina.getPais().trim().isEmpty()) {
            throw new Exception("El campo 'pais' no puede ser nulo o vacío.");
        }

        if (oficina.getRegion() == null || oficina.getRegion().trim().isEmpty()) {
            throw new Exception("El campo 'region' no puede ser nulo o vacío.");
        }

        if (oficina.getCodigoPostal() == null || oficina.getCodigoPostal().trim().isEmpty()) {
            throw new Exception("El campo 'codigoPostal' no puede ser nulo o vacío.");
        }

        if (oficina.getTelefono() == null || oficina.getTelefono().trim().isEmpty()) {
            throw new Exception("El campo 'telefono' no puede ser nulo o vacío.");
        }
    }
}


