package servicios;

import java.util.Objects;

// Clase padre
public class Servicio {
    private int idServicio;
    protected String nombre;
    protected boolean activo;

    // Constructor completo
    public Servicio(int idServicio, String nombre, boolean activo) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.activo = activo;
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

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Optimización de referencia
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return idServicio == servicio.idServicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio);
    }


    // Devuelve los datos principales del servicio en formato texto
    @Override
    public String toString() {
        return "Servicio: " + nombre + " (ID: " + idServicio + ") [" + (activo ? "Activo" : "Inactivo") + "]";
    }

}

