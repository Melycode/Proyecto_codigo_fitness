package servicios;
import personas.Cliente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Inscripcion extends Servicio {

    private String idInscripcion;
    private Cliente cliente;
    private Cuota cuota;
    private String fechaInicio;
    private boolean pagado;
    private static ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();
    private static HashSet<Inscripcion> conjuntoInscripciones = new HashSet<>();

    public Inscripcion(int idServicio, String nombre, boolean activo, String idInscripcion, Cliente cliente, Cuota cuota, String fechaInicio, boolean pagado) {
        super(idServicio, nombre, activo);
        this.idInscripcion = idInscripcion;
        this.cliente = cliente;
        this.cuota = cuota;
        this.fechaInicio = fechaInicio;
        this.pagado = pagado;
    }


    public Inscripcion() {
        super();
    }

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

    public Inscripcion buscarPorId(String idInscripcion) {
        for (Inscripcion i : listaInscripciones) {
            if (i.getIdInscripcion().equalsIgnoreCase(idInscripcion)) {
                return i;
            }
        }
        return null;
    }

    public boolean modificarCuota(String dni, Cuota nuevaCuota) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null && nuevaCuota != null) {
            ins.setCuota(nuevaCuota);
            return true;
        }
        return false;
    }

    public boolean modificarEstadoPago(String dni, boolean nuevoEstado) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null) {
            ins.setPagado(nuevoEstado);
            return true;
        }
        return false;
    }



    public boolean eliminarInscripcionPorDNI(String dni) {
        Inscripcion ins = buscarPorDNI(dni);
        if (ins != null) {
            listaInscripciones.remove(ins);
            conjuntoInscripciones.remove(ins);
            return true;
        }
        return false;
    }


    public boolean eliminarInscripcionPorId(String idInscripcion) {
        Inscripcion ins = buscarPorId(idInscripcion);
        if (ins != null) {
            listaInscripciones.remove(ins);
            conjuntoInscripciones.remove(ins);
            return true;
        }
        return false;
    }


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

    @Override
    public String toString() {
        return "Inscripción [" + idInscripcion + "] | Cliente: " + (cliente != null ? cliente.getNombre() : "N/A") +
                " | Plan: " + (cuota != null ? cuota.getNombre() : "N/A") +
                " | Precio: " + (cuota != null ? cuota.getPrecio() : 0.0) + "€" +
                " | Pagado: " + (pagado ? "SÍ" : "NO");
    }
}