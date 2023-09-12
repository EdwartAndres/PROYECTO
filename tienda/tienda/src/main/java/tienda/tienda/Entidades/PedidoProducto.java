package tienda.tienda.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Pedidos_Productos")
public class PedidoProducto {
    @Id
    @Column(name = "Cod")
    private int cod;

    @Column(name = "Cod_Pedido", nullable = false)
    private int codPedido;

    @Column(name = "Cod_Producto", nullable = false)
    private int codProducto;

    @ManyToOne
    @JoinColumn(name = "Cod_Pedido", referencedColumnName = "Cod_Pedido", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "Cod_Producto", referencedColumnName = "Cod_Producto", insertable = false, updatable = false)
    private Producto producto;

    public PedidoProducto() {
    }

    public PedidoProducto(int cod, int codPedido, int codProducto) {
        this.cod = cod;
        this.codPedido = codPedido;
        this.codProducto = codProducto;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "PedidoProducto{" +
                "cod=" + cod +
                ", codPedido=" + codPedido +
                ", codProducto=" + codProducto +
                '}';
    }
}
