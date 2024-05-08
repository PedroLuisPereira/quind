package com.example.quind.application.cuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaRespuestaDto {

    private Long id;
    private String tipoDeCuenta;
    private String numeroDeCuenta;
    private String estado;
    private double saldo;
    private double exentaGMF;
    private Date fechaDeCreacion;
    private Date fechaDeModificacion;


}
