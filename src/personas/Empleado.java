package personas;

import java.util.ArrayList;
import java.util.Objects;

public class Empleado extends Persona {
    public enum Turno { MANANA, TARDE, NOCHE }
    private double salario;
    private Turno turno;
    private String fechaContratacion;
    private boolean activo;
    private ArrayList<Turno> historialTurnos = new ArrayList<>();

    public Empleado(String nombre, String dni, int edad, Sexo sexo, double salario, Turno turno, String fechaContratacion, boolean activo, ArrayList<Turno> historialTurnos) {
        super(nombre, dni, edad, sexo);
        this.salario = salario;
        this.turno = turno;
        this.fechaContratacion = fechaContratacion;
        this.activo = activo;
        this.historialTurnos = historialTurnos;
    }

    public Empleado() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayList<Turno> getHistorialTurnos() {
        return historialTurnos;
    }

    public void setHistorialTurnos(ArrayList<Turno> historialTurnos) {
        this.historialTurnos = historialTurnos;
    }

    public void agregarTurno(Turno t) {
        historialTurnos.add(t);
    }

    public boolean haTrabajadoEnTurno(Turno t) {
        for (Turno turno : historialTurnos) {
            if (turno == t) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return Double.compare(salario, empleado.salario) == 0 && activo == empleado.activo && turno == empleado.turno && Objects.equals(fechaContratacion, empleado.fechaContratacion) && Objects.equals(historialTurnos, empleado.historialTurnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario, turno, fechaContratacion, activo, historialTurnos);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", turno=" + turno +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", activo=" + activo +
                '}';
    }
}
