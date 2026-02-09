package personas;

import servicios.Gimcurso;

import java.util.ArrayList;
import java.util.Objects;

public class Entrenador extends Persona {
    public enum Especialidad{MUSCULACION, YOGA, PILATES, CARDIO};
    private Especialidad especialidad;
    private int aniosExperiencia;
    private boolean disponible;
    private double sueldoExtra;
    private ArrayList<Gimcurso> clasesAsignadas = new ArrayList<>();

    public Entrenador(String nombre, String dni, int edad, Sexo sexo, Especialidad especialidad, int aniosExperiencia, boolean disponible, double sueldoExtra) {
        super(nombre, dni, edad, sexo);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.disponible = disponible;
        this.sueldoExtra = sueldoExtra;
    }

    public Entrenador() {
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getSueldoExtra() {
        return sueldoExtra;
    }

    public void setSueldoExtra(double sueldoExtra) {
        this.sueldoExtra = sueldoExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entrenador that = (Entrenador) o;
        return aniosExperiencia == that.aniosExperiencia && disponible == that.disponible && Double.compare(sueldoExtra, that.sueldoExtra) == 0 && especialidad == that.especialidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad, aniosExperiencia, disponible, sueldoExtra);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "especialidad=" + especialidad +
                ", aniosExperiencia=" + aniosExperiencia +
                ", disponible=" + disponible +
                ", sueldoExtra=" + sueldoExtra +
                '}';
    }
}
