package Excepciones;
public class CapacidadMaximaException extends Exception {
    private int capacidadMaxima;
    public CapacidadMaximaException(int capacidadMaxima) {
        super("La clase ha alcanzado su capacidad máxima de " + capacidadMaxima + " personas.");
        this.capacidadMaxima = capacidadMaxima;
    }
    public CapacidadMaximaException(String mensaje) {
        super(mensaje);
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}