package com.example.quind.application.cuenta;


import com.example.quind.application.cuenta.dto.CuentaRespuestaDto;
import com.example.quind.domain.model.Cuenta;


public class CuentaTransformador {

    private CuentaTransformador() {
    }

//    public static CuentaSolicitud transformar(CuentaDto clienteDto) {
//        return new ClienteSolicitud(
//                clienteDto.getId(),
//                clienteDto.getTipoDeIdentificacion(),
//                clienteDto.getNumeroDeIdentificacion(),
//                clienteDto.getNombres(),
//                clienteDto.getApellidos(),
//                clienteDto.getCorreoElectronico(),
//                clienteDto.getFechaDeNacimiento()
//        );
//    }

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
