package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;
@Component
public class DocenteCollection {
	private static List<Docente> docentes = new ArrayList<>();

    public static List<Docente> listar() {
        return docentes;
    }

    public static void agregar(Docente docente) {
        docentes.add(docente);
    }

    public static Docente buscar(String legajo) {
        return docentes.stream().filter(d -> d.getLegajo() == legajo).findFirst().orElse(null);
    }

    public static void modificar(Docente docente) {
        int index = docentes.indexOf(buscar(docente.getLegajo()));
        if (index >= 0) {
            docentes.set(index, docente);
        }
    }

    public static void eliminar(String legajo) {
        docentes.removeIf(d -> d.getLegajo() == legajo);
    }
    
    
}
