package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @Column(name = "cc_Empleado")
    private int ccEmpleado;

    @Column(name = "Nom_Empleado", length = 255, nullable = false)
    private String nombreEmpleado;

    @Column(name = "Salario_Empleado")
    private double salarioEmpleado;

    @Column(name = "Horario", length = 20, nullable = false)
    private String horario;

    @Column(name = "Cargo", length = 20, nullable = false)
    private String cargo;

    public Empleado() {
    }

    public Empleado(int ccEmpleado, String nombreEmpleado, double salarioEmpleado, String horario, String cargo) {
        this.ccEmpleado = ccEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.horario = horario;
        this.cargo = cargo;
    }

    public int getCcEmpleado() {
        return ccEmpleado;
    }

    public void setCcEmpleado(int ccEmpleado) {
        this.ccEmpleado = ccEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ccEmpleado=" + ccEmpleado +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", salarioEmpleado=" + salarioEmpleado +
                ", horario='" + horario + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
