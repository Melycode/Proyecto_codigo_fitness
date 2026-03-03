package servicios;
import personas.Cliente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

// Clase que representa una inscripción al gimnasio, extiende de Servicio
public class Inscripcion extends Servicio {
    private String idInscripcion;
    private Cliente cliente;
    private Cuota cuota;
    private String fechaInicio;
    private boolean pagado;
    private static ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();
    private static HashSet<Inscripcion> conjuntoInscripciones = new HashSet<>();


    // Constructor completo
    public Inscripcion(int idServicio, String nombre, boolean activo, String descripcion, String idInscripcion, Cliente cliente, Cuota cuota, String fechaInicio, boolean pagado) {
        super(idServicio, nombre, activo, descripcion);
        this.idInscripcion = idInscripcion;
        this.cliente = cliente;
        this.cuota = cuota;
        this.fechaInicio = fechaInicio;
        this.pagado = pagado;
    }


    // Constructor vacío
    public Inscripcion() {
        super();
    }


    // Getters y setters


    public String getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public static ArrayList<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    public static void setListaInscripciones(ArrayList<Inscripcion> listaInscripciones) {
        Inscripcion.listaInscripciones = listaInscripciones;
    }

    public static HashSet<Inscripcion> getConjuntoInscripciones() {
        return conjuntoInscripciones;
    }

    public static void setConjuntoInscripciones(HashSet<Inscripcion> conjuntoInscripciones) {
        Inscripcion.conjuntoInscripciones = conjuntoInscripciones;
    }

    // Agrega una inscripción si el cliente no está ya inscrito, devuelve true si se añadió
    public boolean agregarInscripcion(Inscripcion ins) {
        if (ins != null) {
            for (Inscripcion i : listaInscripciones) {
                if (i.getCliente().getDni().equalsIgnoreCase(ins.getCliente().getDni())) {
                    System.out.println("El cliente ya está inscrito con DNI: " + ins.getCliente().getDni());
                    return false;
                }
            }
            listaInscripciones.add(ins);
            conjuntoInscripciones.add(ins);
            return true;
        }
        return false;
    }

    // Busca y devuelve una inscripción por el DNI del cliente, o null si no existe
    public Inscripcion buscarPorDNI(String dni) {
        for (Inscripcion ins : listaInscripciones) {
            if (ins.getCliente() != null &&
                    ins.getCliente().getDni() != null &&
                    ins.getCliente().getDni().equalsIgnoreCase(dni)) {

                return ins;
            }
        }
        return null;
    }

    // Modifica la cuota de una inscripción buscando por DNI, devuelve true si se modificó
    public boolean modificarCuota(String dni, Cuota nuevaCuota) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null && nuevaCuota != null) {
            ins.setCuota(nuevaCuota);
            return true;
        }
        return false;
    }

    // Modifica el estado de pago de una inscripción buscando por DNI, devuelve true si se modificó
    public boolean modificarEstadoPago(String dni, boolean nuevoEstado) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null) {
            ins.setPagado(nuevoEstado);
            return true;
        }
        return false;
    }


    // Elimina una inscripción por el DNI del cliente, devuelve true si se eliminó correctamente
    public boolean eliminarInscripcionPorDNI(String dni) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null) {
            listaInscripciones.remove(ins);
            conjuntoInscripciones.remove(ins);
            return true;
        }
        return false;
    }


    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripcion that = (Inscripcion) o;
        return Objects.equals(idInscripcion, that.idInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscripcion);
    }


    // Devuelve los datos principales de la inscripción en formato texto
    @Override
    public String toString() {
        String estado = pagado ? "PAGADO" : "PENDIENTE";
        return String.format("INSCRIPCION [%s] | Cliente: %s | Plan: %s | Precio: %s€ | Descripción: %s",
                estado,
                cliente != null ? cliente.getNombre() : "N/A",
                cuota != null ? cuota.getNombre() : "N/A",
                cuota != null ? cuota.getPrecio() : 0.0,
                descripcion);
    }
}