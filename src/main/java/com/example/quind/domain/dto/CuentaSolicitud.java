package com.example.quind.domain.dto;


public class CuentaSolicitud {

    private String tipoDeCuenta;
    private double saldo;
    private String exentaGMF;
    private Long clienteId;

    public CuentaSolicitud(String tipoDeCuenta, double saldo, String exentaGMF, Long clienteId) {

        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.clienteId = clienteId;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getExentaGMF() {
        return exentaGMF;
    }

    public void setExentaGMF(String exentaGMF) {
        this.exentaGMF = exentaGMF;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
