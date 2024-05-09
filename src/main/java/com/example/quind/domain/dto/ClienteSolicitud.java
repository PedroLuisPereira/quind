package com.example.quind.domain.dto;


public class ClienteSolicitud {

    private final Long id;
    private final String tipoDeIdentificacion;
    private final String numeroDeIdentificacion;
    private final String nombres;
    private final String apellidos;
    private final String correoElectronico;
    private final String fechaDeNacimiento;

    public ClienteSolicitud(Long id, String tipoDeIdentificacion, String numeroDeIdentificacion, String nombres, String apellidos, String correoElectronico, String fechaDeNacimiento) {
        this.id = id;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.fechaDeNacimiento = fechaDeNacimiento;
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

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

}
