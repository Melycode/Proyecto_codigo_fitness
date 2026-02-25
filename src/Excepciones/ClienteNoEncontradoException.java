package Excepciones;

// Excepción que se lanza cuando no se encuentra ningún cliente con el identificador dado
public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException() {
        super("No se encontró ningún cliente con el identificador proporcionado.");
    }
}