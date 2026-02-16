package servicios;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class Maquina extends Servicio {
    public enum EstadoMaquina { OPERATIVA, AVERIADA, MANTENIMIENTO }
    private String nombreMaquina;
    private EstadoMaquina estado;
    private double horasUso;
    private boolean mantenimiento;
    private HashMap<LocalDate, EstadoMaquina> historialEstados;


    public Maquina(int idServicio, String nombre, boolean activo,
                   String nombreMaquina, EstadoMaquina estado, double horasUso,
                   boolean mantenimiento, HashMap<LocalDate, EstadoMaquina> historialEstados) {
        super(idServicio, nombre, activo);
        this.nombreMaquina = nombreMaquina;
        this.estado = estado;
        this.horasUso = horasUso;
        this.mantenimiento = mantenimiento;
        this.historialEstados = (historialEstados != null) ? historialEstados : new HashMap<>();

    }


    public Maquina() {
        super();
        this.historialEstados = new HashMap<>();
    }



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



    public void anadirEstado(LocalDate fecha, EstadoMaquina nuevoEstado) {
        this.historialEstados.put(fecha, nuevoEstado);
        if (fecha.equals(LocalDate.now())) {
            this.estado = nuevoEstado;
        }
    }

    public EstadoMaquina buscarEstadoPorFecha(LocalDate fecha) {
        return this.historialEstados.get(fecha);
    }

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


    public boolean borrarEstado(LocalDate fecha) {
        return this.historialEstados.remove(fecha) != null;
    }


    @Override
    public String toString() {
        return "Maquina{" +
                "nombreMaquina='" + nombreMaquina + '\'' +
                ", estado=" + estado +
                ", horasUso=" + horasUso +
                ", mantenimiento=" + mantenimiento +
                ", historialEstados=" + historialEstados +
                '}';
    }
}
