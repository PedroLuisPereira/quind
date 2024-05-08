package com.example.quind.domain.model;


import java.io.Serializable;
import java.util.Date;

public class Cuenta implements Serializable {

    private Long id;
    private String tipoDeCuenta;
    private String numeroDeCuenta;
    private String estado;
    private double saldo;
    private double exentaGMF;
    private Date fechaDeCreacion;
    private Date fechaDeModificacion;
    private Cliente cliente;

    private Cuenta(Long id, String tipoDeCuenta, String numeroDeCuenta, String estado, double saldo, double exentaGMF, Date fechaDeCreacion, Date fechaDeModificacion, Cliente cliente) {
        this.id = id;
        this.tipoDeCuenta = tipoDeCuenta;
        this.numeroDeCuenta = numeroDeCuenta;
        this.estado = estado;
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.cliente = cliente;
    }

    public static Cuenta getInstance(Long id, String tipoDeCuenta, String numeroDeCuenta, String estado, double saldo, double exentaGMF, Date fechaDeCreacion, Date fechaDeModificacion, Cliente cliente) {

        //todo validaciones

        return new Cuenta(
                id,
                tipoDeCuenta,
                numeroDeCuenta,
                estado,
                saldo,
                exentaGMF,
                fechaDeCreacion,
                fechaDeModificacion,
                cliente
        );
    }

    public Long getId() {
        return id;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getExentaGMF() {
        return exentaGMF;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
