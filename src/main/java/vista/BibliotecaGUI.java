/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Recurso;
import modelo.Prestamo;
import modelo.Usuario;
import controlador.RecursoControlador;
import controlador.UsuarioControlador;
import controlador.PrestamoControlador;
import java.util.ArrayList;

public class BibliotecaGUI extends JFrame {

    private UsuarioControlador usuarioControlador;
    private RecursoControlador recursoControlador;
    private PrestamoControlador prestamoControlador;
    private JPanel jpTitulo;

    private JLabel lblTitulo;
    private JButton btnAgregarUsuario;
    private JButton btnVerUsuarios;
    private JButton btnEliminarUsuario;
    private JButton btnActualizarUsuario;
    private JButton btnAgregarRecurso;
    private JButton btnVerRecursos;
    private JButton btnEliminarRecurso;
    private JButton btnActualizarRecurso;
    private JButton btnRealizarPrestamo;
    private JButton btnVerPrestamos;

    public BibliotecaGUI() {

        iniciarComponentes();
    }

    void iniciarComponentes() {
        usuarioControlador = new UsuarioControlador();
        recursoControlador = new RecursoControlador();
        prestamoControlador = new PrestamoControlador();

        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(519, 530);

   
        jpTitulo = new JPanel();
        jpTitulo.setBounds(0,0, 519,20);
        jpTitulo.setLayout(null);
        lblTitulo = new JLabel("SERVICIOS DE PRESTAMOS DE RECURSOS DE BIBLIOTECA", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("arial", Font.BOLD, 20));
        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnVerUsuarios = new JButton("Ver Usuarios");
        btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnActualizarUsuario = new JButton("Actualizar Usuario");
        btnAgregarRecurso = new JButton("Agregar Recurso");
        btnVerRecursos = new JButton("Ver Recursos");
        btnEliminarRecurso = new JButton("Eliminar Recurso");
        btnActualizarRecurso = new JButton("Actualizar Recurso");
        btnRealizarPrestamo = new JButton("Realizar Préstamo");
        btnVerPrestamos = new JButton("Ver Préstamos");

        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de usuario:");
                usuarioControlador.agregarUsuario(id, nombre, tipo);
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
            }
        });

        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Digite la identificación del usuario que quiere eliminar:");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                usuarioControlador.eliminarUsuario(id);
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            }

        });

        btnActualizarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Digite la identificacion del usuario que desea actualizar");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Usuario usuarioExistente = usuarioControlador.obtenerUsuario(id);
                if (usuarioExistente == null) {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró un usuario con la identificación proporcionada", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del usuario :");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo actualizado de usuario:");
                usuarioControlador.actualizarUsuario(id, nombre, tipo);
                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
            }
        });

        btnVerUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Usuario> usuarios = usuarioControlador.obtenerTodosUsuarios();
                StringBuilder sb = new StringBuilder();
                for (Usuario usuario : usuarios) {
                    sb.append("Identificacion: ").append(usuario.getId()).append("\n");
                    sb.append("Nombre: ").append(usuario.getNombre()).append("\n");
                    sb.append("Tipo: ").append(usuario.getTipo()).append("\n");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Usuarios", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnAgregarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("La identificacion de los recursos se añade automaticamente desde 1, marque cualquier numero para continuar");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del recurso:");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de recurso:");
                recursoControlador.agregarRecurso(id, nombre, tipo);
                JOptionPane.showMessageDialog(null, "Recurso agregado correctamente");
            }
        });

        btnVerRecursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Recurso> recursos = recursoControlador.obtenerTodosLosRecursos();
                StringBuilder sb = new StringBuilder();
                for (Recurso recurso : recursos) {
                    sb.append(recurso).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Recursos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnEliminarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Digite la identificación del recurso que quiere eliminar:");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                recursoControlador.eliminarRecurso(id);
                JOptionPane.showMessageDialog(null, "Recurso eliminado correctamente");
            }

        });

        btnActualizarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Digite la identificacion del usuario que desea actualizar");
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Recurso recursoExistente = recursoControlador.obtenerRecurso(id);
                if (recursoExistente == null) {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró un usuario con la identificación proporcionada", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre actualizado del recurso :");
                String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion actualizada del recurso:");
                recursoControlador.actualizarRecurso(id, nombre, descripcion);
                JOptionPane.showMessageDialog(null, "Recurso actualizado correctamente");
            }
        });

        btnRealizarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsuarioStr = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");
                int idUsuario;
                try {
                    idUsuario = Integer.parseInt(idUsuarioStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario usuarioExistente = usuarioControlador.obtenerUsuario(idUsuario);
                if (usuarioExistente == null) {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró un usuario con la identificación proporcionada", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String idRecursoStr = JOptionPane.showInputDialog("Ingrese la identificación del recurso:");
                int idRecurso;
                try {
                    idRecurso = Integer.parseInt(idRecursoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número de identificación válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Recurso recursoExistente = recursoControlador.obtenerRecurso(idRecurso);
                if (recursoExistente == null) {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró un usuario con la identificación proporcionada", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario usuario = usuarioControlador.obtenerUsuario(idUsuario);
                Recurso recurso = recursoControlador.obtenerRecurso(idRecurso);

                List<Recurso> recursosPrestamo = new ArrayList<>();
                recursosPrestamo.add(recurso);
                prestamoControlador.agregarPrestamo(usuario, recursosPrestamo);

            }
        });

        btnVerPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Prestamo> prestamos = prestamoControlador.obtenerTodosPrestamos();
                StringBuilder sb = new StringBuilder();
                for (Prestamo prestamo : prestamos) {
                    sb.append("Usuario: ").append(prestamo.getUsuario().getNombre()).append("\n");
                    sb.append("Recursos:\n");
                    for (Recurso recurso : prestamo.getRecursos()) {
                        sb.append("- ").append(recurso).append("\n");
                    }
                    sb.append("Fecha de registro: ").append(prestamo.getFechaRegistro()).append("\n");
                    sb.append("Fecha límite: ").append(prestamo.getFechaLimite()).append("\n");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Préstamos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(lblTitulo);
        add(jpTitulo);
        add(btnAgregarUsuario);
        add(btnVerUsuarios);
        add(btnEliminarUsuario);
        add(btnActualizarUsuario);
        add(btnAgregarRecurso);
        add(btnVerRecursos);
        add(btnEliminarRecurso);
        add(btnActualizarRecurso);
        add(btnRealizarPrestamo);
        add(btnVerPrestamos);

        pack();
        setVisible(true);
    }
}
