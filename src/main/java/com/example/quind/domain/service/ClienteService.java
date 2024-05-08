package com.example.quind.domain.service;

import com.example.quind.domain.dto.ClienteSolicitud;
import com.example.quind.domain.exception.RegistroNotFoundException;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.ports.ClientePortRepository;


import java.util.Date;
import java.util.List;


public class ClienteService {

    private final ClientePortRepository clienteRepository;

    public ClienteService(ClientePortRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
        //todo validaciones

        clienteRepository.eliminar(id);
    }
}
