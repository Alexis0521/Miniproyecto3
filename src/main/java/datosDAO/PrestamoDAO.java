/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package datosDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Prestamo;
import modelo.Usuario;

public class PrestamoDAO {

    private List<Prestamo> prestamos;

    public PrestamoDAO() {
        prestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

  
    public List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario) {
        List<Prestamo> prestamosPorUsuario = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                prestamosPorUsuario.add(prestamo);
            }
        }
        return prestamosPorUsuario;
    }

    public List<Prestamo> obtenerPrestamosVencidos(Date fechaActual) {
        List<Prestamo> prestamosVencidos = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaLimite().before(fechaActual)) {
                prestamosVencidos.add(prestamo);
            }
        }
        return prestamosVencidos;
    }

    public Prestamo obtenerPrestamo(int id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public List<Prestamo> obtenerTodosPrestamos() {
        return prestamos;
    }
}
