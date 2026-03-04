import Excepciones.*;
import interfaz.CalculadoraIMC;
import json.GestorJSON;
import personas.*;
import servicios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // CREACIÓN DE OBJETOS

        //  Clientes
        Cliente c1 = new Cliente("Milan Gutierrez", "12345678A", 19, Persona.Sexo.HOMBRE, "CLI-01", Cliente.TipoMembresia.PREMIUM, 100.0, true);
        Cliente c2 = new Cliente("Akemi Gutierrez", "98765432B", 18, Persona.Sexo.MUJER, "CLI-02", Cliente.TipoMembresia.BASICA, 20.0, true);

        //  Empleados
        Empleado e1 = new Empleado("Melissa Guerrero", "50302218M", 46, Persona.Sexo.MUJER, Empleado.Turno.TARDE, 1760.0, "12-02-2018", true, new ArrayList<>());
        Empleado e2 = new Empleado("Diego Perez", "40236607D", 40, Persona.Sexo.HOMBRE, Empleado.Turno.MANANA, 1800.0, "06-12-2022", true, new ArrayList<>());

        //  Entrenadores
        Entrenador ent1 = new Entrenador("Manuel Ruiz", "49166034S", 35, Persona.Sexo.HOMBRE, Entrenador.Especialidad.YOGA, 15, true, 150.0, new ArrayList<>());
        Entrenador ent2 = new Entrenador("Maria Montero", "16604934T", 28, Persona.Sexo.MUJER, Entrenador.Especialidad.MUSCULACION, 5, true, 100.0, new ArrayList<>());

        //  Recepcionistas
        Recepcionista r1 = new Recepcionista("Napoleon", "77975690D", 51, Persona.Sexo.HOMBRE, 3, "Frances", true, 150.0);
        Recepcionista r2 = new Recepcionista("Barney", "77975691F", 69, Persona.Sexo.OTRO, 2, "Ingles", false, 300.0);

        //  Cuotas
        Cuota cuotaMensual = new Cuota(1, "Plan Fitness", true, "Mensual basico", Cuota.Periodo.MENSUAL, 45.0, 0, true);
        Cuota cuotaAnual = new Cuota(2, "Plan Oro", true, "Anual premium", Cuota.Periodo.ANUAL, 400.0, 10, true);

        //  Maquinas
        Maquina maq1 = new Maquina(10, "Cardio", true, "Cinta pro", "Cinta Correr X", Maquina.EstadoMaquina.OPERATIVA, 120.5, false, new HashMap<>());
        Maquina maq2 = new Maquina(11, "Musculacion", true, "Prensa", "Prensa 45 grad", Maquina.EstadoMaquina.AVERIADA, 315.0, true, new HashMap<>());

        //  Clases
        Clase clase1 = new Clase(20, "Yoga Flow", true, "Relajacion", Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO, 60, 15.5, new ArrayList<>(), new HashSet<>());
        Clase clase2 = new Clase(21, "Power Lift", true, "Fuerza", Entrenador.Especialidad.MUSCULACION, Clase.NivelDificultad.AVANZADO, 60, 20.0, new ArrayList<>(), new HashSet<>());

        //  Reservas
        Reserva res1 = new Reserva(100, "Reserva 1", true, "Cita mañana", c1, clase1, "10-02-2026", true);
        Reserva res2 = new Reserva(101, "Reserva 2", true, "Cita tarde", c2, clase2, "11-02-2026", false);

        // Inscripciones
        Inscripcion i1 = new Inscripcion(300, "Inscripcion Milan", true, "Plan Mensual", "INS-001", c1, cuotaMensual, "2026-02-15", true);
        Inscripcion i2 = new Inscripcion(301, "Inscripcion Akemi", true, "Plan Anual", "INS-002", c2, cuotaAnual, "2026-02-15", false);


        // INICIO DE LA PRESENTACIÓN EN CONSOLA
        System.out.println("***********************************************************");
        System.out.println("*             Welcome to CÓDIGO FITNESS                   *");
        System.out.println("***********************************************************");

        System.out.println("\nLISTADO DE PERSONAL");
        ArrayList<Empleado> personalGym = new ArrayList<>();
        personalGym.add(e1);
        personalGym.add(e2);

        for (int i = 0; i < personalGym.size(); i++) {
            System.out.println("Empleado " + (i+1) + ": " + personalGym.get(i).getNombre() + " | Turno: " + personalGym.get(i).getTurno());
        }

        // Condicionales y Métodos de Clase
        System.out.println("\nCONTROL DE MAQUINARIA");
        if (maq2.getEstado() == Maquina.EstadoMaquina.AVERIADA) {
            System.out.println("WARNING: La maquina " + maq2.getNombreMaquina() + " necesita reparación urgente.");
        }

        // Prueba de métodos: Añadir, Buscar, Modificar y Eliminar ---
        System.out.println("\nGESTIÓN INSCRIPCIONES");
        Inscripcion gestora = new Inscripcion();

        // Añadir
        gestora.agregarInscripcion(i1);
        gestora.agregarInscripcion(i2);
        System.out.println("Inscripciones agregadas correctamente.");

        // Buscar
        Inscripcion encontrada = gestora.buscarPorDNI("12345678A");
        System.out.println("Busqueda por DNI (12345678A): " + (encontrada != null ? encontrada.getCliente().getNombre() : "No encontrado"));

        // Modificar
        gestora.modificarEstadoPago("98765432B", true);
        System.out.println("Estado de pago de Akemi modificado a: PAGADO");

        // Eliminar
        gestora.eliminarInscripcionPorDNI("12345678A");
        System.out.println("Inscripción de Milan eliminada. Tamaño actual de lista: " + Inscripcion.getListaInscripciones().size());

        // 3. MÓDULO DE EXCEPCIONES (UD4)
        System.out.println("\nPRUEBA DE EXCEPCIONES");

        // Prueba 1: Saldo Insuficiente
        try {
            System.out.print("Verificando saldo de " + c2.getNombre() + "... ");
            if (c2.getSaldo() < 50.0) {
                throw new SaldoInsuficienteException();
            }
        } catch (SaldoInsuficienteException ex) {
            System.out.println("CAPTURA: " + ex.getMessage());
        }

        // Prueba 2: Pago Ya Realizado
        try {
            System.out.print("Verificando pago de la inscripción " + i1.getIdInscripcion() + "... ");
            if (i1.isPagado()) {
                throw new PagoYaRealizadoException();
            }
        } catch (PagoYaRealizadoException ex) {
            System.out.println("CAPTURA: " + ex.getMessage());
        }

        // Prueba 3: Cliente No Encontrado
        try {
            System.out.print("Buscando cliente inexistente... ");
            if (gestora.buscarPorDNI("99999999Z") == null) {
                throw new ClienteNoEncontradoException();
            }
        } catch (ClienteNoEncontradoException ex) {
            System.out.println("CAPTURA: " + ex.getMessage());
        }

        // Prueba 4: Capacidad Máxima
        try {
            System.out.print("Añadiendo clientes a la clase " + clase1.getNombre() + "... ");
            clase1.agregarCliente(c1, Entrenador.Especialidad.YOGA, Clase.NivelDificultad.INTERMEDIO);
            if (clase1.getListClientes().size() >= 1) {
                throw new CapacidadMaximaException();
            }
        } catch (CapacidadMaximaException ex) {
            System.out.println("CAPTURA: " + ex.getMessage());
        }


        // JSON
        System.out.println("\nJSON");

        // Guardamos las inscripciones que quedan en la lista estática
        GestorJSON.escribirInscripciones(Inscripcion.getListaInscripciones());

        // Las leemos para demostrar que funciona
        ArrayList<Inscripcion> listaLeida = GestorJSON.leerInscripciones();
        System.out.println("Clientes recuperados del archivo JSON:");
        for (Inscripcion ins : listaLeida) {
            System.out.println("- " + ins.getCliente().getNombre() + " (" + ins.getCuota().getNombre() + ")");
        }


        // INTERFAZ GRÁFICA

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Por el momento todo está perfecto 🗿🙏");
        System.out.print("Quieres comprobar tu IMC?🗿 (si/no): ");

        String respuesta = teclado.nextLine().trim().toLowerCase();

        switch (respuesta) {
            case "si", "sí", "okay", "vale", "de una bro" -> {
                System.out.println("\nArrancando los moteres nucleares de la Calculadora IMC...🥀");
                new CalculadoraIMC();
            }
            case "no", "que va", "paso" -> {
                System.out.println("\nUnderstandable bro, have a nice day");
                System.out.println("Cerrando sistema");
            }
            default -> {
                System.out.println("\nWhat did u say bro??.");
                System.out.println("¡Ciao!");
            }
        }

        teclado.close();


        System.out.println("\n***********************************************************");
        System.out.println("*              SISTEMA EJECUTADO CON ÉXITO                  *");
        System.out.println("*************************************************************");
    }
}