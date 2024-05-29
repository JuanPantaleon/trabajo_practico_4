package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
	@GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("carreras", CarreraCollection.listar());
        return "listados";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "registros";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("carrera") Carrera carrera) {
        CarreraCollection.agregar(carrera);
        return "redirect:/carreras/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable("codigo") String codigo, Model model) {
        Carrera carrera = CarreraCollection.buscar(codigo);
        model.addAttribute("carrera", carrera);
        return "registros";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("carrera") Carrera carrera) {
        CarreraCollection.modificar(carrera);
        return "redirect:/carreras/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") String codigo) {
        CarreraCollection.eliminar(codigo);
        return "redirect:/carreras/listar";
    }
 }