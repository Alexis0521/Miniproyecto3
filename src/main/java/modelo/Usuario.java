/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package modelo;

public class Usuario {

    private int id;
    private String nombre;
    private String tipo;
    // Otros atributos y métodos

    public Usuario(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Otros getters y setters para los demás atributos
    
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }
}
