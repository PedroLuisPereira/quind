package com.example.quind.domain.validation;

import com.example.quind.domain.exception.CampoConException;

public class Validacion {

    private Validacion() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new CampoConException(mensaje);
        }
    }

    public static void validarMayorDeDosCaracteres(String valor, String mensaje) {
        if (valor.length() < 2) {
            throw new CampoConException(mensaje);
        }
    }

    public static void validarIntMayorQueCero(Long valor, String mensaje) {
        if (valor <= 0) {
            throw new CampoConException(mensaje);
        }
    }

    public static void validarMayorQueCero(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new CampoConException(mensaje);
        }
    }

    public static void validarSeaNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new CampoConException(mensaje);
        }
    }
}