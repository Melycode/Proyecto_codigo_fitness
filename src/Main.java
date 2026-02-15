import personas.Entrenador;
import personas.Persona;
import personas.Cliente;
import servicios.Clase;
import servicios.Cuota;
import servicios.Inscripcion;
import servicios.Maquina;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Inscripcion gestor = new Inscripcion();

        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, Cuota.Periodo.MENSUAL, 45.0);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, Cuota.Periodo.ANUAL, 400.0);

        Cliente c1 = new Cliente("Milan Gutiérrez", "123456789A", 19, Persona.Sexo.HOMBRE, "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutiérrez", "987654321B", 18, Persona.Sexo.MUJER, "CLI-02", Cliente.TipoMembresia.BASICA, 50.0, true);

        Inscripcion i1 = new Inscripcion(1, "Inscripción 1", true, "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(2, "Inscripción 2", true, "INS-002", c2, cuotaAnual, "2026-02-15", false);

        System.out.println(gestor.agregarInscripcion(i1) ?
                i1.getCliente().getNombre() + " ha sido inscrito." :
                i1.getCliente().getNombre() + " ya está inscrito.");

        System.out.println(gestor.agregarInscripcion(i2) ?
                i2.getCliente().getNombre() + " ha sido inscrita." :
                i2.getCliente().getNombre() + " ya está inscrita.");

        System.out.println(gestor.agregarInscripcion(i1) ?
                i1.getCliente().getNombre() + " ha sido inscrito." :
                i1.getCliente().getNombre() + " ya está inscrito.");



        String dniBuscar = c1.getDni();
        Inscripcion buscada = gestor.buscarPorDNI(dniBuscar);
        System.out.println(buscada != null ? "Inscripción encontrada: " + buscada :
                "Cliente con DNI " + dniBuscar + " aún no está inscrito.");



        gestor.modificarEstadoPago(c1.getDni(), true);
        System.out.println("Después de pagar: " + i1);


        gestor.modificarCuota(c2.getDni(), cuotaMensual);
        System.out.println("Después de cambiar plan: " + i2);


        gestor.eliminarInscripcionPorDNI(c1.getDni());
        System.out.println("Lista después de eliminar inscripción de " + c1.getNombre() + ":");
        for (Inscripcion ins : Inscripcion.getListaInscripciones()) {
            System.out.println(ins);
        }


        Inscripcion eliminada = gestor.buscarPorDNI(c1.getDni());
        System.out.println(eliminada == null ? c1.getNombre() + " ya no está inscrito." : "Error: " + c1.getNombre() + " sigue en la lista.");
    }
}
