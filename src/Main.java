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
        // ==================== CREACIÓN DE OBJETOS ====================
        // Empleados
        Empleado empleado1 = new Empleado("Melissa Guerrero", "50302218M", 46,
                Persona.Sexo.MUJER,
                Empleado.Turno.TARDE, 1760.0, "12-02-2018", true, new ArrayList<>());
        Empleado empleado2 = new Empleado("Diego Pérez", "40236607D", 40,
                Persona.Sexo.HOMBRE,
                Empleado.Turno.MANANA, 1800.0, "06-12-2022", true, new ArrayList<>());

        // Entrenadores
        Entrenador entrenador1 = new Entrenador("Manuel Ruiz", "49166034S", 35,
                Persona.Sexo.HOMBRE,
                Entrenador.Especialidad.YOGA, 15, true, 150.0, new ArrayList<>());
        Entrenador entrenador2 = new Entrenador("Maria Montero", "16604934T", 28,
                Persona.Sexo.MUJER,
                Entrenador.Especialidad.MUSCULACION, 5, true, 100.0, new ArrayList<>());

        // Clientes
        Cliente c1 = new Cliente("Milan Gutiérrez", "123456789A", 19,
                Persona.Sexo.HOMBRE,
                "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutiérrez", "987654321B", 18, Persona.Sexo.MUJER,
                "CLI-02", Cliente.TipoMembresia.BASICA, 50.0, true);

        // Recepcionistas
        Recepcionista r1 = new Recepcionista("Napoleón", "77975690D", 51,
                Persona.Sexo.HOMBRE,
                3, "Francés", true, 150.0);
        Recepcionista r2 = new Recepcionista("Barney", "77975690F", 69,
                Persona.Sexo.OTRO,
                2, "Inglés", false, 300.0);

        // Cuotas
        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, "Plan mensual básico", Cuota.Periodo.MENSUAL, 45.0, 0, true);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, "Plan anual premium", Cuota.Periodo.ANUAL, 400.0, 10, true);

        // Inscripciones
        Inscripcion i1 = new Inscripcion(1, "Inscripción 1", true, "Inscripción mensual de Milan", "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(2, "Inscripción 2", true, "Inscripción anual de Akemi", "INS-002", c2, cuotaAnual, "2026-02-15", false);

        // Máquinas
        Maquina maquina1 = new Maquina(01, "Musculación", true, "Máquina de musculación", "Multiestación Homcom1", Maquina.EstadoMaquina.OPERATIVA, 175.0, false, new HashMap<LocalDate, Maquina.EstadoMaquina>());
        Maquina maquina2 = new Maquina(02, "Musculación", true, "Prensa de piernas", "Prensa piernas", Maquina.EstadoMaquina.AVERIADA, 315.0, false, new HashMap<LocalDate, Maquina.EstadoMaquina>());

    }
}



