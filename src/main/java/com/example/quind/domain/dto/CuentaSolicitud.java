package com.example.quind.domain.dto;

import java.util.Date;

public class CuentaSolicitud {

    private Long id;
    private String tipoDeCuenta;
    private String numeroDeCuenta;
    private String estado;
    private double saldo;
    private double exentaGMF;
    private Date fechaDeCreacion;
    private Date fechaDeModificacion;
    private Long clienteId;

    public CuentaSolicitud(Long id, String tipoDeCuenta, String numeroDeCuenta, String estado, double saldo, double exentaGMF, Date fechaDeCreacion, Date fechaDeModificacion, Long clienteId) {
        this.id = id;
        this.tipoDeCuenta = tipoDeCuenta;
        this.numeroDeCuenta = numeroDeCuenta;
        this.estado = estado;
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getExentaGMF() {
        return exentaGMF;
    }

    public void setExentaGMF(double exentaGMF) {
        this.exentaGMF = exentaGMF;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(Date fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
