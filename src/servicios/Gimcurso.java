package servicios;
import personas.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Gimcurso extends Servicio{
        public enum NivelDificultad { PRINCIPIANTE, INTERMEDIO, AVANZADO }
        private int duracion;
        private double precio;
        private ArrayList<Cliente> listaClientes;         // atributo tipo lista
        private HashMap<Integer, Cliente> mapaClientes;  // atributo tipo HashMap
        private NivelDificultad nivel;

    public Gimcurso(int idServicio, String nombre, double precioBase, boolean activo, int duracion, double precio, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes, NivelDificultad nivel) {
        super(idServicio, nombre, precioBase, activo);
        this.duracion = duracion;
        this.precio = precio;
        this.listaClientes = listaClientes;
        this.mapaClientes = mapaClientes;
        this.nivel = nivel;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public HashMap<Integer, Cliente> getMapaClientes() {
        return mapaClientes;
    }

    public void setMapaClientes(HashMap<Integer, Cliente> mapaClientes) {
        this.mapaClientes = mapaClientes;
    }

    public NivelDificultad getNivel() {
        return nivel;
    }

    public void setNivel(NivelDificultad nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gimcurso gimcurso = (Gimcurso) o;
        return duracion == gimcurso.duracion && Double.compare(precio, gimcurso.precio) == 0 && Objects.equals(listaClientes, gimcurso.listaClientes) && Objects.equals(mapaClientes, gimcurso.mapaClientes) && Objects.equals(nivel, gimcurso.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duracion, precio, listaClientes, mapaClientes, nivel);
    }

    @Override
    public String toString() {
        return "Gimcurso{" +
                "duracion=" + duracion +
                ", precio=" + precio +
                ", listaClientes=" + listaClientes +
                ", mapaClientes=" + mapaClientes +
                ", nivel=" + nivel +
                '}';
    }
}
