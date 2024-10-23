package org.example.ACTIVIDAD_INTEGRADORA;

public class Validaciones {
    public static void validarCadenaVacia(String cadena, String mensajeError) {
        if (cadena == null || cadena.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    public static void validarNumeroVacio(Integer numero, String mensajeError) {
        if (numero == null || numero == 0) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    public static void validarBooleanVacio(Boolean valor, String mensajeError) {
        if (valor == null) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    public static void validarNumeroVacio(Long numero, String mensajeError) {
        if (numero == null || numero == 0) {
            throw new IllegalArgumentException(mensajeError);
        }
    }
}
