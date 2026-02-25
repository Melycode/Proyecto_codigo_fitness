package personas;

import java.util.ArrayList;
import java.util.Objects;

// Clase que representa a un empleado del gimnasio, extiende de Persona
public class Empleado extends Persona {

    // Turnos disponibles para el empleado
    public enum Turno { MANANA, TARDE, NOCHE }

    private Turno turno;
    private double salario;
    private String fechaContratacion;
    private boolean activo;
    private ArrayList<Turno> historialTurnos = new ArrayList<>();

    // Constructor completo
    public Empleado(String nombre, String dni, int edad, Sexo sexo, Turno turno, double salario, String fechaContratacion, boolean activo, ArrayList<Turno> historialTurnos) {
        super(nombre, dni, edad, sexo);
        this.salario = salario;
        this.turno = turno;
        this.fechaContratacion = fechaContratacion;
        this.activo = activo;
        this.historialTurnos = historialTurnos;
    }

    // Constructor vacío
    public Empleado() {
    }

    // Getters y setters
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

    // Añade un turno al historial
    public void agregarTurno(Turno t) {
        historialTurnos.add(t);
    }

    // Devuelve true si el empleado ha trabajado alguna vez en ese turno
    public boolean haTrabajadoEnTurno(Turno t) {
        for (Turno turno : this.historialTurnos) {
            if (turno == t) {
                return true;
            }
        }
        return false;
    }

    // Devuelve el índice de la primera aparición del turno, o -1 si no existe
    public int buscarPrimerTurno(Turno t) {
        return this.historialTurnos.indexOf(t);
    }

    // Devuelve el índice de la última aparición del turno, o -1 si no existe
    public int buscarUltimoTurno(Turno t) {
        return this.historialTurnos.lastIndexOf(t);
    }

    // Elimina el turno en el índice indicado, devuelve el turno eliminado o null
    public Turno borrarTurno(int indice) {
        if (indice >= 0 && indice < this.historialTurnos.size()) {
            return this.historialTurnos.remove(indice);
        }
        return null;
    }

    // Elimina todas las ocurrencias del turno, devuelve cuántas se eliminaron
    public int borrarTodosTurnos(Turno t) {
        int contador = 0;
        while (this.historialTurnos.remove(t)) {
            contador++;
        }
        return contador;
    }

    // Añade un turno al historial si no es nulo
    public void anadirTurno(Turno t) {
        if (t != null) {
            this.historialTurnos.add(t);
        }
    }

    // Reemplaza el turno en el índice indicado, devuelve el turno anterior o null
    public Turno modificarTurno(int indice, Turno nuevoTurno) {
        if (nuevoTurno != null && indice >= 0 && indice < this.historialTurnos.size()) {
            return this.historialTurnos.set(indice, nuevoTurno);
        }
        return null;
    }

    // Reemplaza todas las ocurrencias de un turno por otro, devuelve cuántos se reemplazaron
    public int reemplazarTurno(Turno turnoViejo, Turno turnoNuevo) {
        if (turnoViejo == null || turnoNuevo == null) {
            return 0;
        }
        int contador = 0;
        for (int i = 0; i < this.historialTurnos.size(); i++) {
            if (this.historialTurnos.get(i) == turnoViejo) {
                this.historialTurnos.set(i, turnoNuevo);
                contador++;
            }
        }
        return contador;
    }

    // Equals y HashCode
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

    // Devuelve los datos principales del empleado en formato texto
    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Inactivo";
        return "EMPLEADO: " + getNombre() +
                " | Turno: " + turno +
                " | Salario: " + salario + "€" +
                " | Estado: " + estado +
                " | Cambios de turno: " + historialTurnos.size();
    }
}