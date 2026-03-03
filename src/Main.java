import Excepciones.*;
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

        // ==========================================================
        // 1. CREACIÓN DE OBJETOS (Mínimo 2 por clase hija)
        // ==========================================================

        // --- Clientes ---
        Cliente c1 = new Cliente("Milan Gutierrez", "12345678A", 19, Persona.Sexo.HOMBRE, "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutierrez", "98765432B", 18, Persona.Sexo.MUJER, "CLI-02", Cliente.TipoMembresia.BASICA, 20.0, true);

        // --- Empleados ---
        Empleado e1 = new Empleado("Melissa Guerrero", "50302218M", 46, Persona.Sexo.MUJER, Empleado.Turno.TARDE, 1760.0, "12-02-2018", true, new ArrayList<>());
        Empleado e2 = new Empleado("Diego Perez", "40236607D", 40, Persona.Sexo.HOMBRE, Empleado.Turno.MANANA, 1800.0, "06-12-2022", true, new ArrayList<>());

        // --- Entrenadores ---
        Entrenador ent1 = new Entrenador("Manuel Ruiz", "49166034S", 35, Persona.Sexo.HOMBRE, Entrenador.Especialidad.YOGA, 15, true, 150.0, new ArrayList<>());
        Entrenador ent2 = new Entrenador("Maria Montero", "16604934T", 28, Persona.Sexo.MUJER, Entrenador.Especialidad.MUSCULACION, 5, true, 100.0, new ArrayList<>());

        // --- Recepcionistas ---
        Recepcionista r1 = new Recepcionista("Napoleon", "77975690D", 51, Persona.Sexo.HOMBRE, 3, "Frances", true, 150.0);
        Recepcionista r2 = new Recepcionista("Barney", "77975691F", 69, Persona.Sexo.OTRO, 2, "Ingles", false, 300.0);

        // --- Cuotas ---
        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, "Mensual basico", Cuota.Periodo.MENSUAL, 45.0, 0, true);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, "Anual premium", Cuota.Periodo.ANUAL, 400.0, 10, true);

        // --- Maquinas ---
        Maquina maq1 = new Maquina(10, "Cardio", true, "Cinta pro", "Cinta Correr X", Maquina.EstadoMaquina.OPERATIVA, 175.0, false, new HashMap<>());
        Maquina maq2 = new Maquina(11, "Musculacion", true, "Prensa", "Prensa 45 grad", Maquina.EstadoMaquina.AVERIADA, 315.0, true, new HashMap<>());

        // --- Clases ---
        Clase clase1 = new Clase(20, "Yoga Flow", true, "Relajacion", Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.5, new ArrayList<>(), new HashSet<>());
        Clase clase2 = new Clase(21, "Power Lift", true, "Fuerza", Entrenador.Especialidad.MUSCULACION, Clase.NivelDificultad.AVANZADO, 60, 20.0, new ArrayList<>(), new HashSet<>());

        // --- Reservas ---
        Reserva res1 = new Reserva(100, "Reserva 1", true, "Cita mañana", c1, clase1, "10-02-2026", true);
        Reserva res2 = new Reserva(101, "Reserva 2", true, "Cita tarde", c2, clase2, "11-02-2026", false);

        // --- Inscripciones ---
        Inscripcion i1 = new Inscripcion(300, "Inscripcion Milan", true, "Plan Mensual", "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(301, "Inscripcion Akemi", true, "Plan Anual", "INS-002", c2, cuotaAnual, "2026-02-15", false);


        // ==========================================================
        // 2. LÓGICA DE NEGOCIO Y ESTRUCTURAS DE CONTROL
        // ==========================================================

        System.out.println("\n>>> [SISTEMA CÓDIGO FITNESS] - INICIO DE OPERACIONES <<<\n");

        // --- Prueba de Bucles y Listas ---
        System.out.println("--- GESTIÓN DE PERSONAL ---");
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);

        for (Empleado emp : listaEmpleados) {
            System.out.println("-> Trabajador: " + emp.getNombre() + " | Turno: " + emp.getTurno());
        }

        // --- Prueba de Condicionales y Máquinas ---
        System.out.println("\n--- ESTADO DEL EQUIPAMIENTO ---");
        ArrayList<Maquina> inventario = new ArrayList<>();
        inventario.add(maq1);
        inventario.add(maq2);

        for (Maquina m : inventario) {
            if (m.getEstado() == Maquina.EstadoMaquina.AVERIADA) {
                System.out.println("[!] AVISO TÉCNICO: " + m.getNombreMaquina() + " está fuera de servicio.");
            } else {
                System.out.println("[OK] Equipo operativo: " + m.getNombreMaquina());
            }
        }

        // --- Gestión de Inscripciones (Uso de Gestora) ---
        System.out.println("\n--- REGISTRO DE CLIENTES ---");
        Inscripcion gestor = new Inscripcion();
        gestor.agregarInscripcion(i1);
        gestor.agregarInscripcion(i2);

        System.out.println("Buscando DNI " + c1.getDni() + ": " + gestor.buscarPorDNI(c1.getDni()));


        // ==========================================================
        // 3. PRUEBA DE EXCEPCIONES PERSONALIZADAS
        // ==========================================================

        System.out.println("\n--- MÓDULO DE SEGURIDAD Y PAGOS (Excepciones) ---");

        // 3.1. Saldo Insuficiente
        try {
            if (c2.getSaldo() < 50.0) {
                throw new SaldoInsuficienteException();
            }
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Error 01: " + ex.getMessage());
        }

        // 3.2. Pago Ya Realizado
        try {
            if (i1.isPagado()) {
                throw new PagoYaRealizadoException();
            }
        } catch (PagoYaRealizadoException ex) {
            System.out.println("Error 02: " + ex.getMessage());
        }

        // 3.3. Cliente No Encontrado
        try {
            if (gestor.buscarPorDNI("00000000Z") == null) {
                throw new ClienteNoEncontradoException();
            }
        } catch (ClienteNoEncontradoException ex) {
            System.out.println("Error 03: " + ex.getMessage());
        }

        // 3.4. Capacidad Máxima
        try {
            int maxCapacidad = 1;
            clase1.agregarCliente(c1, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO);
            if (clase1.getListClientes().size() >= maxCapacidad) {
                throw new CapacidadMaximaException();
            }
        } catch (CapacidadMaximaException ex) {
            System.out.println("Error 04: " + ex.getMessage());
        }


        // ==========================================================
        // 4. PERSISTENCIA DE DATOS (JSON)
        // ==========================================================

        System.out.println("\n--- RESPALDO DE DATOS (JSON) ---");
        GestorJSON.escribirInscripciones(Inscripcion.getListaInscripciones());

        ArrayList<Inscripcion> backup = GestorJSON.leerInscripciones();
        System.out.println("Inscripciones recuperadas:");
        for (int k = 0; k < backup.size(); k++) {
            System.out.println(" > " + backup.get(k).getCliente().getNombre());
        }


        // ==========================================================
        // 5. INTERFAZ GRÁFICA
        // ==========================================================

        System.out.println("\n>>> Ejecución finalizada. Abriendo Interfaz Gráfica...");

        // Se ejecuta la GUI
        new CalculadoraIMC();
    }
}