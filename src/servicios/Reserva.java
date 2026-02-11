package servicios;

import personas.Cliente;

import java.util.Objects;

public class Reserva extends Servicio{
    private Cliente cliente;
    private Clase clase;
    private String fecha;
    private boolean confirmada;

    public Reserva(int idServicio, String nombre, double precioBase, boolean activo, Cliente cliente, Clase clase, String fecha, boolean confirmada) {
        super(idServicio, nombre, precioBase, activo);
        this.cliente = cliente;
        this.clase = clase;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    public Reserva() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clase getGimcurso() {
        return clase;
    }

    public void setGimcurso(Clase clase) {
        this.clase = clase;
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
        Reserva reserve = (Reserva) o;
        return confirmada == reserve.confirmada && Objects.equals(cliente, reserve.cliente) && Objects.equals(clase, reserve.clase) && Objects.equals(fecha, reserve.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cliente, clase, fecha, confirmada);
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "cliente=" + cliente +
                ", gimcurso=" + clase +
                ", fecha='" + fecha + '\'' +
                ", confirmada=" + confirmada +
                '}';
    }
}
