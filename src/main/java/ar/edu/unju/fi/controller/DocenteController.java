package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	@GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("docentes", DocenteCollection.listar());
        return "listados";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("docente", new Docente());
        return "registros";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("docente") Docente docente) {
        DocenteCollection.agregar(docente);
        return "redirect:/docentes/listar";
    }

    @GetMapping("/editar/{legajo}")
    public String editar(@PathVariable("legajo") String legajo, Model model) {
        Docente docente = DocenteCollection.buscar(legajo);
        model.addAttribute("docente", docente);
        return "registros";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("docente") Docente docente) {
        DocenteCollection.modificar(docente);
        return "redirect:/docentes/listar";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminar(@PathVariable("legajo") String legajo) {
        DocenteCollection.eliminar(legajo);
        return "redirect:/docentes/listar";
    }
}