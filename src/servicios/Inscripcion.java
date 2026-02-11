package servicios;

import personas.Cliente;
import java.util.HashMap;
import java.util.Objects;

public class Inscripcion {
    // Atributos requeridos (mínimo 4) [cite: 13]
    private String idInscripcion;
    private Cliente cliente;
    private Cuota cuota;
    private String fechaInicio;
    private boolean pagado;

    // SEGUNDO HASHMAP DEL PROYECTO
    private static HashMap<String, Inscripcion> mapaInscripciones = new HashMap<>();

    public Inscripcion(String idInscripcion, Cliente cliente, Cuota cuota, String fechaInicio, boolean pagado) {
        this.idInscripcion = idInscripcion;
        this.cliente = cliente;
        this.cuota = cuota;
        this.fechaInicio = fechaInicio;
        this.pagado = pagado;
    }

    // Constructor vacío [cite: 14]
    public Inscripcion() {
    }

    // Getters y Setters [cite: 16]
    public String getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(String idInscripcion) { this.idInscripcion = idInscripcion; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Cuota getCuota() { return cuota; }
    public void setCuota(Cuota cuota) { this.cuota = cuota; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public boolean isPagado() { return pagado; }
    public void setPagado(boolean pagado) { this.pagado = pagado; }

    // MÉTODO: AÑADIR
    public boolean agregarInscripcion(Inscripcion ins) {
        if (ins != null && !mapaInscripciones.containsKey(ins.getIdInscripcion())) {
            mapaInscripciones.put(ins.getIdInscripcion(), ins);
            return true;
        }
        return false;
    }

    // MÉTODO: BUSCAR
    public Inscripcion buscarInscripcion(String id) {
        return mapaInscripciones.get(id);
    }

    // MÉTODO: BORRAR
    public boolean borrarInscripcion(String id) {
        return mapaInscripciones.remove(id) != null;
    }

    // MÉTODO: MODIFICAR
    public boolean modificarEstadoPago(String id, boolean nuevoEstado) {
        Inscripcion ins = mapaInscripciones.get(id);
        if (ins != null) {
            ins.setPagado(nuevoEstado);
            return true;
        }
        return false;
    }

    // equals y hashCode [cite: 27]
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripcion that = (Inscripcion) o;
        return pagado == that.pagado && Objects.equals(idInscripcion, that.idInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscripcion, pagado);
    }

    // toString personalizado [cite: 17]
    @Override
    public String toString() {
        return "Inscripcion{" +
                "ID='" + idInscripcion + '\'' +
                ", Cliente=" + (cliente != null ? cliente.getNombre() : "N/A") +
                ", Cuota=" + (cuota != null ? cuota.getNombre() : "N/A") +
                ", Fecha='" + fechaInicio + '\'' +
                ", Pagado=" + pagado +
                '}';
    }
}