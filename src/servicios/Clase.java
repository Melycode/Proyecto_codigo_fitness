package servicios;
import personas.Cliente;
import personas.Entrenador;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Clase extends Servicio{
        private Entrenador.Especialidad especialidad;
        public enum NivelDificultad { PRINCIPIANTE, INTERMEDIO, AVANZADO }
        private NivelDificultad nivel;
        private int duracion;
        private double precio;
        private ArrayList<Cliente> listClientes = new ArrayList<>();
        private HashSet<Cliente> setClientes = new HashSet<>();


    public Clase(int idServicio, String nombre, double precioBase, boolean activo, Entrenador.Especialidad especialidad, NivelDificultad nivel, int duracion, double precio, ArrayList<Cliente> listClientes, HashSet<Cliente> setClientes) {
        super(idServicio, nombre, precioBase, activo);
        this.especialidad = especialidad;
        this.nivel = nivel;
        this.duracion = duracion;
        this.precio = precio;
        this.listClientes = listClientes;
        this.setClientes = setClientes;
    }

    public Clase(Entrenador.Especialidad especialidad, NivelDificultad nivel, int duracion, double precio, ArrayList<Cliente> listClientes, HashSet<Cliente> setClientes) {
        this.especialidad = especialidad;
        this.nivel = nivel;
        this.duracion = duracion;
        this.precio = precio;
        this.listClientes = listClientes;
        this.setClientes = setClientes;
    }

    public Clase() {
    }

    public Entrenador.Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Entrenador.Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public NivelDificultad getNivel() {
        return nivel;
    }

    public void setNivel(NivelDificultad nivel) {
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

    public ArrayList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public HashSet<Cliente> getSetClientes() {
        return setClientes;
    }

    public void setSetClientes(HashSet<Cliente> setClientes) {
        this.setClientes = setClientes;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clase clase = (Clase) o;
        return duracion == clase.duracion && Double.compare(precio, clase.precio) == 0 && especialidad == clase.especialidad && nivel == clase.nivel && Objects.equals(listClientes, clase.listClientes) && Objects.equals(setClientes, clase.setClientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad, nivel, duracion, precio, listClientes, setClientes);
    }



    // MET

    public boolean agregarCliente(Cliente cliente, Entrenador.Especialidad especialidadElegida, NivelDificultad nivelElegido) {
        if (this.especialidad != especialidadElegida) {
            System.out.println("Esta clase es de " + this.especialidad + ", no de " + especialidadElegida);
            return false;
        }

        if (this.nivel != nivelElegido) {
            System.out.println("Nivel incorrecto");
            return false;
        }

        if (setClientes.contains(cliente)) {
            System.out.println("Este cliente ya está inscrito en la clase.");
            return false;
        }

        setClientes.add(cliente);
        listClientes.add(cliente);
        System.out.println(cliente.getNombre() + " ha sido agregado a la clase.");
        return true;
    }

    public Cliente buscarCliente(String idCliente) {
        for (Cliente c : listClientes) {
            if (c.getIdCliente().equals(idCliente)) {
                return c;
            }
        }
        System.out.println(idCliente + " no encontrado.");
        return null;
    }


    public boolean eliminarCliente(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);

        if (cliente != null) {
            setClientes.remove(cliente);
            listClientes.remove(cliente);
            System.out.println(cliente.getNombre() + " ha sido eliminado de la clase.");
            return true;
        }

        return false;
    }

    public void actualizarCurso(Entrenador.Especialidad nuevaEspecialidad, NivelDificultad nuevoNivel) {
        this.especialidad = nuevaEspecialidad;
        this.nivel = nuevoNivel;

        System.out.println("La clase ha sido actualizada a: " + this.especialidad + " (" + this.nivel + ")");

        for (Cliente c : listClientes) {
            System.out.println("✨ " + c.getNombre() + " está ahora en la clase de " + this.especialidad);
        }
    }


    @Override
    public String toString() {
        return "Clase{" +
                "especialidad=" + especialidad +
                ", nivel=" + nivel +
                ", duracion=" + duracion +
                ", precio=" + precio +
                ", listClientes=" + listClientes +
                ", setClientes=" + setClientes +
                '}';
    }
}
