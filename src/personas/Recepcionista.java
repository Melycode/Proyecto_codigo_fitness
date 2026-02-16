package personas;

import servicios.Cuota;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Recepcionista extends Persona {
    private int mostrador;
    private String idiomas;
    private boolean turnoExtra;
    private double bonus;
    private HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes;

    public Recepcionista(String nombre, String dni, int edad, Sexo sexo, int mostrador, String idiomas, boolean turnoExtra, double bonus, HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes) {
        super(nombre, dni, edad, sexo);
        this.mostrador = mostrador;
        this.idiomas = idiomas;
        this.turnoExtra = turnoExtra;
        this.bonus = bonus;
        this.registroCuotasClientes = registroCuotasClientes;
    }
    
    public Recepcionista() {
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

    public HashMap<Cliente, ArrayList<Cuota>> getRegistroCuotasClientes() {
        return registroCuotasClientes;
    }

    public void setRegistroCuotasClientes(HashMap<Cliente, ArrayList<Cuota>> registroCuotasClientes) {
        this.registroCuotasClientes = registroCuotasClientes;
    }

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
    
    @Override
    public String toString() {
        return "Recepcionista{" +
                "mostrador=" + mostrador +
                ", idiomas='" + idiomas + '\'' +
                ", turnoExtra=" + turnoExtra +
                ", bonus=" + bonus +
                ", registroCuotasClientes=" + registroCuotasClientes +
                '}';
    }
}
