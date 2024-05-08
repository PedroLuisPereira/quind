package com.example.quind.domain.model;


import com.example.quind.domain.exception.CampoConException;
import com.example.quind.domain.validation.Validacion;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Serializable {

    private Long id;
    private String tipoDeIdentificacion;
    private String numeroDeIdentificacion;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private Date fechaDeNacimiento;
    private Date fechaDeCreacion;
    private Date fechaDeModificacion;

    private Cliente(long id,
                    String tipoDeIdentificacion,
                    String numeroDeIdentificacion,
                    String nombres,
                    String apellidos,
                    String correoElectronico,
                    Date fechaDeNacimiento,
                    Date fechaDeCreacion,
                    Date fechaDeModificacion) {
        this.id = id;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public static Cliente getInstance(long id,
                                      String tipoDeIdentificacion,
                                      String numeroDeIdentificacion,
                                      String nombres,
                                      String apellidos,
                                      String correoElectronico,
                                      String fechaDeNacimiento,
                                      Date fechaDeCreacion,
                                      Date fechaDeModificacion) {

        Validacion.validarObligatorio(tipoDeIdentificacion, "El campo tipoDeIdentificacion es requerido");
        Validacion.validarObligatorio(numeroDeIdentificacion, "El campo numeroDeIdentificacion es requerido");
        Validacion.validarObligatorio(nombres, "El campo nombres es requerido");
        Validacion.validarObligatorio(apellidos, "El campo apellidos es requerido");
        Validacion.validarObligatorio(correoElectronico, "El campo correoElectronico es requerido");
        Validacion.validarObligatorio(fechaDeNacimiento, "El campo fechaDeNacimiento es requerido");
        Validacion.validarMayorDeDosCaracteres(nombres, "El campo nombres debe ser mayor de dos caracteres");
        Validacion.validarMayorDeDosCaracteres(apellidos, "El campo apellidos debe ser mayor de dos caracteres");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date nacimiento;
        try {
            nacimiento = dateFormat.parse(fechaDeNacimiento);
        } catch (ParseException e) {
            throw new CampoConException("Fecha no válida");
        }

        LocalDate localDate = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.plusYears(18);

        if (LocalDate.now().isBefore(localDate)) {
            throw new CampoConException("Cliente es menor de edad");
        }

        //Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = pattern.matcher(correoElectronico);

        if (!mather.find() ) {
            throw new CampoConException("Correo electrónico no es valido");
        }

        return new Cliente(
                id,
                tipoDeIdentificacion,
                numeroDeIdentificacion,
                nombres,
                apellidos,
                correoElectronico,
                nacimiento,
                fechaDeCreacion,
                fechaDeModificacion);
    }

    public Long getId() {
        return id;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }
}
