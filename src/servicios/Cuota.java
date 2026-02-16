package servicios;

import java.util.Objects;

public class Cuota extends Servicio{
        public enum Periodo { MENSUAL, TRIMESTRAL, ANUAL }
        private Periodo periodo;
        private double precio;

    public Cuota(int idServicio, String nombre, boolean activo, Periodo periodo, double precio) {
        super(idServicio, nombre, activo);
        this.periodo = periodo;
        this.precio = precio;
    }


    public Cuota() {
        super();
    }


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

    @Override
    public String toString() {
        return "Cuota{" +
                "periodo=" + periodo +
                ", precio=" + precio +
                '}';
    }
}
