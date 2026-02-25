package test;

import org.junit.jupiter.api.Test;
import personas.Empleado;
import personas.Persona;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void testGetNombre() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        assertEquals("Melissa Ruiz", empleado.getNombre());
    }

    @Test
    public void testGetSalario() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        assertEquals(1800.0, empleado.getSalario());
    }

    @Test
    public void testEmpleadoActivo() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        assertTrue(empleado.isActivo());
    }

    @Test
    public void testAgregarTurno() {
        Empleado empleado = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        empleado.agregarTurno(Empleado.Turno.NOCHE);
        assertTrue(empleado.haTrabajadoEnTurno(Empleado.Turno.NOCHE));
    }

    @Test
    public void testHaTrabajadoEnTurno() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        historial.add(Empleado.Turno.TARDE);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        assertTrue(empleado.haTrabajadoEnTurno(Empleado.Turno.MANANA));
    }

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

    @Test
    public void testBorrarTurnoIndiceInvalido() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado.Turno resultado = empleado.borrarTurno(999);
        assertNull(resultado);
    }

    @Test
    public void testModificarTurnoIndiceInvalido() {
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado.Turno resultado = empleado.modificarTurno(-1, Empleado.Turno.NOCHE);
        assertNull(resultado);
    }

    @Test
    public void testReemplazarTurnoNullDevuelveCero() {
        ArrayList<Empleado.Turno> historial = new ArrayList<>();
        historial.add(Empleado.Turno.MANANA);
        Empleado empleado = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, historial);
        int resultado = empleado.reemplazarTurno(null, Empleado.Turno.NOCHE);
        assertEquals(0, resultado);
    }

    @Test
    public void testBuscarTurnoNoExistente() {
        Empleado empleado = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        int indice = empleado.buscarPrimerTurno(Empleado.Turno.MANANA);
        assertEquals(-1, indice);
    }

    @Test
    public void testEqualsEmpleadosDiferentes() {
        Empleado empleado1 = new Empleado("Melissa Ruiz", "11111111A", 28, Persona.Sexo.MUJER,
                Empleado.Turno.MANANA, 1800.0, "2023-03-01", true, new ArrayList<>());
        Empleado empleado2 = new Empleado("Carlos Pérez", "22222222B", 35, Persona.Sexo.HOMBRE,
                Empleado.Turno.TARDE, 2000.0, "2022-06-15", true, new ArrayList<>());
        assertNotEquals(empleado1, empleado2);
    }
}
