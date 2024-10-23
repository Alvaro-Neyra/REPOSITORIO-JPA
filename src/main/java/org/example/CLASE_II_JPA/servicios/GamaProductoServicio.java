package org.example.CLASE_II_JPA.servicios;

import jakarta.persistence.EntityManager;
import org.example.CLASE_II_JPA.entidades.GamaProducto;
import org.example.CLASE_II_JPA.persistencia.GamaProductoDAO;

import java.util.List;

public class GamaProductoServicio {
    private GamaProductoDAO gamaProductoDAO;
    public GamaProductoServicio(EntityManager em) {
        gamaProductoDAO = new GamaProductoDAO(em);
    }

    public void guardarGamaProducto(String gama,  String descripcionTexto, String descripcionHtml, String imagen) {
        try {
            GamaProducto gamaProducto = new GamaProducto();
            gamaProducto.setGama(gama);
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setImagen(imagen);
            gamaProductoDAO.guardarGamaProducto(gamaProducto);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al agregar un gama producto!");
            e.printStackTrace();
        }
    }

    public GamaProducto buscarGamaProducto(int id){
        GamaProducto gamaProducto = null;
        try {
            gamaProducto = gamaProductoDAO.buscarGamaProducto(id);
            if (gamaProducto != null) {
                System.out.println("Gama Producto no encontrado!!: " + gamaProducto.toString());
            } else {
                System.out.println("Gama Producto no encontrado!!");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al buscar un gama producto!");
            e.printStackTrace();
        }
        return gamaProducto;
    }

    public GamaProducto modificarGamaProducto(int id, GamaProducto gamaProducto) {
        GamaProducto gamaProductoAux = null;
        try {
            verificarGamaProducto(gamaProducto);
            gamaProductoAux = gamaProductoDAO.modificarGamaProducto(id, gamaProducto);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al modificar un gama producto!");
            e.printStackTrace();
        }
        return gamaProductoAux;
    }

    public GamaProducto eliminarGamaProducto(int id) {
        GamaProducto gamaProductoAux = null;
        try {
            gamaProductoAux = gamaProductoDAO.eliminarGamaProducto(id);
        } catch (Exception e) {
            System.out.println(e.toString() + "Error al eliminar un gama producto!");
            e.printStackTrace();
        }
        return gamaProductoAux;
    }

    public void listarGamaProductos() throws Exception{
        List<GamaProducto> listaGamaProductos = gamaProductoDAO.listarGamaProductos();
        imprimirGamaProductos(listaGamaProductos);
    }

    public void imprimirGamaProductos(List<GamaProducto> gamaProductos) {
        for (GamaProducto gamaProducto: gamaProductos) {
            System.out.println(gamaProducto.toString());
        }
    }

    private void verificarGamaProducto(GamaProducto gamaProducto) throws Exception {
        if (gamaProducto == null) {
            throw new Exception("El objeto GamaProducto no puede ser nulo.");
        }

        if (gamaProducto.getGama() == null || gamaProducto.getGama().trim().isEmpty()) {
            throw new Exception("El campo 'gama' no puede ser nulo o vacío.");
        }

        if (gamaProducto.getDescripcionTexto() == null || gamaProducto.getDescripcionTexto().trim().isEmpty()) {
            throw new Exception("El campo 'descripcionTexto' no puede ser nulo o vacío.");
        }

        if (gamaProducto.getDescripcionHtml() == null || gamaProducto.getDescripcionHtml().trim().isEmpty()) {
            throw new Exception("El campo 'descripcionHtml' no puede ser nulo o vacío.");
        }

        if (gamaProducto.getImagen() == null || gamaProducto.getImagen().trim().isEmpty()) {
            throw new Exception("El campo 'imagen' no puede ser nulo o vacío.");
        }
    }
}
