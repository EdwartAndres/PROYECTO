package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @Column(name = "CC_Cliente")
    private int ccCliente;

    @Column(name = "Nom_Cliente", length = 255, nullable = false)
    private String nombreCliente;

    public Cliente() {
    }

    public Cliente(int ccCliente, String nombreCliente) {
        this.ccCliente = ccCliente;
        this.nombreCliente = nombreCliente;
    }

    public int getCcCliente() {
        return ccCliente;
    }

    public void setCcCliente(int ccCliente) {
        this.ccCliente = ccCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ccCliente=" + ccCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
