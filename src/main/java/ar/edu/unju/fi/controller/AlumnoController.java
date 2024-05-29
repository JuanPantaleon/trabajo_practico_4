package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")

public class AlumnoController {
	@Autowired
    private AlumnoCollection alumnoCollection;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alumnos", alumnoCollection.listar());
        return "listados";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "registros";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("alumno") Alumno alumno) {
        alumnoCollection.agregar(alumno);
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/editar/{dni}")
    public String editar(@PathVariable("dni") int dni, Model model) {
        Alumno alumno = alumnoCollection.buscar(dni);
        model.addAttribute("alumno", alumno);
        return "registros";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("alumno") Alumno alumno) {
        alumnoCollection.modificar(alumno);
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminar(@PathVariable("dni") int dni) {
        alumnoCollection.eliminar(dni);
        return "redirect:/alumnos/listar";
    }
}