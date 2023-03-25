package com.ev3.c3.interfaces;

import com.ev3.c3.models.Alumno;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, String> {

    @Procedure(name = "SP_VIEW_ALUMNOS")
    List<Alumno> Find(
            @Param("Id") String codigo,
            @Param("nom") String nombre,
            @Param("paterno") String paterno,
            @Param("materno") String materno,
            @Param("correo") String email,
            @Param("Ciclo") int ciclo
    );

    @Procedure(name = "SP_ALUMNOS")
    String Crud(
            @Param("Opc") char option,
            @Param("Id") String id,
            @Param("Nombre") String nombre,
            @Param("apellido_paterno") String paterno,
            @Param("apellido_materno") String materno,
            @Param("Email") String email,
            @Param("CicloActual") int ciclo
    );


}
