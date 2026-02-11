import personas.Persona;
import personas.Cliente;
import servicios.Clase;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashMap<String, Cliente> mapaClientes = new HashMap<>();

        Clase curso = new Clase(
                1,
                "Fitness Total",
                50.0,
                true,
                60,
                100.0,
                listaClientes,
                mapaClientes,
                Clase.NivelDificultad.INTERMEDIO
        );


        Cliente cliente1 = new Cliente("Ana Mendoza", "87654321B", 30, Persona.Sexo.MUJER, "C001", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cliente cliente2 = new Cliente("Juan Peralta", "97654321Z", 28, Persona.Sexo.HOMBRE, "C002", Cliente.TipoMembresia.PREMIUM, 400.0, true);

        curso.agregarCliente(cliente1);
        curso.agregarCliente(cliente2);

        Cliente clienteModificado = new Cliente("Juan Peralta", "97654321Z", 28, Persona.Sexo.HOMBRE, "C002", Cliente.TipoMembresia.VIP, 600.0, true);

        System.out.println("Modificación exitosa: " + curso.modificarCliente("C002", clienteModificado));
        System.out.println(curso.buscarCliente("C002"));




    }
}