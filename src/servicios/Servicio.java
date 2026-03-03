package servicios;

import java.util.Objects;

// Clase padre
public class Servicio {
    private int idServicio;
    protected String nombre;
    protected boolean activo;
    protected String descripcion;


    // Constructor completo

    public Servicio(int idServicio, String nombre, boolean activo, String descripcion) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    // Constructor vacio
    public Servicio() {
    }


    // Getters y setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Equals y HashCode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return idServicio == servicio.idServicio && activo == servicio.activo && Objects.equals(nombre, servicio.nombre) && Objects.equals(descripcion, servicio.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, nombre, activo, descripcion);
    }

    // Devuelve los datos principales del servicio en formato texto
    @Override
    public String toString() {
        return "Servicio: " + nombre + " (ID: " + idServicio + ") [" + (activo ? "Activo" : "Inactivo") + "] | Descripción: " + descripcion;
    }

}
