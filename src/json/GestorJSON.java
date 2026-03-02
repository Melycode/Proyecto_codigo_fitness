package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import servicios.Inscripcion;

import java.io.File;
import java.util.ArrayList;

// Clase encargada de escribir y leer inscripciones en un archivo JSON
public class GestorJSON {

    // Ruta del archivo JSON donde se guardan las inscripciones
    private static final String RUTA = "inscripciones.json";

    // Escribe la lista de inscripciones en el archivo JSON
    public static void escribirInscripciones(ArrayList<Inscripcion> lista) {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(new File(RUTA), lista);
            System.out.println("Inscripciones guardadas correctamente en " + RUTA);
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    // Lee el archivo JSON y devuelve la lista de inscripciones
    public static ArrayList<Inscripcion> leerInscripciones() {
        ObjectMapper om = new ObjectMapper();
        try {
            ArrayList<Inscripcion> lista = om.readValue(new File(RUTA),
                    om.getTypeFactory().constructCollectionType(ArrayList.class, Inscripcion.class));
            System.out.println("Inscripciones cargadas correctamente desde " + RUTA);
            return lista;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}