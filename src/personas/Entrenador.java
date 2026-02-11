package personas;

import servicios.Clase;

import java.util.ArrayList;
import java.util.Objects;

public class Entrenador extends Persona {
    public enum Especialidad{MUSCULACION, YOGA, PILATES, CARDIO};
    private Especialidad especialidad;
    private int aniosExperiencia;
    private boolean disponible;
    private double sueldoExtra;
    private ArrayList<Clase> clasesAsignadas = new ArrayList<>();

    public Entrenador(String nombre, String dni, int edad, Sexo sexo, Especialidad especialidad, int aniosExperiencia, boolean disponible, double sueldoExtra, ArrayList<Clase> clasesAsignadas) {
        super(nombre, dni, edad, sexo);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.disponible = disponible;
        this.sueldoExtra = sueldoExtra;
        this.clasesAsignadas = clasesAsignadas;
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

    public ArrayList<Clase> getClasesAsignadas() {
        return clasesAsignadas;
    }

    public void setClasesAsignadas(ArrayList<Clase> clasesAsignadas) {
        this.clasesAsignadas = clasesAsignadas;
    }

    public void asignarClase(Clase clase) {
        if (!this.clasesAsignadas.contains(clase)) {
            this.clasesAsignadas.add(clase);
        }
    }
    public boolean anadirClase(Clase clase) {
        if (clase != null && !this.clasesAsignadas.contains(clase)) {
            this.clasesAsignadas.add(clase);
            return true;
        }
        return false;
    }
    public int buscarClase(Clase clase) {
        return this.clasesAsignadas.indexOf(clase);
    }
    public boolean borrarClase(Clase clase) {
        return this.clasesAsignadas.remove(clase);
    }
    public boolean modificarClase(int indice, Clase nuevaClase) {
        if (indice >= 0 && indice < this.clasesAsignadas.size() && nuevaClase != null) {
            this.clasesAsignadas.set(indice, nuevaClase);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entrenador that = (Entrenador) o;
        return aniosExperiencia == that.aniosExperiencia && disponible == that.disponible && Double.compare(sueldoExtra, that.sueldoExtra) == 0 && especialidad == that.especialidad && Objects.equals(clasesAsignadas, that.clasesAsignadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad, aniosExperiencia, disponible, sueldoExtra, clasesAsignadas);
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
