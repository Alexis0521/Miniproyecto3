/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Prestamo;
import modelo.Recurso;
import modelo.Usuario;
import datosDAO.PrestamoDAO;

public class PrestamoControlador {

    private PrestamoDAO prestamoDAO;

    public PrestamoControlador() {
        prestamoDAO = new PrestamoDAO();
    }

    public void agregarPrestamo(Usuario usuario, List<Recurso> recursos) {
        Date fechaRegistro = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRegistro);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date fechaLimite = calendar.getTime();

        Prestamo prestamo = new Prestamo(usuario, recursos, fechaRegistro, fechaLimite);
        prestamoDAO.agregarPrestamo(prestamo);

        StringBuilder recursosPrestados = new StringBuilder();
        for (Recurso recurso : recursos) {
            recursosPrestados.append(recurso.getNombre()).append(", ");
        }
        recursosPrestados.deleteCharAt(recursosPrestados.length() - 2);

        JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente:\n"
                + "Usuario: " + usuario.getNombre() + "\n"
                + "Recursos: " + recursosPrestados.toString() + "\n"
                + "Fecha de registro: " + fechaRegistro.toString() + "\n"
                + "Fecha límite: " + fechaLimite.toString(), "Préstamo realizado", JOptionPane.INFORMATION_MESSAGE);
    }

   

    public Prestamo obtenerPrestamo(int id) {
        return prestamoDAO.obtenerPrestamo(id);
    }

  

    public List<Prestamo> obtenerTodosPrestamos() {
        return prestamoDAO.obtenerTodosPrestamos();
    }
}

