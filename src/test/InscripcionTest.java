package test;

import Excepciones.ClienteNoEncontradoException;
import Excepciones.PagoYaRealizadoException;
import org.junit.jupiter.api.Test;
import personas.Cliente;
import personas.Persona;
import servicios.Cuota;
import servicios.Inscripcion;
import static org.junit.jupiter.api.Assertions.*;

// Tests de la clase Inscripcion
public class InscripcionTest {

    // Metodo auxiliar para limpiar las listas estáticas entre tests
    private void limpiarListas() {
        Inscripcion.getListaInscripciones().clear();
        Inscripcion.getConjuntoInscripciones().clear();
    }

    // Test que comprueba que agregarInscripcion() añade la inscripción correctamente
    @Test
    public void testAgregarInscripcionCorrectamente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", false);
        boolean resultado = gestora.agregarInscripcion(ins);
        assertTrue(resultado);
        assertEquals(1, Inscripcion.getListaInscripciones().size());
    }

    // Test que comprueba que buscarPorDNI() encuentra la inscripción correcta
    @Test
    public void testBuscarInscripcionPorDNIExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        Inscripcion encontrada = gestora.buscarPorDNI("55555555E");
        assertNotNull(encontrada);
        assertEquals("INS001", encontrada.getIdInscripcion());
    }

    // Test que comprueba que modificarCuota() cambia la cuota de la inscripción correctamente
    @Test
    public void testModificarCuota() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota1 = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Cuota cuota2 = new Cuota(2, "Plan Anual", true, Cuota.Periodo.ANUAL, 300.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota1, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean modificado = gestora.modificarCuota("55555555E", cuota2);
        assertTrue(modificado);
        assertEquals(cuota2, gestora.buscarPorDNI("55555555E").getCuota());
    }

    // Test que comprueba que modificarEstadoPago() actualiza el estado de pago correctamente
    @Test
    public void testModificarEstadoPago() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean resultado = gestora.modificarEstadoPago("55555555E", true);
        assertTrue(resultado);
        assertTrue(gestora.buscarPorDNI("55555555E").isPagado());
    }

    // Test que comprueba que eliminarInscripcionPorDNI() borra la inscripción correctamente
    @Test
    public void testEliminarInscripcion() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean eliminado = gestora.eliminarInscripcionPorDNI("55555555E");
        assertTrue(eliminado);
        assertEquals(0, Inscripcion.getListaInscripciones().size());
    }

    // Test que comprueba que se pueden agregar dos inscripciones de clientes distintos
    @Test
    public void testAgregarDosInscripciones() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente1 = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cliente cliente2 = new Cliente("Terry Gómez", "66666666F", 32, Persona.Sexo.MUJER,
                "C006", Cliente.TipoMembresia.VIP, 500.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins1 = new Inscripcion(1, "Ins001", true, "INS001", cliente1, cuota, "2025-01-01", false);
        Inscripcion ins2 = new Inscripcion(2, "Ins002", true, "INS002", cliente2, cuota, "2025-02-01", false);
        gestora.agregarInscripcion(ins1);
        gestora.agregarInscripcion(ins2);
        assertEquals(2, Inscripcion.getListaInscripciones().size());
    }

    // TEST NEGATIVO: agregar una inscripción con el mismo DNI debe devolver false
    @Test
    public void testAgregarInscripcionDuplicada() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins1 = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", false);
        Inscripcion ins2 = new Inscripcion(3, "Ins003", true, "INS003", cliente, cuota, "2025-03-01", false);
        gestora.agregarInscripcion(ins1);
        boolean resultado = gestora.agregarInscripcion(ins2);
        assertFalse(resultado);
    }

    // TEST NEGATIVO: buscar por DNI inexistente debe lanzar ClienteNoEncontradoException
    @Test
    public void testBuscarDNINoExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        assertThrows(ClienteNoEncontradoException.class, () -> {
            Inscripcion encontrada = gestora.buscarPorDNI("00000000Z");
            if (encontrada == null) {
                throw new ClienteNoEncontradoException("00000000Z");
            }
        });
    }

    // TEST NEGATIVO: intentar pagar una inscripción ya pagada debe lanzar PagoYaRealizadoException
    @Test
    public void testPagarInscripcionYaPagada() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, Cuota.Periodo.MENSUAL, 30.0);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "INS001", cliente, cuota, "2025-01-01", true);
        gestora.agregarInscripcion(ins);
        assertThrows(PagoYaRealizadoException.class, () -> {
            Inscripcion encontrada = gestora.buscarPorDNI("55555555E");
            if (encontrada != null && encontrada.isPagado()) {
                throw new PagoYaRealizadoException(encontrada.getIdInscripcion());
            }
        });
    }

    // TEST NEGATIVO: eliminar una inscripción con DNI inexistente debe devolver false
    @Test
    public void testEliminarInscripcionNoExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        boolean resultado = gestora.eliminarInscripcionPorDNI("99999999Z");
        assertFalse(resultado);
    }

    // TEST NEGATIVO: agregar una inscripción null debe devolver false
    @Test
    public void testAgregarInscripcionNull() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        boolean resultado = gestora.agregarInscripcion(null);
        assertFalse(resultado);
    }
}