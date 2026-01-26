package personas;

public class Recepcionista extends Persona {
    private int mostrador;
    private String idiomas;
    private boolean turnoExtra;
    private double bonus;

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
