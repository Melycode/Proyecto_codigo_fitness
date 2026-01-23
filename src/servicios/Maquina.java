package servicios;

import java.util.Objects;

public class Maquina extends Servicio {
    public enum EstadoMaquina { OPERATIVA, AVERIADA, MANTENIMIENTO }
    private String nombreMaquina;
    private EstadoMaquina estado;
    private double horasUso;
    private boolean mantenimiento;


    public Maquina(int idServicio, String nombre, double precioBase, boolean activo, String nombreMaquina, EstadoMaquina estado, double horasUso, boolean mantenimiento) {
        super(idServicio, nombre, precioBase, activo);
        this.nombreMaquina = nombreMaquina;
        this.estado = estado;
        this.horasUso = horasUso;
        this.mantenimiento = mantenimiento;
    }

    public Maquina(String nombreMaquina, EstadoMaquina estado, double horasUso, boolean mantenimiento) {
        this.nombreMaquina = nombreMaquina;
        this.estado = estado;
        this.horasUso = horasUso;
        this.mantenimiento = mantenimiento;
    }

    public Maquina() {
        super(); // llama al constructor vacío de Servicio
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public double getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(double horasUso) {
        this.horasUso = horasUso;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Maquina maquina = (Maquina) o;
        return Double.compare(horasUso, maquina.horasUso) == 0 && mantenimiento == maquina.mantenimiento && Objects.equals(nombreMaquina, maquina.nombreMaquina) && estado == maquina.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombreMaquina, estado, horasUso, mantenimiento);
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "idServicio=" + getIdServicio() +
                ", nombre='" + getNombre() + '\'' +
                ", precioBase=" + getPrecioBase() +
                ", activo=" + isActivo() +
                ", nombreMaquina='" + nombreMaquina + '\'' +
                ", estado=" + estado +
                ", horasUso=" + horasUso +
                ", mantenimiento=" + mantenimiento +
                '}';
    }

}
