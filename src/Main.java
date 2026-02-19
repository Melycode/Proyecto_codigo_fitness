import personas.*;
import servicios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Inscripcion gestor = new Inscripcion();
        Empleado empleado1 = new Empleado("Melissa Guerrero", "50302218M", 46, Persona.Sexo.MUJER, Empleado.Turno.TARDE, 1760.0, "12-02-2018", true, new ArrayList<>());
        Empleado empleado2 = new Empleado("Diego Pérez", "40236607D", 40, Persona.Sexo.HOMBRE, Empleado.Turno.MANANA, 1800.0, "06-12-2022",true, new ArrayList<>());

        Entrenador entrenador1 = new Entrenador("Manuel Ruiz", "49166034S", 35, Persona.Sexo.HOMBRE, Entrenador.Especialidad.YOGA, 15, true, 150.0, new ArrayList<>());
        Entrenador entrenador2 = new Entrenador("Maria Montero", "16604934T", 28, Persona.Sexo.MUJER, Entrenador.Especialidad.MUSCULACION, 5, true, 100.0, new ArrayList<>());

        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, Cuota.Periodo.MENSUAL, 45.0);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, Cuota.Periodo.ANUAL, 400.0);

        Cliente c1 = new Cliente("Milan Gutiérrez", "123456789A", 19, Persona.Sexo.HOMBRE, "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutiérrez", "987654321B", 18, Persona.Sexo.MUJER, "CLI-02", Cliente.TipoMembresia.BASICA, 50.0, true);

        Inscripcion i1 = new Inscripcion(1, "Inscripción 1", true, "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(2, "Inscripción 2", true, "INS-002", c2, cuotaAnual, "2026-02-15", false);

        Recepcionista r1 = new Recepcionista("Napoleón", "77975690D", 51, Persona.Sexo.HOMBRE, 3, "Francés", true, 150.0);
        Recepcionista r2 = new Recepcionista("Barney", "77975690F", 69, Persona.Sexo.OTRO, 2, "Inglés", false, 300.0);

        Maquina maquina1 =new Maquina(01, "Musculación", true, "Multiestación Homcom1", Maquina.EstadoMaquina.OPERATIVA, 175.0, false,  new HashMap<LocalDate, Maquina.EstadoMaquina>());
        Maquina maquina2 = new  Maquina(02, "Musculación", true, "Prensa piernas", Maquina.EstadoMaquina.AVERIADA, 315.0, false, new HashMap<LocalDate, Maquina.EstadoMaquina>());


        Clase clase1 = new Clase(03, "Talleres", true, personas.Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.50);
        Clase clase2 =  new Clase(04, "Musculación", true, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.50);

        Reserva reserva1 = new Reserva(1, "Musculacion", true, c1, clase1, "10-02-2026", true );
        Reserva reserva2 = new Reserva(2, "Yoga", true, c2, clase2, "11-02-2026",true);




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

        System.out.println("-------------PRUEBA RECEPCIONISTA------------");
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.agregarCuota(c1, cuotaMensual);
        recepcionista.agregarCuota(c2, cuotaAnual);

        System.out.println("--- Historial de " + c1.getNombre() + " ---");
        ArrayList<Cuota> historialMilan = recepcionista.buscarHistorial(c1.getDni());
        if (historialMilan != null) {
            historialMilan.forEach(cuota -> System.out.println(cuota));
        }

    }

}
