package Excepciones;
public class ClienteNoEncontradoException extends Exception {
    private String identificador;
    public ClienteNoEncontradoException(String identificador) {
        super("No se encontró ningún cliente con el identificador: " + identificador);
        this.identificador = identificador;
    }
    public ClienteNoEncontradoException(String identificador, String mensaje) {
        super(mensaje);
        this.identificador = identificador;
    }
    public String getIdentificador() {
        return identificador;
    }
}

