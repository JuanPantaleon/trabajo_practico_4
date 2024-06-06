package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
@Service
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
        int index = alumnos.indexOf(buscar(alumno.getDni()));
        if (index >= 0) {
            alumnos.set(index, alumno);
        }
    }

    public static void eliminar(int dni) {
        alumnos.removeIf(a -> a.getDni() == dni);
    }
    
    
    
}