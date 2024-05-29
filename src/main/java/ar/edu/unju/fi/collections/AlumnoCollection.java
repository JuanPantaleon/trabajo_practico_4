package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoCollection {
	private static List<Alumno> alumnos = new ArrayList<>();

    public static List<Alumno> listar() {
        return alumnos;
    }

    public static void agregar(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static Alumno buscar(int dni) {
        return alumnos.stream().filter(a -> a.getDni() == dni).findFirst().orElse(null);
    }

    public static void modificar(Alumno alumno) {
        Alumno existente = buscar(alumno.getDni());
        if (existente != null) {
            int index = alumnos.indexOf(existente);
            alumnos.set(index, alumno);
        }
    }

    public static void eliminar(int dni) {
        Alumno alumno = buscar(dni);
        if (alumno != null) {
            alumnos.remove(alumno);
        }
    }
}