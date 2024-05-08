package com.example.quind.domain.service;

import com.example.quind.domain.dto.CuentaSolicitud;
import com.example.quind.domain.exception.RegistroNotFoundException;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;

import java.util.Date;
import java.util.List;


public class CuentaService {

    private final ClientePortRepository clienteRepository;
    private final CuentaPortRepository cuentaRepository;

    public CuentaService(ClientePortRepository clienteRepository, CuentaPortRepository cuentaRepository) {
        this.clienteRepository = clienteRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> listar() {
        return cuentaRepository.listar();
    }

    public Cuenta listarById(long id) {
        return cuentaRepository.listarByid(id)
                .orElseThrow(() -> new RegistroNotFoundException("Cuenta no encontrado"));
    }

    public Cuenta crear(CuentaSolicitud cuentaSolicitud) {

        Cliente cliente = clienteRepository.listarByid(cuentaSolicitud.getClienteId())
                .orElseThrow(() -> new RegistroNotFoundException("Cliente no encontrado"));

        Cuenta cuenta = Cuenta.getInstance(
                0L,
                cuentaSolicitud.getTipoDeCuenta(),
                cuentaSolicitud.getNumeroDeCuenta(),
                cuentaSolicitud.getEstado(),
                cuentaSolicitud.getSaldo(),
                cuentaSolicitud.getExentaGMF(),
                new Date(),
                new Date(),
                cliente
        );

        return cuentaRepository.guardar(cuenta);
    }

}
