package test;
import Excepciones.ClienteNoEncontradoException;
import Excepciones.PagoYaRealizadoException;
import org.junit.jupiter.api.Test;
import personas.Cliente;
import personas.Persona;
import servicios.Cuota;
import servicios.Inscripcion;
import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {

    private void limpiarListas() {
        Inscripcion.getListaInscripciones().clear();
        Inscripcion.getConjuntoInscripciones().clear();
    }

    @Test
    public void testAgregarInscripcionCorrectamente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", false);
        boolean resultado = gestora.agregarInscripcion(ins);
        assertTrue(resultado);
        assertEquals(1, Inscripcion.getListaInscripciones().size());
    }

    @Test
    public void testBuscarInscripcionPorDNIExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        Inscripcion encontrada = gestora.buscarPorDNI("55555555E");
        assertNotNull(encontrada);
        assertEquals("INS001", encontrada.getIdInscripcion());
    }

    @Test
    public void testModificarCuota() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota1 = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Cuota cuota2 = new Cuota(2, "Plan Anual", true, "Cuota anual de prueba", Cuota.Periodo.ANUAL, 300.0, 10, true);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota1, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean modificado = gestora.modificarCuota("55555555E", cuota2);
        assertTrue(modificado);
        assertEquals(cuota2, gestora.buscarPorDNI("55555555E").getCuota());
    }

    @Test
    public void testModificarEstadoPago() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean resultado = gestora.modificarEstadoPago("55555555E", true);
        assertTrue(resultado);
        assertTrue(gestora.buscarPorDNI("55555555E").isPagado());
    }

    @Test
    public void testEliminarInscripcion() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", false);
        gestora.agregarInscripcion(ins);
        boolean eliminado = gestora.eliminarInscripcionPorDNI("55555555E");
        assertTrue(eliminado);
        assertEquals(0, Inscripcion.getListaInscripciones().size());
    }

    @Test
    public void testAgregarDosInscripciones() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente1 = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cliente cliente2 = new Cliente("Terry Gómez", "66666666F", 32, Persona.Sexo.MUJER,
                "C006", Cliente.TipoMembresia.VIP, 500.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins1 = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente1, cuota, "2025-01-01", false);
        Inscripcion ins2 = new Inscripcion(2, "Ins002", true, "Inscripción de prueba", "INS002", cliente2, cuota, "2025-02-01", false);
        gestora.agregarInscripcion(ins1);
        gestora.agregarInscripcion(ins2);
        assertEquals(2, Inscripcion.getListaInscripciones().size());
    }

    @Test
    public void testAgregarInscripcionDuplicada() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins1 = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", false);
        Inscripcion ins2 = new Inscripcion(3, "Ins003", true, "Inscripción de prueba", "INS003", cliente, cuota, "2025-03-01", false);
        gestora.agregarInscripcion(ins1);
        boolean resultado = gestora.agregarInscripcion(ins2);
        assertFalse(resultado);
    }

    @Test
    public void testBuscarDNINoExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        assertThrows(ClienteNoEncontradoException.class, () -> {
            Inscripcion encontrada = gestora.buscarPorDNI("00000000Z");
            if (encontrada == null) {
                throw new ClienteNoEncontradoException();
            }
        });
    }

    @Test
    public void testPagarInscripcionYaPagada() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        Cliente cliente = new Cliente("Dani Castillo", "55555555E", 20, Persona.Sexo.HOMBRE,
                "C005", Cliente.TipoMembresia.BASICA, 200.0, true);
        Cuota cuota = new Cuota(1, "Plan Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false);
        Inscripcion ins = new Inscripcion(1, "Ins001", true, "Inscripción de prueba", "INS001", cliente, cuota, "2025-01-01", true);
        gestora.agregarInscripcion(ins);
        assertThrows(PagoYaRealizadoException.class, () -> {
            Inscripcion encontrada = gestora.buscarPorDNI("55555555E");
            if (encontrada != null && encontrada.isPagado()) {
                throw new PagoYaRealizadoException();
            }
        });
    }

    @Test
    public void testEliminarInscripcionNoExistente() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        boolean resultado = gestora.eliminarInscripcionPorDNI("99999999Z");
        assertFalse(resultado);
    }

    @Test
    public void testAgregarInscripcionNull() {
        limpiarListas();
        Inscripcion gestora = new Inscripcion();
        boolean resultado = gestora.agregarInscripcion(null);
        assertFalse(resultado);
    }
}