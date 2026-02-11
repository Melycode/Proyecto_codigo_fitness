package personas;

import java.util.Objects;

public class Persona {
    public enum Sexo { HOMBRE, MUJER, OTRO }

    private String nombre;
    private String dni;
    private int edad;
    private Sexo sexo;

    public Persona(String nombre, String dni, int edad, Sexo sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(dni, persona.dni) && sexo == persona.sexo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, edad, sexo);
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                '}';
    }
}
