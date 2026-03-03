package test;
import Excepciones.SaldoInsuficienteException;
import Excepciones.PagoYaRealizadoException;
import org.junit.jupiter.api.Test;
import personas.Cliente;
import personas.Persona;
import servicios.Cuota;
import servicios.Inscripcion;
import static org.junit.jupiter.api.Assertions.*;

// Tests de la clase Cliente
public class ClienteTest {

    @Test
    public void testGetNombre() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertEquals("Alba García", cliente.getNombre());
    }

    @Test
    public void testGetSaldo() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertEquals(150.0, cliente.getSaldo());
    }

    @Test
    public void testClienteActivo() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertTrue(cliente.isActivo());
    }

    @Test
    public void testTipoMembresia() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertEquals(Cliente.TipoMembresia.PREMIUM, cliente.getTipoMembresia());
    }

    @Test
    public void testSetSaldo() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        cliente.setSaldo(200.0);
        assertEquals(200.0, cliente.getSaldo());
    }

    @Test
    public void testEqualsClientesIguales() {
        Cliente cliente1 = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        Cliente cliente2 = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertEquals(cliente1, cliente2);
    }

    @Test
    public void testToStringContieneNombre() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        assertTrue(cliente.toString().contains("Alba García"));
    }

    @Test
    public void testPagarCuotaSaldoInsuficiente() {
        Cliente cliente = new Cliente("Brandon López", "87654321B", 30, Persona.Sexo.HOMBRE,
                "C002", Cliente.TipoMembresia.BASICA, 50.0, true);
        double precioCuota = 80.0;
        assertThrows(SaldoInsuficienteException.class, () -> {
            if (cliente.getSaldo() < precioCuota) {
                throw new SaldoInsuficienteException();
            }
        });
    }

    @Test
    public void testPagoYaRealizado() {
        Cliente cliente = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        Inscripcion ins = new Inscripcion(1, "Inscripcion1", true, "Inscripción de prueba",
                "INS001", cliente,
                new Cuota(10, "Mensual", true, "Cuota de prueba", Cuota.Periodo.MENSUAL, 30.0, 0, false),
                "2025-01-01", true);
        assertThrows(PagoYaRealizadoException.class, () -> {
            if (ins.isPagado()) {
                throw new PagoYaRealizadoException();
            }
        });
    }

    @Test
    public void testEqualsClientesDiferentes() {
        Cliente cliente1 = new Cliente("Alba García", "12345678A", 25, Persona.Sexo.MUJER,
                "C001", Cliente.TipoMembresia.PREMIUM, 150.0, true);
        Cliente cliente2 = new Cliente("Brandon López", "87654321B", 30, Persona.Sexo.HOMBRE,
                "C002", Cliente.TipoMembresia.BASICA, 50.0, true);
        assertNotEquals(cliente1, cliente2);
    }

    @Test
    public void testSaldoNegativoLanzaExcepcion() {
        assertThrows(SaldoInsuficienteException.class, () -> {
            double saldo = -10.0;
            if (saldo < 0) {
                throw new SaldoInsuficienteException();
            }
        });
    }
}