package personas;

import java.util.Objects;

public class Cliente extends Persona {
    public enum TipoMembresia { BASICA, PREMIUM, VIP }
    private String idCliente;
    private TipoMembresia tipoMembresia;
    private double saldo;
    private boolean activo;


    public Cliente(String nombre, String dni, int edad, Sexo sexo, String idCliente, TipoMembresia tipoMembresia, double saldo, boolean activo) {
        super(nombre, dni, edad, sexo);
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
        this.saldo = saldo;
        this.activo = activo;
    }

    public Cliente(String idCliente, TipoMembresia tipoMembresia, double saldo, boolean activo) {
        super();
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
        this.saldo = saldo;
        this.activo = activo;
    }

    public Cliente() {
        super();
    }



    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Double.compare(saldo, cliente.saldo) == 0 && activo == cliente.activo && Objects.equals(idCliente, cliente.idCliente) && tipoMembresia == cliente.tipoMembresia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCliente, tipoMembresia, saldo, activo);
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", edad=" + getEdad() +
                ", sexo=" + getSexo() +
                ", idCliente='" + idCliente + '\'' +
                ", tipoMembresia=" + tipoMembresia +
                ", saldo=" + saldo +
                ", activo=" + activo +
                '}';
    }

}
