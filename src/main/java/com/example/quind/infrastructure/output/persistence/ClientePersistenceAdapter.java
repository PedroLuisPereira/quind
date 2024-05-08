package com.example.quind.infrastructure.output.persistence;

import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.infrastructure.output.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ClientePersistenceAdapter implements ClientePortRepository {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return List.of();
    }

    @Override
    public Optional<Cliente> listarByid(long id) {
        return Optional.empty();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente actualizar(Cliente cliente, long id) {
        return null;
    }

    @Override
    public void eliminar(long id) {

    }
}