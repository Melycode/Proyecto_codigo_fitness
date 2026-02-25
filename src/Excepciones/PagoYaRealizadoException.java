package Excepciones;
public class PagoYaRealizadoException extends Exception {
    private String idInscripcion;
    public PagoYaRealizadoException(String idInscripcion) {
        super("El pago de la inscripción '" + idInscripcion + "' ya fue realizado anteriormente.");
        this.idInscripcion = idInscripcion;
    }
    public PagoYaRealizadoException(String idInscripcion, String mensaje) {
        super(mensaje);
        this.idInscripcion = idInscripcion;
    }
    public String getIdInscripcion() {
        return idInscripcion;
    }
}
