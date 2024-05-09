package com.example.quind.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.quind.domain.dto.ClienteSolicitud;
import com.example.quind.domain.dto.CuentaEstadoDto;
import com.example.quind.domain.dto.CuentaSolicitud;
import com.example.quind.domain.dto.OperacionSolicitud;
import com.example.quind.domain.model.Cliente;
import com.example.quind.domain.model.Cuenta;
import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.ports.CuentaPortRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    private ClientePortRepository clienteRepository;

    @Mock
    private CuentaPortRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    private static final String ACTIVA = "Activa";
    private static final String CUENTA_AHORRO = "CUENTA_AHORRO";
    private static final String CUENTA_CORRIENTE = "CUENTA_CORRIENTE";
    private static final String CUENTA_NO_ENCONTRADA = "Cuenta no encontrada";

    private Cliente cliente;
    private Cuenta cuenta;
    private CuentaSolicitud cuentaSolicitud;
    private Date fechaNacimiento;

    @BeforeEach
    public void setup() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechaNacimiento = sdf.parse("2000-05-01");

        cliente = Cliente.getInstance(1,
                "CC",
                "123456789",
                "Luis David",
                "Diaz Ruiz",
                "luis@gmail.com",
                fechaNacimiento,
                new Date(),
                new Date());

        cuenta = Cuenta.getInstance(1L,
                CUENTA_AHORRO,
                "12346789",
                ACTIVA,
                50000,
                "SI",
                new Date(),
                new Date(), cliente);

        cuentaSolicitud = new CuentaSolicitud(CUENTA_AHORRO, 50000, "SI", 1L);
    }

    @Test
    void listar() {

        // given
        when(cuentaRepository.listar()).thenReturn((List.of(cuenta, cuenta)));

        // when - action or the behaviour that we are going test
        List<Cuenta> cuentas = cuentaService.listar();

        // then - verify the output
        Assertions.assertNotNull(cuentas);
        Assertions.assertEquals(2, cuentas.size());
    }

    @Test
    void listarByNumeroCuenta() {

        // given
        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuenta));

        // when - action or the behaviour that we are going test
        Cuenta cuenta = cuentaService.listarByNumeroCuenta("12346789");

        // then - verify the output
        Assertions.assertNotNull(cuenta);
        Assertions.assertEquals(50000, cuenta.getSaldo());
    }

    @Test
    void crear() {
        // given - precondition or setup
        Mockito.when(clienteRepository.listarByid(1L)).thenReturn(Optional.of(cliente));
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuenta);

        // when - action or the behaviour that we are going test
        Cuenta cuentaCrear = cuentaService.crear(cuentaSolicitud);

        // then - verify the output
        Assertions.assertNotNull(cuentaCrear);
        Assertions.assertEquals(50000, cuentaCrear.getSaldo());
        Assertions.assertEquals("luis@gmail.com", cuentaCrear.getCliente().getCorreoElectronico());
    }

    @Test
    void modificarEstado() {
        // given - precondition or setup
        Cuenta cuenta2 = Cuenta.getInstance(1L,
                CUENTA_AHORRO,
                "12346789",
                "Inactiva",
                50000,
                "SI",
                new Date(),
                new Date(), cliente);

        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuenta));
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuenta2);

        // when - action or the behaviour that we are going test
        Cuenta cuentaEstado = cuentaService.modificarEstado(new CuentaEstadoDto("123456789", "Inactiva"));

        // then - verify the output
        Assertions.assertNotNull(cuentaEstado);
        Assertions.assertEquals(50000, cuentaEstado.getSaldo());
        Assertions.assertEquals("Inactiva", cuentaEstado.getEstado());
        Assertions.assertEquals("luis@gmail.com", cuentaEstado.getCliente().getCorreoElectronico());
    }

    @Test
    void consignacion() {
        // given - precondition or setup
        Cuenta cuenta2 = Cuenta.getInstance(1L,
                CUENTA_AHORRO,
                "12346789",
                "Activa",
                100000,
                "SI",
                new Date(),
                new Date(),
                cliente);

        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuenta));
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuenta2);

        // when - action or the behaviour that we are going test
        Cuenta cuentaUpdate = cuentaService.consignacion(new OperacionSolicitud(null, "123456789", 50000));

        // then - verify the output
        Assertions.assertNotNull(cuentaUpdate);
        Assertions.assertEquals(100000, cuentaUpdate.getSaldo());
        Assertions.assertEquals("Activa", cuentaUpdate.getEstado());
        Assertions.assertEquals("luis@gmail.com", cuentaUpdate.getCliente().getCorreoElectronico());
    }

    @Test
    void transferencia() {
        // given - precondition or setup
        Cuenta cuentaOrigenUpdate = Cuenta.getInstance(1L,
                CUENTA_AHORRO,
                "5312345678",
                ACTIVA,
                0,
                "SI",
                new Date(),
                new Date(), cliente);

        Cuenta cuentaDestino = Cuenta.getInstance(2L,
                CUENTA_AHORRO,
                "5387654321",
                "Activa",
                100000,
                "SI",
                new Date(),
                new Date(),
                cliente);

        Cuenta cuentaDestinoUpdate = Cuenta.getInstance(2L,
                CUENTA_AHORRO,
                "5387654321",
                "Activa",
                150000,
                "SI",
                new Date(),
                new Date(),
                cliente);

        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuenta));
        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuentaDestino));
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuentaDestinoUpdate);
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuentaOrigenUpdate);

        // when - action or the behaviour that we are going test
        Cuenta cuentaUpdate = cuentaService.transferencia(new OperacionSolicitud("5312345678", "5387654321", 50000));

        // then - verify the output
        Assertions.assertNotNull(cuentaUpdate);
        Assertions.assertEquals(0, cuentaUpdate.getSaldo());
        Assertions.assertEquals("Activa", cuentaUpdate.getEstado());
        Assertions.assertEquals("luis@gmail.com", cuentaUpdate.getCliente().getCorreoElectronico());
    }

    @Test
    void retiro() {
        // given - precondition or setup
        Cuenta cuentaOrigenUpdate = Cuenta.getInstance(1L,
                CUENTA_AHORRO,
                "5312345678",
                ACTIVA,
                0,
                "SI",
                new Date(),
                new Date(), cliente);

        Mockito.when(cuentaRepository.listarByNumeroCuenta(anyString())).thenReturn(List.of(cuenta));
        Mockito.when(cuentaRepository.guardar(any())).thenReturn(cuentaOrigenUpdate);

        // when - action or the behaviour that we are going test
        Cuenta cuentaUpdate = cuentaService.retiro(new OperacionSolicitud("5312345678", null, 50000));

        // then - verify the output
        Assertions.assertNotNull(cuentaUpdate);
        Assertions.assertEquals(0, cuentaUpdate.getSaldo());
        Assertions.assertEquals("Activa", cuentaUpdate.getEstado());
        Assertions.assertEquals("luis@gmail.com", cuentaUpdate.getCliente().getCorreoElectronico());
    }
}