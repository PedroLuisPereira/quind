package com.example.quind.domain.service;

import com.example.quind.domain.dto.ClienteSolicitud;
import com.example.quind.domain.exception.CampoConException;
import com.example.quind.domain.exception.RegistroNotFoundException;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date nacimiento;
        try {
            nacimiento = dateFormat.parse(clienteSolicitud.getFechaDeNacimiento());
        } catch (ParseException e) {
            throw new CampoConException("El campo fechaDeNacimiento no es valido, debe ser yyyy-mm-dd");
        }

        Cliente clienteCrear = Cliente.getInstance(
                0,
                clienteSolicitud.getTipoDeIdentificacion(),
                clienteSolicitud.getNumeroDeIdentificacion(),
                clienteSolicitud.getNombres(),
                clienteSolicitud.getApellidos(),
                clienteSolicitud.getCorreoElectronico(),
                nacimiento,
                new Date(),
                new Date()
        );

        if(!clienteSolicitud.getTipoDeIdentificacion().equals("CC") && !clienteSolicitud.getTipoDeIdentificacion().equals("CE") ){
            throw new CampoConException("El campo tipoDeIdentificacion no es valido, debe ser CC o CE");
        }

        LocalDate localDate = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.plusYears(18);

        if (LocalDate.now().isBefore(localDate)) {
            throw new CampoConException("Cliente es menor de edad");
        }

        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = pattern.matcher(clienteSolicitud.getCorreoElectronico());

        if (!mather.find() ) {
            throw new CampoConException("Correo electrónico no es valido");
        }

        return clienteRepository.guardar(clienteCrear);
    }

    public Cliente actualizar(long id, ClienteSolicitud clienteSolicitud) {

        Cliente clienteActual = clienteRepository.listarByid(id)
                .orElseThrow(() -> new RegistroNotFoundException("Cliente no encontrado"));

//        Cliente cliente = Cliente.getInstance(
//                id,
//                clienteSolicitud.getTipoDeIdentificacion(),
//                clienteSolicitud.getNumeroDeIdentificacion(),
//                clienteSolicitud.getNombres(),
//                clienteSolicitud.getApellidos(),
//                clienteSolicitud.getCorreoElectronico(),
//                clienteSolicitud.getFechaDeNacimiento(),
//                clienteActual.getFechaDeCreacion(),
//                new Date()
//        );
//
//        return clienteRepository.guardar(cliente);

        return null;
    }

    public void eliminar(long id) {

        List<Cuenta> lineas = cuentaPortRepository.listarByClienteId(id);
        if (!lineas.isEmpty()) {
            throw new CampoConException("No se puede eliminar cliente debido a que tiene productos asociados");
        }

        clienteRepository.eliminar(id);
    }
}
