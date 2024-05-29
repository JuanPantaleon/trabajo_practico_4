package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

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
        Docente existente = buscar(docente.getLegajo());
        if (existente != null) {
            int index = docentes.indexOf(existente);
            docentes.set(index, docente);
        }
    }

    public static void eliminar(String legajo) {
        Docente docente = buscar(legajo);
        if (docente != null) {
            docentes.remove(docente);
        }
    }
}
