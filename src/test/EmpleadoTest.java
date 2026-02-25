import org.junit.jupiter.api.Test;
import personas.Empleado;
import personas.Persona;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

// Tests de la clase Empleado
public class EmpleadoTest {

    // Test que comprueba que getNombre() devuelve el nombre correcto
    @Test
    public void testGetNombre() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        assertEquals("Melissa Ruiz", empleado.getNombre());
    }

    // Test que comprueba que getSalario() devuelve el salario correcto
    @Test
    public void testGetSalario() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        assertEquals(1800.0, empleado.getSalario());
    }

    // Test que comprueba que el empleado está activo al crearlo con activo=true
    @Test
    public void testEmpleadoActivo() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        assertTrue(empleado.isActivo());
    }

    // Test que comprueba que agregarTurno() añade el turno correctamente al historial
    @Test
    public void testAgregarTurno() {
        Empleado empleado = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        empleado.agregarTurno(Empleado.Turno.NOCHE);
        assertTrue(empleado.haTrabajadoEnTurno(Empleado.Turno.NOCHE));
    }

    // Test que comprueba que haTrabajadoEnTurno() devuelve true si el turno existe en el historial
    @Test
    public void testHaTrabajadoEnTurno() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        historial.add(Empleado.Turno.TARDE);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        assertTrue(empleado.haTrabajadoEnTurno(Empleado.Turno.MANANA));
    }

    // Test que comprueba que borrarTurno() elimina el turno en el índice indicado
    @Test
    public void testBorrarTurno() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        historial.add(Empleado.Turno.TARDE);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        empleado.borrarTurno(0);
        assertFalse(empleado.haTrabajadoEnTurno(Empleado.Turno.MANANA));
    }

    // Test que comprueba que reemplazarTurno() sustituye el turno antiguo por el nuevo
    @Test
    public void testReemplazarTurno() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        historial.add(Empleado.Turno.TARDE);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        int reemplazados = empleado.reemplazarTurno(Empleado.Turno.TARDE, Empleado.Turno.NOCHE);
        assertEquals(1, reemplazados);
        assertTrue(empleado.haTrabajadoEnTurno(Empleado.Turno.NOCHE));
    }

    // TEST NEGATIVO: borrar con índice fuera de rango debe devolver null
    @Test
    public void testBorrarTurnoIndiceInvalido() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado.Turno resultado = empleado.borrarTurno(999);
        assertNull(resultado);
    }

    // TEST NEGATIVO: modificar con índice negativo debe devolver null
    @Test
    public void testModificarTurnoIndiceInvalido() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado.Turno resultado = empleado.modificarTurno(-1, Empleado.Turno.NOCHE);
        assertNull(resultado);
    }

    // TEST NEGATIVO: reemplazar con null debe devolver 0 sin modificar nada
    @Test
    public void testReemplazarTurnoNullDevuelveCero() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        int resultado = empleado.reemplazarTurno(null, Empleado.Turno.NOCHE);
        assertEquals(0, resultado);
    }

    // TEST NEGATIVO: buscar un turno que no existe en el historial debe devolver -1
    @Test
    public void testBuscarTurnoNoExistente() {
        Empleado empleado = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        int indice = empleado.buscarPrimerTurno(Empleado.Turno.MANANA);
        assertEquals(-1, indice);
    }

    // TEST NEGATIVO: dos empleados con datos distintos no deben ser iguales
    @Test
    public void testEqualsEmpleadosDiferentes() {
        Empleado empleado1 = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado empleado2 = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        assertNotEquals(empleado1, empleado2);
    }
}