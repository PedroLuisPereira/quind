package com.example.quind.infrastructure.output.persistence;

import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;
import com.example.quind.infrastructure.output.persistence.entity.ClienteEntity;
import com.example.quind.infrastructure.output.persistence.entity.CuentaEntity;
import com.example.quind.infrastructure.output.persistence.mapper.ClienteMapper;
import com.example.quind.infrastructure.output.persistence.mapper.CuentaMapper;
import com.example.quind.infrastructure.output.persistence.repository.ClienteRepository;
import com.example.quind.infrastructure.output.persistence.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CuentaPersistenceAdapter implements CuentaPortRepository {

    private final CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> listar() {
        return cuentaRepository.findAll().stream()
                .map(CuentaMapper::toCuenta)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cuenta> listarByid(long id) {
        return cuentaRepository.findById(id).map(CuentaMapper::toCuenta);
    }

    @Override
    public Cuenta guardar(Cuenta cuenta) {
        return CuentaMapper.toCuenta(cuentaRepository.save(CuentaMapper.toEntity(cuenta)));
    }

    @Override
    public void eliminar(long id) {
        cuentaRepository.deleteById(id);
    }

}