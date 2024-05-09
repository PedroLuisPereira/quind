package com.example.quind.domain.ports;

import com.example.quind.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaPortRepository {

    List<Cuenta> listar();

    Optional<Cuenta> listarByid(long id);

    List<Cuenta> listarByNumeroCuenta(String numeroCuenta);

    List<Cuenta> listarByClienteId(long clienteID);

    Cuenta guardar(Cuenta cuenta);

}

