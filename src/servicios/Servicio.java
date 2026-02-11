package servicios;

import java.util.Objects;

public class Servicio {
    private int idServicio;;
    private String nombre;
    private double precioBase;
    private boolean activo;

    public Servicio(int idServicio, String nombre, double precioBase, boolean activo) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precioBase = precioBase;
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

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o|| getClass() != o.getClass()) return true;
        Servicio servicio = (Servicio) o;
        return idServicio == servicio.idServicio && Double.compare(precioBase, servicio.precioBase) == 0 && activo == servicio.activo && Objects.equals(nombre, servicio.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, nombre, precioBase, activo);
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", nombre='" + nombre + '\'' +
                ", precioBase=" + precioBase +
                ", activo=" + activo +
                '}';
    }
}