package com.ev3.c3.services;

import com.ev3.c3.models.Alumno;
import io.micrometer.common.util.StringUtils;
import org.hibernate.validator.constraintvalidators.*;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class AlumnoValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Alumno.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Alumno alumno = (Alumno) target;

        if (StringUtils.isBlank(alumno.getNombre())) {
            errors.rejectValue("nombre", "NotEmpty");
        }

        if (StringUtils.isBlank(alumno.getApellido_paterno())) {
            errors.rejectValue("apellido_paterno", "NotEmpty");
        }

        if (StringUtils.isBlank(alumno.getApellido_materno())) {
            errors.rejectValue("apellido_materno", "NotEmpty");
        }

        if (StringUtils.isBlank(alumno.getEmail())) {
            errors.rejectValue("email", "NotEmpty");
        } else if (new EmailValidator().isValid(alumno.getEmail(), null)) {
            errors.rejectValue("email", "Pattern");
        }
    }
}
