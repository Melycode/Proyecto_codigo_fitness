package servicios;

import java.util.Objects;

public class Cuota extends Servicio{
    private int duracionMeses;
    private double precioMensual;
    private String tipo;
    private boolean activo;

    public Cuota(int idServicio, String nombre, double precioBase, boolean activo, int duracionMeses, double precioMensual, String tipo, boolean activo1) {
        super(idServicio, nombre, precioBase, activo);
        this.duracionMeses = duracionMeses;
        this.precioMensual = precioMensual;
        this.tipo = tipo;
        this.activo = activo1;
    }

    public Cuota() {
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean isActivo() {
        return activo;
    }

    @Override
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cuota cuota = (Cuota) o;
        return duracionMeses == cuota.duracionMeses && Double.compare(precioMensual, cuota.precioMensual) == 0 && activo == cuota.activo && Objects.equals(tipo, cuota.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duracionMeses, precioMensual, tipo, activo);
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "duracionMeses=" + duracionMeses +
                ", precioMensual=" + precioMensual +
                ", tipo='" + tipo + '\'' +
                ", activo=" + activo +
                '}';
    }
}
