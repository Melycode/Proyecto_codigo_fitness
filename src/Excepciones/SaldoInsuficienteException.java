package Excepciones;
public class SaldoInsuficienteException extends Exception {
    private double saldoActual;
    private double precioRequerido;
    public SaldoInsuficienteException(double saldoActual, double precioRequerido) {
        super("Saldo insuficiente. Saldo actual: " + saldoActual +
                "€, precio requerido: " + precioRequerido + "€.");
        this.saldoActual = saldoActual;
        this.precioRequerido = precioRequerido;
    }
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
    public double getSaldoActual() {
        return saldoActual;
    }
    public double getPrecioRequerido() {
        return precioRequerido;
    }
}