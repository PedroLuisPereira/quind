package com.example.quind.application.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;
    private String tipoDeIdentificacion;
    private String numeroDeIdentificacion;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private Date fechaDeNacimiento;

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", tipoDeIdentificacion='" + tipoDeIdentificacion + '\'' +
                ", numeroDeIdentificacion='" + numeroDeIdentificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                '}';
    }
}
