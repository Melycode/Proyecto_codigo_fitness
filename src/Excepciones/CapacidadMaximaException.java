package Excepciones;

// Excepción que se lanza cuando una clase ha alcanzado su capacidad máxima de participantes
public class CapacidadMaximaException extends Exception {
    public CapacidadMaximaException() {
        super("La clase ha alcanzado su capacidad máxima de participantes.");
    }
}