package com.example.quind.application.cuenta;


import com.example.quind.application.cuenta.dto.CuentaDto;
import com.example.quind.application.cuenta.dto.CuentaRespuestaDto;
import com.example.quind.domain.dto.CuentaSolicitud;
import com.example.quind.domain.model.Cuenta;


public class CuentaTransformador {

    private CuentaTransformador() {
    }

    public static CuentaSolicitud transformar(CuentaDto cuentaDto) {
        return new CuentaSolicitud(
                cuentaDto.getTipoDeCuenta(),
                cuentaDto.getSaldo(),
                cuentaDto.getExentaGMF(),
                cuentaDto.getClienteId()
        );
    }

//    public static CuentaDto transformar (ClienteSolicitud clienteSolicitud) {
//        return new CuentaDto(
//                clienteSolicitud.getId(),
//                clienteSolicitud.getTipoDeIdentificacion(),
//                clienteSolicitud.getNumeroDeIdentificacion(),
//                clienteSolicitud.getNombres(),
//                clienteSolicitud.getApellidos(),
//                clienteSolicitud.getCorreoElectronico(),
//                clienteSolicitud.getFechaDeNacimiento()
//        );
//    }

    public static CuentaRespuestaDto transformar(Cuenta cuenta) {
        return new CuentaRespuestaDto(
                cuenta.getId(),
                cuenta.getTipoDeCuenta(),
                cuenta.getNumeroDeCuenta(),
                cuenta.getEstado(),
                cuenta.getSaldo(),
                cuenta.getExentaGMF(),
                cuenta.getFechaDeCreacion(),
                cuenta.getFechaDeModificacion()
        );
    }
}
