package Excepciones;

// Excepción que se lanza cuando el saldo del cliente no es suficiente para pagar un servicio
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente para realizar el pago.");
    }
}