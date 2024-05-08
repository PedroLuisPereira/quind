package com.example.quind.domain.dto;


public class OperacionSolicitud {

    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private double valor;

    public OperacionSolicitud(String numeroCuentaOrigen, String numeroCuentaDestino, double valor) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.valor = valor;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
