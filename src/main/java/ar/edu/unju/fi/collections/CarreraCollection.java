package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
@Component
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
        int index = carreras.indexOf(buscar(carrera.getCodigo()));
        if (index >= 0) {
            carreras.set(index, carrera);
        }
    }

    public static void eliminar(String codigo) {
        carreras.removeIf(c -> c.getCodigo() == codigo);
    }
    
   
}
