package Excepciones;

// Excepción que se lanza cuando se intenta pagar una inscripción que ya fue pagada
public class PagoYaRealizadoException extends Exception {
    public PagoYaRealizadoException() {
        super("El pago de esta inscripción ya fue realizado anteriormente.");
    }
}