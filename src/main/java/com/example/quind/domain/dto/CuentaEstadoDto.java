package com.example.quind.domain.dto;


public class CuentaEstadoDto {

    private String numeroDeCuenta;
    private String estado;


    public CuentaEstadoDto(String numeroDeCuenta, String estado) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.estado = estado;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
