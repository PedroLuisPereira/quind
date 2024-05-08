package com.example.quind.domain.service;

import com.example.quind.domain.dto.CuentaSolicitud;
import com.example.quind.domain.exception.CampoConException;
import com.example.quind.domain.exception.RegistroNotFoundException;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;
import com.example.quind.domain.validation.Validacion;

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


        Validacion.validarObligatorio(cuentaSolicitud.getTipoDeCuenta(), "El campo tipoDeCuenta es requerido");
        if(!cuentaSolicitud.getTipoDeCuenta().equals("CUENTA_AHORRO") && !cuentaSolicitud.getTipoDeCuenta().equals("CUENTA_CORRIENTE")  ){
            throw new CampoConException("El campo tipoDeCuenta debe ser CUENTA_AHORRO o CUENTA_CORRIENTE");
        }

        String numeroCuenta = getNumeroCuenta(8);
        if(cuentaSolicitud.getTipoDeCuenta().equals("CUENTA_AHORRO")){
            numeroCuenta = "53" + numeroCuenta;
        }else{
            numeroCuenta = "33" + numeroCuenta;
        }

        if(cuentaSolicitud.getTipoDeCuenta().equals("CUENTA_AHORRO") && cuentaSolicitud.getSaldo() < 0 ){
            throw new CampoConException("El saldo de CUENTA_AHORRO no puede ser menor a 0");
        }

        Validacion.validarObligatorio(cuentaSolicitud.getExentaGMF(), "El campo exentaGMF es requerido");
        if(!cuentaSolicitud.getExentaGMF().equals("SI") && !cuentaSolicitud.getExentaGMF().equals("NO")  ){
            throw new CampoConException("El campo exentaGMF debe ser SI o NO");
        }


        Cuenta cuenta = Cuenta.getInstance(
                0L,
                cuentaSolicitud.getTipoDeCuenta(),
                numeroCuenta,
                "Activa",
                cuentaSolicitud.getSaldo(),
                cuentaSolicitud.getExentaGMF(),
                new Date(),
                new Date(),
                cliente
        );

        return cuentaRepository.guardar(cuenta);
    }

    private String getNumeroCuenta(int i) {
        String numeros = "0123456789";
        StringBuilder builder;

        // create the StringBuffer
        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {

            // generate numeric
            int myindex = (int) (numeros.length() * Math.random());

            // add the characters
            builder.append(numeros.charAt(myindex));
        }

        return builder.toString();
    }

}
