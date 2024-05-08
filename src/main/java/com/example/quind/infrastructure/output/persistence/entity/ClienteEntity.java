package com.example.quind.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "clientes")
@ToString
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_de_identificacion")
    private String tipoDeIdentificacion;

    @Column(name = "numero_de_identificacion")
    private String numeroDeIdentificacion;

    private String nombres;

    private String apellidos;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @Column(name = "fecha_de_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;

    @Column(name = "fecha_de_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeModificacion;


}