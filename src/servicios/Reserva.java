package servicios;

import personas.Cliente;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva extends Servicio{
    private Cliente cliente;
    private Clase clase;
    private LocalDate fecha;
    private boolean confirmada;

    public Reserva(int idServicio, String nombre, boolean activo, Cliente cliente, Clase clase, LocalDate fecha, boolean confirmada) {
        super(idServicio, nombre, activo);
        this.cliente = cliente;
        this.clase = clase;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    public Reserva() {
        super();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
        Reserva reserva = (Reserva) o;
        return confirmada == reserva.confirmada && Objects.equals(cliente, reserva.cliente) && Objects.equals(clase, reserva.clase) && Objects.equals(fecha, reserva.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cliente, clase, fecha, confirmada);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", clase=" + clase +
                ", fecha=" + fecha +
                ", confirmada=" + confirmada +
                '}';
    }
}
