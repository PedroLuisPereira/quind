package com.example.quind.infrastructure.output.persistence;

import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.infrastructure.output.persistence.entity.ClienteEntity;
import com.example.quind.infrastructure.output.persistence.mapper.ClienteMapper;
import com.example.quind.infrastructure.output.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClientePersistenceAdapter implements ClientePortRepository {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        List<ClienteEntity> personas = clienteRepository.findAll();

        return personas.stream()
                .map(ClienteMapper::toCliente)
                .collect(Collectors.toList());
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