/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * Orlando Alexis Rengifo Mejia(2223878)
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package modelo;

import java.util.Date;
import java.util.List;

public class Prestamo {

    private int id;
    private Usuario usuario;
    private List<Recurso> recursos;
    private Date fechaRegistro;
    private Date fechaLimite;

    public Prestamo(Usuario usuario, List<Recurso> recursos, Date fechaRegistro, Date fechaLimite) {
        this.id = id;
        this.usuario = usuario;
        this.recursos = recursos;
        this.fechaRegistro = fechaRegistro;
        this.fechaLimite = fechaLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
