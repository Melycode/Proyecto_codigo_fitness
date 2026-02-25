package personas;

import servicios.Cuota;

import java.util.ArrayList;
import java.util.HashMap;

public class Recepcionista extends Persona {
    private int mostrador;
    private String idiomas;
    private boolean turnoExtra;
    private double bonus;
    private HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes = new HashMap<>();;

    public Recepcionista(String nombre, String dni, int edad, Sexo sexo, int mostrador, String idiomas, boolean turnoExtra, double bonus) {
        super(nombre, dni, edad, sexo);
        this.mostrador = mostrador;
        this.idiomas = idiomas;
        this.turnoExtra = turnoExtra;
        this.bonus = bonus;
    }

    public Recepcionista() {
        super();
    }

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

    public void agregarCuota(Cliente cliente, Cuota cuota) {
        // Si el cliente no está en el mapa, le creamos una lista nueva
        registroCuotasClientes.putIfAbsent(cliente, new ArrayList<>());
        // Añadimos la cuota a su lista
        registroCuotasClientes.get(cliente).add(cuota);
    }

    public ArrayList<Cuota> buscarHistorial(String dni) {
        // Buscamos en el mapa el cliente que coincida con ese DNI
        for (Cliente c : registroCuotasClientes.keySet()) {
            if (c.getDni().equals(dni)) {
                return registroCuotasClientes.get(c);
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Recepcionista{" +
                "mostrador=" + mostrador +
                ", idiomas='" + idiomas + '\'' +
                ", turnoExtra=" + turnoExtra +
                ", bonus=" + bonus +
                '}';
    }
}
