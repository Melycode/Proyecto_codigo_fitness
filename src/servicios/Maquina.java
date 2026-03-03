package servicios;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

// Clase que representa a una máquina del gimnasio, extiende de Servicios
public class Maquina extends Servicio {
    public enum EstadoMaquina { OPERATIVA, AVERIADA, MANTENIMIENTO }
    private String nombreMaquina;
    private EstadoMaquina estado;
    private double horasUso;
    private boolean mantenimiento;
    private HashMap<LocalDate, EstadoMaquina> historialEstados;

    // Constructor completo


    public Maquina(int idServicio, String nombre, boolean activo, String descripcion, String nombreMaquina, EstadoMaquina estado, double horasUso, boolean mantenimiento, HashMap<LocalDate, EstadoMaquina> historialEstados) {
        super(idServicio, nombre, activo, descripcion);
        this.nombreMaquina = nombreMaquina;
        this.estado = estado;
        this.horasUso = horasUso;
        this.mantenimiento = mantenimiento;
        this.historialEstados = historialEstados;
    }

    public Maquina(String nombreMaquina, EstadoMaquina estado, double horasUso, boolean mantenimiento, HashMap<LocalDate, EstadoMaquina> historialEstados) {
        this.nombreMaquina = nombreMaquina;
        this.estado = estado;
        this.horasUso = horasUso;
        this.mantenimiento = mantenimiento;
        this.historialEstados = historialEstados;
    }

    public Maquina() {
        super();
        this.historialEstados = new HashMap<>();
    }

    // Getters y setters


    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public double getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(double horasUso) {
        this.horasUso = horasUso;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public HashMap<LocalDate, EstadoMaquina> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(HashMap<LocalDate, EstadoMaquina> historialEstados) {
        this.historialEstados = historialEstados;
    }

    // Añade un estado al historial en la fecha indicada, actualizando el estado actual si es hoy
    public void anadirEstado(LocalDate fecha, EstadoMaquina nuevoEstado) {
        this.historialEstados.put(fecha, nuevoEstado);
        if (fecha.equals(LocalDate.now())) {
            this.estado = nuevoEstado;
        }
    }

    // Busca y devuelve el estado de la máquina en una fecha concreta, o null si no existe
    public EstadoMaquina buscarEstadoPorFecha(LocalDate fecha) {
        return this.historialEstados.get(fecha);
    }


    // Modifica el estado en una fecha existente, devuelve true si se modificó correctamente
    public boolean modificarEstado(LocalDate fecha, EstadoMaquina nuevoEstado) {
        if (this.historialEstados.containsKey(fecha)) {
            this.historialEstados.put(fecha, nuevoEstado);
            if (fecha.equals(LocalDate.now())) {
                this.estado = nuevoEstado;
            }
            return true;
        }
        return false;
    }

    // Elimina el estado de una fecha del historial, devuelve true si se eliminó correctamente
    public boolean borrarEstado(LocalDate fecha) {
        return this.historialEstados.remove(fecha) != null;
    }


    // Equals y HashCode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Maquina maquina = (Maquina) o;
        return Double.compare(horasUso, maquina.horasUso) == 0 && mantenimiento == maquina.mantenimiento && Objects.equals(nombreMaquina, maquina.nombreMaquina) && estado == maquina.estado && Objects.equals(historialEstados, maquina.historialEstados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombreMaquina, estado, horasUso, mantenimiento, historialEstados);
    }

    // Devuelve los datos principales de la máquina en formato texto
    @Override
    public String toString() {
        return String.format("MAQUINA [%s] | Nombre: %s | Debido a que ha sido usada: %s horas | Ahora está en mantenimiento: %s | Descripción: %s",
                estado,
                nombreMaquina,
                horasUso,
                mantenimiento,
                descripcion);
    }

}
