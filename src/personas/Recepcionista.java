package personas;

import servicios.Cuota;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

// Clase que representa a una recepcionista del gimnasio, extiende de Persona
public class Recepcionista extends Persona {
    private int mostrador;
    private String idiomas;
    private boolean turnoExtra;
    private double bonus;
    private HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes = new HashMap<>();;

    // Constructor completo
    public Recepcionista(String nombre, String dni, int edad, Sexo sexo, int mostrador, String idiomas, boolean turnoExtra, double bonus) {
        super(nombre, dni, edad, sexo);
        this.mostrador = mostrador;
        this.idiomas = idiomas;
        this.turnoExtra = turnoExtra;
        this.bonus = bonus;
    }

    // Constructor vacio
    public Recepcionista() {
        super();
    }


    // Getters y setters
    public int getMostrador() {
        return mostrador;
    }

    public void setMostrador(int mostrador) {
        this.mostrador = mostrador;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isTurnoExtra() {
        return turnoExtra;
    }

    public void setTurnoExtra(boolean turnoExtra) {
        this.turnoExtra = turnoExtra;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public HashMap<Cliente, ArrayList<Cuota>> getRegistroCuotasClientes() {
        return registroCuotasClientes;
    }

    public void setRegistroCuotasClientes(HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes) {
        this.registroCuotasClientes = registroCuotasClientes;
    }


    // Añade una cuota al historial del cliente, creando su lista si no existe
    public void agregarCuota(Cliente cliente, Cuota cuota) {
        // Si el cliente no está en el mapa, le creamos una lista nueva
        registroCuotasClientes.putIfAbsent(cliente, new ArrayList<>());
        // Añadimos la cuota a su lista
        registroCuotasClientes.get(cliente).add(cuota);
    }

    // Busca y devuelve el historial de cuotas de un cliente por su DNI, o null si no existe
    public ArrayList<Cuota> buscarHistorial(String dni) {
        // Buscamos en el mapa el cliente que coincida con ese DNI
        for (Cliente c : registroCuotasClientes.keySet()) {
            if (c.getDni().equals(dni)) {
                return registroCuotasClientes.get(c);
            }
        }
        return null;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recepcionista that = (Recepcionista) o;
        return mostrador == that.mostrador && turnoExtra == that.turnoExtra && Double.compare(bonus, that.bonus) == 0 && Objects.equals(idiomas, that.idiomas) && Objects.equals(registroCuotasClientes, that.registroCuotasClientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mostrador, idiomas, turnoExtra, bonus, registroCuotasClientes);
    }

    // Devuelve los datos principales de la recepcionista en formato texto
    @Override
    public String toString() {
        String turno = turnoExtra ? "Sí" : "No";
        return "RECEPCIONISTA: " + getNombre() +
                " | Mostrador: " + mostrador +
                " | Idiomas: " + idiomas +
                " | Turno extra: " + turno +
                " | Bonus: " + bonus + "€";
    }
}
