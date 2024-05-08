package com.example.quind.application.cuenta.dto;

import com.example.quind.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {

    private String tipoDeCuenta;
    private double saldo;
    private double exentaGMF;
    private long clienteId;

}
