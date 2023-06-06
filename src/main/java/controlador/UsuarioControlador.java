/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package controlador;

import java.util.List;
import modelo.Usuario;
import datosDAO.UsuarioDAO;

public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;

    public UsuarioControlador() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void agregarUsuario(int id, String nombre, String tipo) {
        Usuario usuario = new Usuario(id, nombre, tipo);
        usuarioDAO.agregarUsuario(usuario);
    }

    public void actualizarUsuario(int id, String nombre, String tipo) {
        Usuario usuario = usuarioDAO.obtenerUsuario(id);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setTipo(tipo);
            usuarioDAO.actualizarUsuario(usuario);
        }
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }

    public boolean existeUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id) != null;
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioDAO.obtenerTodosUsuarios();
    }

}

