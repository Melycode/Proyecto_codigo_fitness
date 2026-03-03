package test;
import Excepciones.CapacidadMaximaException;
import Excepciones.ClienteNoEncontradoException;
import org.junit.jupiter.api.Test;
import personas.Cliente;
import personas.Entrenador;
import personas.Persona;
import servicios.Clase;
import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class ClaseTest {

    @Test
    public void testGetNombreClase() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        assertEquals("Yoga Matutino", clase.getNombre());
    }

    @Test
    public void testGetPrecio() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        assertEquals(15.0, clase.getPrecio());
    }

    @Test
    public void testClaseActiva() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        assertTrue(clase.isActivo());
    }

    @Test
    public void testAgregarClienteCorrecto() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        boolean resultado = clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE);
        assertTrue(resultado);
        assertEquals(1, clase.getListClientes().size());
    }

    @Test
    public void testBuscarClienteExistente() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.PRINCIPIANTE);
        Cliente encontrado = clase.buscarCliente("C003");
        assertNotNull(encontrado);
        assertEquals("Nacho Torres", encontrado.getNombre());
    }

    @Test
    public void testEliminarClienteExistente() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.PRINCIPIANTE);
        boolean eliminado = clase.eliminarCliente("C003");
        assertTrue(eliminado);
        assertEquals(0, clase.getListClientes().size());
    }

    @Test
    public void testAgregarClienteEspecialidadIncorrecta() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        boolean resultado = clase.agregarCliente(cliente, Entrenador.Especialidad.CARDIO,
                Clase.NivelDificultad.PRINCIPIANTE);
        assertFalse(resultado);
    }

    @Test
    public void testAgregarClienteNivelIncorrecto() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        boolean resultado = clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.AVANZADO);
        assertFalse(resultado);
    }

    @Test
    public void testBuscarClienteNoExistente() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        assertThrows(ClienteNoEncontradoException.class, () -> {
            Cliente encontrado = clase.buscarCliente("C999");
            if (encontrado == null) {
                throw new ClienteNoEncontradoException();
            }
        });
    }

    @Test
    public void testCapacidadMaximaAlcanzada() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente1 = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        Cliente cliente2 = new Cliente("Isa Fernández", "44444444D", 27, Persona.Sexo.MUJER,
                "C004", Cliente.TipoMembresia.VIP, 300.0, true);
        int capacidadMaxima = 2;
        clase.agregarCliente(cliente1, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.PRINCIPIANTE);
        clase.agregarCliente(cliente2, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.PRINCIPIANTE);
        assertThrows(CapacidadMaximaException.class, () -> {
            if (clase.getListClientes().size() >= capacidadMaxima) {
                throw new CapacidadMaximaException();
            }
        });
    }

    @Test
    public void testAgregarClienteDuplicado() {
        Clase clase = new Clase(1, "Yoga Matutino", true, "Clase de prueba", Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE, 60, 15.0, new ArrayList<>(), new HashSet<>());
        Cliente cliente = new Cliente("Nacho Torres", "33333333C", 22, Persona.Sexo.HOMBRE,
                "C003", Cliente.TipoMembresia.BASICA, 100.0, true);
        clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.PRINCIPIANTE);
        boolean resultado = clase.agregarCliente(cliente, Entrenador.Especialidad.YOGA,
                Clase.NivelDificultad.PRINCIPIANTE);
        assertFalse(resultado);
    }
}