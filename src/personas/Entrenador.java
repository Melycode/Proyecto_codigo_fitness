package personas;

import servicios.Clase;

import java.util.ArrayList;
import java.util.Objects;

// Clase que representa a un entrenador del gimnasio, extiende de Persona
public class Entrenador extends Persona {

    // Especialidades disponibles para el entrenador
    public enum Especialidad { MUSCULACION, YOGA, PILATES, CARDIO }

    private Especialidad especialidad;
    private int aniosExperiencia;
    private boolean disponible;
    private double sueldoExtra;
    private ArrayList<Clase> clasesAsignadas = new ArrayList<>();

    // Constructor completo
    public Entrenador(String nombre, String dni, int edad, Sexo sexo, Especialidad especialidad, int aniosExperiencia, boolean disponible, double sueldoExtra, ArrayList<Clase> clasesAsignadas) {
        super(nombre, dni, edad, sexo);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.disponible = disponible;
        this.sueldoExtra = sueldoExtra;
        this.clasesAsignadas = clasesAsignadas;
    }

    // Constructor vacío
    public Entrenador() {
    }

    // Getters y setters
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

    // Asigna una clase si no estaba ya en la lista
    public void asignarClase(Clase clase) {
        if (!this.clasesAsignadas.contains(clase)) {
            this.clasesAsignadas.add(clase);
        }
    }

    // Añade una clase si no es nula ni duplicada, devuelve true si se añadió
    public boolean anadirClase(Clase clase) {
        if (clase != null && !this.clasesAsignadas.contains(clase)) {
            this.clasesAsignadas.add(clase);
            return true;
        }
        return false;
    }

    // Devuelve el índice de la clase en la lista, o -1 si no existe
    public int buscarClase(Clase clase) {
        return this.clasesAsignadas.indexOf(clase);
    }

    // Elimina la clase de la lista, devuelve true si se eliminó
    public boolean borrarClase(Clase clase) {
        return this.clasesAsignadas.remove(clase);
    }

    // Reemplaza la clase en el índice indicado, devuelve true si se modificó
    public boolean modificarClase(int indice, Clase nuevaClase) {
        if (indice >= 0 && indice < this.clasesAsignadas.size() && nuevaClase != null) {
            this.clasesAsignadas.set(indice, nuevaClase);
            return true;
        }
        return false;
    }

    // Equals y HashCode
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

    // Devuelve los datos principales del entrenador en formato texto
    @Override
    public String toString() {
        return "ENTRENADOR: " + getNombre() +
                " | Especialidad: " + especialidad +
                " | Experiencia: " + aniosExperiencia + " años" +
                " | Clases asignadas: " + clasesAsignadas.size();
    }
}