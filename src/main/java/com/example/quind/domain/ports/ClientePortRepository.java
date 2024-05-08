package com.example.quind.domain.ports;

import com.example.quind.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientePortRepository {

    List<Cliente> listar();

    Optional<Cliente> listarByid(long id);

    Cliente crear(Cliente cliente);

    Cliente actualizar(Cliente cliente, long id);

    void eliminar(long id);

}

