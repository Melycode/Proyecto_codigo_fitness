import personas.Entrenador;
import personas.Persona;
import personas.Cliente;
import servicios.Clase;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashSet<Cliente> setClientes = new HashSet<>();

        Clase curso = new Clase(1, "Yoga Flow", 50.0, true, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 100.0, listaClientes, setClientes);

        Cliente cliente1 = new Cliente("José Gutiérrez", "87654321B", 45, Persona.Sexo.HOMBRE, "C001", Cliente.TipoMembresia.BASICA, 200.0, true);

        curso.agregarCliente(cliente1, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO);
        curso.agregarCliente(cliente1, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO);

        Cliente encontrado = curso.buscarCliente("C001");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        curso.actualizarCurso(Entrenador.Especialidad.PILATES, Clase.NivelDificultad.PRINCIPIANTE);


        boolean eliminado = curso.eliminarCliente("C001");
        if (eliminado) {
            System.out.println("Confirmado: El cliente ya no está en la clase.");
        }


    }
}