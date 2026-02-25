package servicios;

import java.util.Objects;

// Clase que representa una cuota de pago del gimnasio, extiende de Servicio
public class Cuota extends Servicio {

    // Periodos de pago disponibles para la cuota
    public enum Periodo { MENSUAL, TRIMESTRAL, ANUAL }

    private Periodo periodo;
    private double precio;

    // Constructor completo
    public Cuota(int idServicio, String nombre, boolean activo, Periodo periodo, double precio) {
        super(idServicio, nombre, activo);
        this.periodo = periodo;
        this.precio = precio;
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

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cuota cuota = (Cuota) o;
        return Double.compare(precio, cuota.precio) == 0 && periodo == cuota.periodo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), periodo, precio);
    }

    // Devuelve los datos principales de la cuota en formato texto
    @Override
    public String toString() {
        String estado = isActivo() ? "ACTIVA" : "INACTIVA";
        return String.format("CUOTA: %s [%s] | Periodo: %s | Precio: %.2f€",
                getNombre(),
                estado,
                periodo,
                precio);
    }
}