package com.ev3.c3.controller;

import com.ev3.c3.models.Alumno;
import com.ev3.c3.services.AlumnoService;
import com.ev3.c3.services.AlumnoValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService _service;
    private final AlumnoValidator _validator;

    public AlumnoController(AlumnoService service, AlumnoValidator validator) {
        _service = service;
        _validator = validator;
    }

    @GetMapping("/")
    public String Find(@ModelAttribute("alumno") Alumno alumno, Model model) {
        if (alumno  == null) {
            model.addAttribute("alumList", this._service.Find(
                    "",
                    "",
                    "",
                    "",
                    "", 0));
        } else {
            model.addAttribute("alumList", this._service.Find(
                    alumno.getCodigo_alumno() != null ? alumno.getCodigo_alumno() : "",
                    alumno.getNombre() != null ? alumno.getNombre() : "",
                    alumno.getApellido_paterno() != null ? alumno.getApellido_paterno() : "",
                    alumno.getApellido_materno() != null ? alumno.getApellido_materno() : "",
                    alumno.getEmail() != null ? alumno.getEmail() : "", alumno.getCiclo_actual()));
        }

        model.addAttribute("alumno", new Alumno());
        return "alumnos/index";
    }

    @GetMapping("/create")
    public String Create(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumnos/create";
    }

    @GetMapping("/edit/{id}")
    public String Edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("alumno", this._service.Find(id, "", "", "", "", 0).get(0));
        return "alumnos/edit";
    }

    @PostMapping("/edit") //deberia ser put
    public String Edit(Alumno alumno) {
        this._service.Crud('M', alumno.getCodigo_alumno(), alumno.getNombre(), alumno.getApellido_paterno(), alumno.getApellido_materno(), alumno.getEmail(), alumno.getCiclo_actual());
        return "redirect:/alumnos/";
    }

    @GetMapping("/del/{id}/{isConfirm}")
    public String Delete(@PathVariable("id") String id, @PathVariable("isConfirm") boolean isConfirm) {
        if (isConfirm)
            this._service.Crud('E', id,"", "", "", "", 0);
        return "redirect:/alumnos/";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("alumno") @Valid Alumno alumno, Errors errors) {
        this._validator.validate(alumno, errors);
        if(errors.hasErrors()) {
            return "alumnos/create";
        }
        String message = this._service.Crud('N', "", alumno.getNombre(), alumno.getApellido_paterno(), alumno.getApellido_materno(), alumno.getEmail(), alumno.getCiclo_actual());
        return "redirect:/alumnos/";
    }

}
