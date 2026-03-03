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
    }
}



