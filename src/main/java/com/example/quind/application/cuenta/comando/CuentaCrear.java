package com.example.quind.application.cuenta.comando;

import com.example.quind.application.cliente.ClienteTransformador;
import com.example.quind.application.cliente.dto.ClienteDto;
import com.example.quind.application.cliente.dto.ClienteRespuestaDto;
import com.example.quind.application.cuenta.CuentaTransformador;
import com.example.quind.application.cuenta.dto.CuentaDto;
import com.example.quind.application.cuenta.dto.CuentaRespuestaDto;
import com.example.quind.domain.dto.ClienteSolicitud;
import com.example.quind.domain.dto.CuentaSolicitud;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.service.ClienteService;
import com.example.quind.domain.service.CuentaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CuentaCrear {

    private final CuentaService cuentaService;

    public CuentaCrear(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @Transactional
    public CuentaRespuestaDto ejecutar(CuentaDto cuentaDto) {
        CuentaSolicitud cuentaSolicitud = CuentaTransformador.transformar(cuentaDto);

        Cuenta cuenta = cuentaService.crear(cuentaSolicitud);

        return CuentaTransformador.transformar(cuenta);
    }
}
