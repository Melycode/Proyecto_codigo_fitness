package personas;

import java.util.ArrayList;

public class Empleado extends Persona {
    public enum Turno { MANANA, TARDE, NOCHE }
    private double salario;
    private Turno turno;
    private String fechaContratacion;
    private boolean activo;
    private ArrayList<Turno> historialTurnos = new ArrayList<>();

    public Empleado(String nombre, String dni, int edad, Sexo sexo, double salario, Turno turno, String fechaContratacion, boolean activo) {
        super(nombre, dni, edad, sexo);
        this.salario = salario;
        this.turno = turno;
        this.fechaContratacion = fechaContratacion;
        this.activo = activo;
    }

    public Empleado() {
        super();
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
