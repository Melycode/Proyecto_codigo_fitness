package servicios;

import java.util.Objects;

// Clase que representa una cuota de pago del gimnasio, extiende de Servicio
public class Cuota extends Servicio {

    // Periodos de pago disponibles para la cuota
    public enum Periodo { MENSUAL, TRIMESTRAL, ANUAL }
    private Periodo periodo;
    private double precio;
    private int descuento;
    private boolean renovacion;

    // Constructor completo


    public Cuota(int idServicio, String nombre, boolean activo, String descripcion, Periodo periodo, double precio, int descuento, boolean renovacion) {
        super(idServicio, nombre, activo, descripcion);
        this.periodo = periodo;
        this.precio = precio;
        this.descuento = descuento;
        this.renovacion = renovacion;
    }

    public Cuota(Periodo periodo, double precio, int descuento, boolean renovacion) {
        this.periodo = periodo;
        this.precio = precio;
        this.descuento = descuento;
        this.renovacion = renovacion;
    }

    // Constructor vacío
    public Cuota() {
        super();
    }

    // Getters y setters


    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public boolean isRenovacion() {
        return renovacion;
    }

    public void setRenovacion(boolean renovacion) {
        this.renovacion = renovacion;
    }

    // Equals y HashCode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cuota cuota = (Cuota) o;
        return Double.compare(precio, cuota.precio) == 0 && descuento == cuota.descuento && renovacion == cuota.renovacion && periodo == cuota.periodo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), periodo, precio, descuento, renovacion);
    }

    // Devuelve los datos principales de la cuota en formato texto
    @Override
    public String toString() {
        String estado = isActivo() ? "ACTIVA" : "INACTIVA";
        return String.format("CUOTA: %s [%s] | Periodo: %s | Precio: %.2f€ | Descuento: %d%% | Renovación: %s | Descripción: %s",
                getNombre(),
                estado,
                periodo,
                precio,
                descuento,
                renovacion ? "SÍ" : "NO",
                descripcion);
    }
}

