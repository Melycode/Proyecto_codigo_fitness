package Excepciones;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }

    public SaldoInsuficienteException(double saldo, double precioCuota) {
    }
}
