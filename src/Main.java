import interfaz.CalculadoraIMC;
import json.GestorJSON;
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
        System.out.println(empleado1);
        System.out.println(empleado2);

        Entrenador entrenador1 = new Entrenador("Manuel Ruiz", "49166034S", 35, Persona.Sexo.HOMBRE, Entrenador.Especialidad.YOGA, 15, true, 150.0, new ArrayList<>());
        Entrenador entrenador2 = new Entrenador("Maria Montero", "16604934T", 28, Persona.Sexo.MUJER, Entrenador.Especialidad.MUSCULACION, 5, true, 100.0, new ArrayList<>());
        System.out.println(entrenador1);
        System.out.println(entrenador2);

        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, "Plan mensual básico", Cuota.Periodo.MENSUAL, 45.0, 0, true);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, "Plan anual premium", Cuota.Periodo.ANUAL, 400.0, 10, true);
        System.out.println(cuotaMensual);
        System.out.println(cuotaAnual);

        Cliente c1 = new Cliente("Milan Gutiérrez", "123456789A", 19, Persona.Sexo.HOMBRE, "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutiérrez", "987654321B", 18, Persona.Sexo.MUJER, "CLI-02", Cliente.TipoMembresia.BASICA, 50.0, true);
        System.out.println(c1);
        System.out.println(c2);


        Inscripcion i1 = new Inscripcion(1, "Inscripción 1", true, "Inscripción mensual de Milan", "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(2, "Inscripción 2", true, "Inscripción anual de Akemi", "INS-002", c2, cuotaAnual, "2026-02-15", false);


        Recepcionista r1 = new Recepcionista("Napoleón", "77975690D", 51, Persona.Sexo.HOMBRE, 3, "Francés", true, 150.0);
        Recepcionista r2 = new Recepcionista("Barney", "77975690F", 69, Persona.Sexo.OTRO, 2, "Inglés", false, 300.0);

        Maquina maquina1 = new Maquina(01, "Musculación", true, "Máquina de musculación", "Multiestación Homcom1", Maquina.EstadoMaquina.OPERATIVA, 175.0, false, new HashMap<LocalDate, Maquina.EstadoMaquina>());
        Maquina maquina2 = new Maquina(02, "Musculación", true, "Prensa de piernas", "Prensa piernas", Maquina.EstadoMaquina.AVERIADA, 315.0, false, new HashMap<LocalDate, Maquina.EstadoMaquina>());
        System.out.println(maquina1);
        System.out.println(maquina2);

        Clase clase1 = new Clase(03, "Talleres", true, "Clase de yoga", Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.50, new ArrayList<>(), new HashSet<>());
        Clase clase2 = new Clase(04, "Musculación", true, "Clase de musculación", Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.50, new ArrayList<>(), new HashSet<>());
        System.out.println(clase1);
        System.out.println(clase2);


        Reserva reserva1 = new Reserva(1, "Musculacion", true, "Reserva de clase de musculación", c1, clase1, "10-02-2026", true);
        Reserva reserva2 = new Reserva(2, "Yoga", true, "Reserva de clase de yoga", c2, clase2, "11-02-2026", true);
        System.out.println(reserva1);
        System.out.println(reserva2);



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
        System.out.println(r1);
        System.out.println(r2);
        r1.agregarCuota(c1, cuotaMensual);
        r1.agregarCuota(c2, cuotaAnual);

        System.out.println("--- Historial de " + c1.getNombre() + " ---");
        ArrayList<Cuota> historialMilan = r1.buscarHistorial(c1.getDni());
        if (historialMilan != null) {
            historialMilan.forEach(cuota -> System.out.println(cuota));
        }

        System.out.println("------------- PRUEBA ENTRENADOR ------------");
    // asignarClase (no devuelve nada)
        entrenador1.asignarClase(clase1);
        System.out.println("Tras asignarClase): " + entrenador1);

    // anadirClase (devuelve boolean)
        System.out.println("Añadir clase2 a entrenador1: " + entrenador1.anadirClase(clase2));
        System.out.println("Tras anadirClase: " + entrenador1);

        // buscarClase
        int indice = entrenador1.buscarClase(clase1);
        System.out.println("Índice de clase1 en entrenador1: " + indice);
        System.out.println("Índice de clase no existente: " + entrenador1.buscarClase(new Clase(99, "Test", false, "Clase de prueba", Entrenador.Especialidad.CARDIO, Clase.NivelDificultad.INTERMEDIO, 45, 10.0, new ArrayList<>(), new HashSet<>())));

        // modificarClase
        Clase claseNueva = new Clase(05, "Cardio", true, "Clase de cardio", Entrenador.Especialidad.CARDIO, Clase.NivelDificultad.AVANZADO, 45, 20.0, new ArrayList<>(), new HashSet<>());
        System.out.println("Modificar clase en índice 0: " + entrenador1.modificarClase(0, claseNueva));
        System.out.println("Modificar índice inválido (-1): " + entrenador1.modificarClase(-1, claseNueva));
        System.out.println("Tras modificarClase: " + entrenador1);

        // borrarClase
        System.out.println("Borrar clase: " + entrenador1.borrarClase(clase2));
        System.out.println("Borrar clase de nuevo: " + entrenador1.borrarClase(clase2));

        System.out.println("------------- PRUEBA EMPLEADO ------------");

    // agregarTurno y anadirTurno
        empleado1.agregarTurno(Empleado.Turno.MANANA);
        empleado1.agregarTurno(Empleado.Turno.TARDE);
        empleado1.agregarTurno(Empleado.Turno.MANANA);
        empleado1.anadirTurno(Empleado.Turno.NOCHE);
        empleado1.anadirTurno(null);
        System.out.println("Historial tras agregar turnos: " + empleado1.getHistorialTurnos());

    // haTrabajadoEnTurno
        System.out.println("¿Ha trabajado en mañana? " + empleado1.haTrabajadoEnTurno(Empleado.Turno.MANANA));
        System.out.println("¿Ha trabajado en tarde? " + empleado1.haTrabajadoEnTurno(Empleado.Turno.TARDE));

    // buscarPrimerTurno y buscarUltimoTurno
        System.out.println("Primer turno de mañana: " + empleado1.buscarPrimerTurno(Empleado.Turno.MANANA));
        System.out.println("Último turno de mañana: " + empleado1.buscarUltimoTurno(Empleado.Turno.MANANA));

    // modificarTurno
        Empleado.Turno anterior = empleado1.modificarTurno(0, Empleado.Turno.NOCHE);
        System.out.println("Turno reemplazado en turno 0: " + anterior);
        System.out.println("Modificar turno inválido: " + empleado1.modificarTurno(-1, Empleado.Turno.TARDE));
        System.out.println("Historial tras modificar: " + empleado1.getHistorialTurnos());

    // reemplazarTurno
        int reemplazados = empleado1.reemplazarTurno(Empleado.Turno.MANANA, Empleado.Turno.TARDE);
        System.out.println("Turnos mañana reemplazados por tarde: " + reemplazados);
        System.out.println("Reemplazar turno con null: " + empleado1.reemplazarTurno(null, Empleado.Turno.TARDE));
        System.out.println("Historial tras reemplazar: " + empleado1.getHistorialTurnos());

    // borrarTurno por índice
        Empleado.Turno borrado = empleado1.borrarTurno(0);
        System.out.println("Turno borrado en índice 0: " + borrado);
        System.out.println("borrarTurno índice inválido: " + empleado1.borrarTurno(99));
        System.out.println("Historial tras borrar índice: " + empleado1.getHistorialTurnos());

    // borrarTodosTurnos
        empleado1.agregarTurno(Empleado.Turno.TARDE);
        empleado1.agregarTurno(Empleado.Turno.TARDE);
        int borradosTodos = empleado1.borrarTodosTurnos(Empleado.Turno.TARDE);
        System.out.println("Turnos tarde eliminados: " + borradosTodos);
        System.out.println("Historial tras borrar todos los turnos: " + empleado1.getHistorialTurnos());

    // interfaz gráfica

                CalculadoraIMC calculadora = new CalculadoraIMC();
                calculadora.setVisible(true);

                // ---- GESTOR JSON ----

// Escribir inscripciones en el archivo JSON
        System.out.println("--- Guardando inscripciones en JSON ---");
        GestorJSON.escribirInscripciones(Inscripcion.getListaInscripciones());

// Leer inscripciones desde el archivo JSON
        System.out.println("--- Leyendo inscripciones desde JSON ---");
        ArrayList<Inscripcion> inscripcionesLeidas = GestorJSON.leerInscripciones();
        for (Inscripcion ins : inscripcionesLeidas) {
            System.out.println(ins);
        }
    }
}



