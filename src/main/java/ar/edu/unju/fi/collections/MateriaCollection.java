package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class MateriaCollection {
	private static List<Materia> materias = new ArrayList<>();

    public static List<Materia> listar() {
        return materias;
    }

    public static void agregar(Materia materia) {
        materias.add(materia);
    }

    public static Materia buscar(String codigo) {
        return materias.stream().filter(m -> m.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static void modificar(Materia materia) {
        Materia existente = buscar(materia.getCodigo());
        if (existente != null) {
            int index = materias.indexOf(existente);
            materias.set(index, materia);
        }
    }

    public static void eliminar(String codigo) {
        Materia materia = buscar(codigo);
        if (materia != null) {
            materias.remove(materia);
        }
    }
}

