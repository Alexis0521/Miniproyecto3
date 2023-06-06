/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package controlador;

import modelo.Recurso;
import datosDAO.RecursoDAO;
import java.util.List;

public class RecursoControlador {
    private RecursoDAO recursoDAO;

    public RecursoControlador() {
        this.recursoDAO = new RecursoDAO();
    }

    public void agregarRecurso(int cantidad, String nombre, String descripcion) {
        Recurso recurso = new Recurso(cantidad, nombre, descripcion);
        recursoDAO.agregarRecurso(recurso);
    }

    public void actualizarRecurso(int id, String nombre, String descripcion) {
        Recurso recurso = new Recurso(id, nombre, descripcion);
        recursoDAO.actualizarRecurso(recurso);
    }

    public void eliminarRecurso(int id) {
        recursoDAO.eliminarRecurso(id);
    }

    public Recurso obtenerRecurso(int id) {
        return recursoDAO.obtenerRecurso(id);
    }

    public List<Recurso> obtenerTodosLosRecursos() {
        return recursoDAO.obtenerTodosLosRecursos();
    }
}

