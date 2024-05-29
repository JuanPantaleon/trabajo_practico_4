package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("materias", MateriaCollection.listar());
        return "listados";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("materia", new Materia());
        model.addAttribute("docentes", DocenteCollection.listar());
        model.addAttribute("carreras", CarreraCollection.listar());
        return "registros";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("materia") Materia materia) {
        MateriaCollection.agregar(materia);
        return "redirect:/materias/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable("codigo") String codigo, Model model) {
        Materia materia = MateriaCollection.buscar(codigo);
        model.addAttribute("materia", materia);
        model.addAttribute("docentes", DocenteCollection.listar());
        model.addAttribute("carreras", CarreraCollection.listar());
        return "registros";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("materia") Materia materia) {
        MateriaCollection.modificar(materia);
        return "redirect:/materias/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") String codigo) {
        MateriaCollection.eliminar(codigo);
        return "redirect:/materias/listar";
    }
}