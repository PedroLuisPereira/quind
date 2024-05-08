package com.example.quind.domain.service;

import com.example.quind.domain.dto.ClienteSolicitud;
import com.example.quind.domain.exception.CampoConException;
import com.example.quind.domain.exception.RegistroNotFoundException;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;


import java.util.Date;
import java.util.List;


public class ClienteService {

    private final ClientePortRepository clienteRepository;
    private final CuentaPortRepository cuentaPortRepository;

    public ClienteService(ClientePortRepository clienteRepository, CuentaPortRepository cuentaPortRepository) {
        this.clienteRepository = clienteRepository;
        this.cuentaPortRepository = cuentaPortRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.listar();
    }

    public Cliente listarByid(long id) {
        return clienteRepository.listarByid(id)
                .orElseThrow(() -> new RegistroNotFoundException("Cliente no encontrado"));
    }

    public Cliente crear(ClienteSolicitud clienteSolicitud) {

        Cliente clienteCrear = Cliente.getInstance(
                0,
                clienteSolicitud.getTipoDeIdentificacion(),
                clienteSolicitud.getNumeroDeIdentificacion(),
                clienteSolicitud.getNombres(),
                clienteSolicitud.getApellidos(),
                clienteSolicitud.getCorreoElectronico(),
                clienteSolicitud.getFechaDeNacimiento(),
                new Date(),
                new Date()
        );

        return clienteRepository.guardar(clienteCrear);
    }

    public Cliente actualizar(long id, ClienteSolicitud clienteSolicitud) {

        Cliente clienteActual = clienteRepository.listarByid(id)
                .orElseThrow(() -> new RegistroNotFoundException("Cliente no encontrado"));

        Cliente cliente = Cliente.getInstance(
                id,
                clienteSolicitud.getTipoDeIdentificacion(),
                clienteSolicitud.getNumeroDeIdentificacion(),
                clienteSolicitud.getNombres(),
                clienteSolicitud.getApellidos(),
                clienteSolicitud.getCorreoElectronico(),
                clienteSolicitud.getFechaDeNacimiento(),
                clienteActual.getFechaDeCreacion(),
                new Date()
        );

        return clienteRepository.guardar(cliente);
    }

    public void eliminar(long id) {

        List<Cuenta> lineas = cuentaPortRepository.listarByClienteId(id);
        if (!lineas.isEmpty()) {
            throw new CampoConException("No se puede eliminar cliente debido a que tiene productos asociados");
        }

        clienteRepository.eliminar(id);
    }
}
