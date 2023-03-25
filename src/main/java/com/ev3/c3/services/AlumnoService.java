package com.ev3.c3.services;

import com.ev3.c3.interfaces.IAlumnoRepository;
import com.ev3.c3.models.Alumno;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AlumnoService {
    private final IAlumnoRepository _repository;

    public AlumnoService(IAlumnoRepository repository) {
        _repository = repository;
    }

    public List<Alumno> Find(String codigo, String nombre, String paterno, String materno, String email, int ciclo) {
        return this._repository.Find(codigo, nombre, paterno, materno, email, ciclo);
    }

    public String Crud(char option, String id, String nombre, String paterno, String materno, String email, int ciclo) {
        return this._repository.Crud(option, id, nombre, paterno, materno, email, ciclo);
    }
}
