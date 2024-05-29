package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class CarreraCollection {
	private static List<Carrera> carreras = new ArrayList<>();

    public static List<Carrera> listar() {
        return carreras;
    }

    public static void agregar(Carrera carrera) {
        carreras.add(carrera);
    }

    public static Carrera buscar(String codigo) {
        return carreras.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static void modificar(Carrera carrera) {
        Carrera existente = buscar(carrera.getCodigo());
        if (existente != null) {
            int index = carreras.indexOf(existente);
            carreras.set(index, carrera);
        }
    }

    public static void eliminar(String codigo) {
        Carrera carrera = buscar(codigo);
        if (carrera != null) {
            carreras.remove(carrera);
        }
    }
}
