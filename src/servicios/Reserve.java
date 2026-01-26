package servicios;

import personas.Cliente;

import java.util.Objects;

public class Reserve extends Servicio{
    private Cliente cliente;
    private Gimcurso gimcurso;
    private String fecha;
    private boolean confirmada;

    public Reserve(int idServicio, String nombre, double precioBase, boolean activo, Cliente cliente, Gimcurso gimcurso, String fecha, boolean confirmada) {
        super(idServicio, nombre, precioBase, activo);
        this.cliente = cliente;
        this.gimcurso = gimcurso;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    public Reserve() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Gimcurso getGimcurso() {
        return gimcurso;
    }

    public void setGimcurso(Gimcurso gimcurso) {
        this.gimcurso = gimcurso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reserve reserve = (Reserve) o;
        return confirmada == reserve.confirmada && Objects.equals(cliente, reserve.cliente) && Objects.equals(gimcurso, reserve.gimcurso) && Objects.equals(fecha, reserve.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cliente, gimcurso, fecha, confirmada);
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "cliente=" + cliente +
                ", gimcurso=" + gimcurso +
                ", fecha='" + fecha + '\'' +
                ", confirmada=" + confirmada +
                '}';
    }
}
