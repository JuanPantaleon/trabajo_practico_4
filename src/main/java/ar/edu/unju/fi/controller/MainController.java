package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MainController {
	
	@Autowired
    AlumnoCollection alumnoCollection;

    @Autowired
    DocenteCollection docenteCollection;

    @Autowired
    CarreraCollection carreraCollection;

    @Autowired
    MateriaCollection materiaCollection;
	
	
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
	
	@GetMapping("/registros")
	public String registros(Model model) {
		model.addAttribute("nuevoAlumno", new Alumno());
        model.addAttribute("nuevoDocente", new Docente());
        model.addAttribute("nuevaCarrera", new Carrera());
        model.addAttribute("nuevaMateria", new Materia());

        List<Alumno> alumnos = AlumnoCollection.listar();
        List<Docente> docentes = DocenteCollection.listar();
        List<Carrera> carreras = CarreraCollection.listar();
        List<Materia> materias = MateriaCollection.listar();

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("docentes", docentes);
        model.addAttribute("carreras", carreras);
        model.addAttribute("materias", materias);

        return "registros";
	}
	
	@GetMapping("/listados")
	public String listados(Model model) {
		List<Alumno> alumnos = AlumnoCollection.listar();
        List<Docente> docentes = DocenteCollection.listar();
        List<Carrera> carreras = CarreraCollection.listar();
        List<Materia> materias = MateriaCollection.listar();

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("docentes", docentes);
        model.addAttribute("carreras", carreras);
        model.addAttribute("materias", materias);

        return "listados";
    }
	
	
}
