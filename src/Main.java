import personas.Persona;
import personas.Cliente;
import servicios.Servicio;
import servicios.Maquina;
import servicios.Gimcurso;


public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", "87654321B", 30, Persona.Sexo.MUJER);
        System.out.println(p1);

        Persona p2 = new Persona("Juan", "97654321Z", 30, Persona.Sexo.HOMBRE);
        System.out.println(p2);

    }
}