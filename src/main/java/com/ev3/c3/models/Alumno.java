package com.ev3.c3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Table(name = "alumno")
@Entity(name = "alumno")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SP_ALUMNOS",
                procedureName = "SP_ALUMNOS",
                parameters = {
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Opc", type=Character.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Id", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Nombre", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="apellido_paterno", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="apellido_materno", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Email", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="CicloActual", type= Integer.class),
                        @StoredProcedureParameter(mode=ParameterMode.OUT, name="Msj", type=String.class),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "SP_VIEW_ALUMNOS",
                procedureName = "SP_VIEW_ALUMNOS",
                parameters = {
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Id", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="nom", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="paterno", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="materno", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="correo", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="Ciclo", type = Integer.class),
                },
                resultClasses = Alumno.class
        )
})
public class Alumno implements Serializable {

    @Id
    @Column(name = "codigo_alumno")
    private String codigo_alumno;

    @NotBlank
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @NotBlank
    @Basic(optional = false)
    @Column(name = "apellido_materno")
    private String apellido_materno;

    @NotBlank
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "ciclo_actual")
    private int ciclo_actual;

    public Alumno() {
    }

    public String getCodigo_alumno() {
        return codigo_alumno;
    }

    public void setCodigo_alumno(String codigo_alumno) {
        this.codigo_alumno = codigo_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCiclo_actual() {
        return ciclo_actual;
    }

    public void setCiclo_actual(int ciclo_actual) {
        this.ciclo_actual = ciclo_actual;
    }
}
