package tienda.tienda.Entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Detalles")
public class Detalle {
    @Id
    @Column(name = "Cod_Identificacion")
    private int codIdentificacion;

    @Column(name = "Cod_Producto", nullable = false)
    private int codProducto;

    @Column(name = "Cod_Compra", nullable = false)
    private int codCompra;

    @Column(name = "Precio", nullable = false)
    private double precio;

    @Column(name = "Pago", nullable = false)
    private double pago;

    @ManyToOne
    @JoinColumn(name = "Cod_Producto", referencedColumnName = "Cod_Producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "Cod_Compra", referencedColumnName = "Cod_Compra", insertable = false, updatable = false)
    private Compra compra;

    public Detalle() {
    }

    public Detalle(int codIdentificacion, int codProducto, int codCompra, double precio, double pago) {
        this.codIdentificacion = codIdentificacion;
        this.codProducto = codProducto;
        this.codCompra = codCompra;
        this.precio = precio;
        this.pago = pago;
    }

    public int getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(int codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "codIdentificacion=" + codIdentificacion +
                ", codProducto=" + codProducto +
                ", codCompra=" + codCompra +
                ", precio=" + precio +
                ", pago=" + pago +
                '}';
    }
}
