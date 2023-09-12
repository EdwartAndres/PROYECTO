package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @Column(name = "Cod_Pedido")
    private int codPedido;

    @Column(name = "Nit_Distribuidor", nullable = false)
    private int nitDistribuidor;

    @Column(name = "Can_Total", nullable = false)
    private int canTotal;

    @Column(name = "Costo_Neto", nullable = false)
    private double costoNeto;

    @ManyToOne
    @JoinColumn(name = "Nit_Distribuidor", referencedColumnName = "Nit_Distribuidor", insertable = false, updatable = false)
    private Distribuidor distribuidor;

    public Pedido() {
    }

    public Pedido(int codPedido, int nitDistribuidor, int canTotal, double costoNeto) {
        this.codPedido = codPedido;
        this.nitDistribuidor = nitDistribuidor;
        this.canTotal = canTotal;
        this.costoNeto = costoNeto;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getNitDistribuidor() {
        return nitDistribuidor;
    }

    public void setNitDistribuidor(int nitDistribuidor) {
        this.nitDistribuidor = nitDistribuidor;
    }

    public int getCanTotal() {
        return canTotal;
    }

    public void setCanTotal(int canTotal) {
        this.canTotal = canTotal;
    }

    public double getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(double costoNeto) {
        this.costoNeto = costoNeto;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codPedido=" + codPedido +
                ", nitDistribuidor=" + nitDistribuidor +
                ", canTotal=" + canTotal +
                ", costoNeto=" + costoNeto +
                '}';
    }
}
