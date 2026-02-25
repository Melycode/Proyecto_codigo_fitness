package servicios;

import personas.Cliente;

import java.time.LocalDate;
import java.util.Objects;

// Clase que representa una reserva de un cliente para una clase, extiende de Servicio
public class Reserva extends Servicio {

    private Cliente cliente;
    private Clase clase;
    private String fecha;
    private boolean confirmada;

    // Constructor completo
    public Reserva(int idServicio, String nombre, boolean activo, Cliente cliente, Clase clase, String fecha, boolean confirmada) {
        super(idServicio, nombre, activo);
        this.cliente = cliente;
        this.clase = clase;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    // Constructor vacío
    public Reserva() {
        super();
    }

    // Getters y setters
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

    // equals y hashCode
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

    // Devuelve los datos principales de la reserva en formato texto
    @Override
    public String toString() {
        String estado = confirmada ? "CONFIRMADA" : "PENDIENTE";
        return String.format("RESERVA [%s] | Cliente: %s | Clase: %s | Fecha: %s",
                estado,
                cliente.getNombre(),
                clase.getNombre(),
                fecha);
    }
}