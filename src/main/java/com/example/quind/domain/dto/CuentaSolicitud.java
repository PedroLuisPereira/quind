package com.example.quind.domain.dto;


public class CuentaSolicitud {

    private final String tipoDeCuenta;
    private final double saldo;
    private final String exentaGMF;
    private final Long clienteId;

    public CuentaSolicitud(String tipoDeCuenta, double saldo, String exentaGMF, Long clienteId) {
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.clienteId = clienteId;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }


    public double getSaldo() {
        return saldo;
    }

    public String getExentaGMF() {
        return exentaGMF;
    }

    public Long getClienteId() {
        return clienteId;
    }
}
