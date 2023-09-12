package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @Column(name = "Cod_Producto")
    private int codProducto;

    @Column(name = "Nom_Producto", length = 255, nullable = false)
    private String nomProducto;

    @Column(name = "Cod_Pedido", nullable = false)
    private int codPedido;

    @ManyToOne
    @JoinColumn(name = "Cod_Pedido", referencedColumnName = "Cod_Pedido", insertable = false, updatable = false)
    private Pedido pedido;

    public Producto() {
    }

    public Producto(int codProducto, String nomProducto, int codPedido) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.codPedido = codPedido;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codProducto=" + codProducto +
                ", nomProducto='" + nomProducto + '\'' +
                ", codPedido=" + codPedido +
                '}';
    }
}
