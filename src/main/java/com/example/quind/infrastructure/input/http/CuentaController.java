package com.example.quind.infrastructure.input.http;


import com.example.quind.application.cuenta.comando.CuentaConsignar;
import com.example.quind.application.cuenta.comando.CuentaCrear;
import com.example.quind.application.cuenta.consulta.CuentaListar;
import com.example.quind.application.cuenta.dto.CuentaDto;
import com.example.quind.application.cuenta.dto.CuentaRespuestaDto;
import com.example.quind.application.cuenta.dto.OperacionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {

    private final CuentaCrear cuentaCrear;
    private final CuentaConsignar cuentaConsignar;
    //private final ClienteActualizar clienteActualizar;
    //private final ClienteEliminar clienteEliminar;
    private final CuentaListar cuentaListar;
    //private final ClienteListarPorId clienteListarPorId;


    public CuentaController(
            CuentaCrear cuentaCrear,
            CuentaConsignar cuentaConsignar,
            //ClienteActualizar clienteActualizar,
            //ClienteEliminar clienteEliminar,
            CuentaListar cuentaListar
            //ClienteListarPorId clienteListarPorId
    ) {
        this.cuentaCrear = cuentaCrear;
        this.cuentaConsignar = cuentaConsignar;
        //this.clienteActualizar = clienteActualizar;
        //this.clienteEliminar = clienteEliminar;
        this.cuentaListar = cuentaListar;
        //this.clienteListarPorId = clienteListarPorId;
    }

    @GetMapping("")
    public List<CuentaRespuestaDto> list() {
        return cuentaListar.ejecutar();
    }

//    @GetMapping("/{id}")
//    public ClienteRespuestaDto listByid(@PathVariable(value = "id") Long id) {
//        return clienteListarPorId.ejecutar(id);
//    }

//    @GetMapping("/numeroCuenta/{numeroCuenta}")
//    public ClienteRespuestaDto listByid(@PathVariable(value = "numeroCuenta") String numeroCuenta) {
//        return clienteListarPorId.ejecutar(id);
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CuentaRespuestaDto create(@RequestBody CuentaDto cuentaDto) {
        return cuentaCrear.ejecutar(cuentaDto);
    }

    @PostMapping("/operacion/consignar")
    public CuentaRespuestaDto consignacion(@RequestBody OperacionDto operacionDto) {
        return cuentaConsignar.ejecutar(operacionDto);
    }


}
