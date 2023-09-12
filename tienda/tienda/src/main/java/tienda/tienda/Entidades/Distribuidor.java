package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Distribuidores")
public class Distribuidor {
    @Id
    @Column(name = "Nit_Distribuidor")
    private int nitDistribuidor;

    @Column(name = "Nombre_Distribuidor", length = 255, nullable = false)
    private String nombreDistribuidor;

    public Distribuidor() {
    }

    public Distribuidor(int nitDistribuidor, String nombreDistribuidor) {
        this.nitDistribuidor = nitDistribuidor;
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public int getNitDistribuidor() {
        return nitDistribuidor;
    }

    public void setNitDistribuidor(int nitDistribuidor) {
        this.nitDistribuidor = nitDistribuidor;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    @Override
    public String toString() {
        return "Distribuidor{" +
                "nitDistribuidor=" + nitDistribuidor +
                ", nombreDistribuidor='" + nombreDistribuidor + '\'' +
                '}';
    }
}
