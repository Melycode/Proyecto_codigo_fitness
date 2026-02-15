package servicios;

import java.util.Objects;

public class Servicio {
    private int idServicio;
    private String nombre;
    private boolean activo;

    public Servicio(int idServicio, String nombre, boolean activo) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Servicio() {
    }


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

    @Override
    public String toString() {
        return "Servicio: " + nombre + " (ID: " + idServicio + ") [" + (activo ? "Activo" : "Inactivo") + "]";
    }
}
