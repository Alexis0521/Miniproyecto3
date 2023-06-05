/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package datosDAO;

import modelo.Recurso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursoDAO {
    private Map<Integer, Recurso> recursos;

    public RecursoDAO() {
        this.recursos = new HashMap<>();
    }

    public void agregarRecurso(Recurso recurso) {
        int nuevoId = obtenerNuevoId();
        recurso.setId(nuevoId);
        recursos.put(nuevoId, recurso);
    }

    public void actualizarRecurso(Recurso recurso) {
        if (recursos.containsKey(recurso.getId())) {
            recursos.put(recurso.getId(), recurso);
        }
    }

    public void eliminarRecurso(int id) {
        recursos.remove(id);
    }

    public Recurso obtenerRecurso(int id) {
        return recursos.get(id);
    }

    public List<Recurso> obtenerTodosLosRecursos() {
        return new ArrayList<>(recursos.values());
    }

    private int obtenerNuevoId() {
        int maxId = 0;
        for (Recurso recurso : recursos.values()) {
            if (recurso.getId() > maxId) {
                maxId = recurso.getId();
            }
        }
        return maxId + 1;
    }
}

