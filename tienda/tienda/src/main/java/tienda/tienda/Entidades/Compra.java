package tienda.tienda.Entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Comprar")
public class Compra {
    @Id
    @Column(name = "Cod_Compra")
    private int codCompra;

    @Column(name = "cc_Empleado", nullable = false)
    private int ccEmpleado;

    @Column(name = "Cod_Producto", nullable = false)
    private int codProducto;

    @Column(name = "CC_Cliente", nullable = false)
    private int ccCliente;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha;

    @Column(name = "Pago")
    private double pago;

    @Column(name = "D_Establecimiento", length = 255, nullable = false)
    private String establecimiento;

    @Column(name = "Metodo_Pago", length = 20, nullable = false)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "cc_Empleado", referencedColumnName = "cc_Empleado", insertable = false, updatable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "Cod_Producto", referencedColumnName = "Cod_Producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "CC_Cliente", referencedColumnName = "CC_Cliente", insertable = false, updatable = false)
    private Cliente cliente;

    public Compra() {
    }

    public Compra(int codCompra, int ccEmpleado, int codProducto, int ccCliente, java.util.Date fecha, double pago, String establecimiento, String metodoPago) {
        this.codCompra = codCompra;
        this.ccEmpleado = ccEmpleado;
        this.codProducto = codProducto;
        this.ccCliente = ccCliente;
        this.fecha = fecha;
        this.pago = pago;
        this.establecimiento = establecimiento;
        this.metodoPago = metodoPago;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCcEmpleado() {
        return ccEmpleado;
    }

    public void setCcEmpleado(int ccEmpleado) {
        this.ccEmpleado = ccEmpleado;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCcCliente() {
        return ccCliente;
    }

    public void setCcCliente(int ccCliente) {
        this.ccCliente = ccCliente;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codCompra=" + codCompra +
                ", ccEmpleado=" + ccEmpleado +
                ", codProducto=" + codProducto +
                ", ccCliente=" + ccCliente +
                ", fecha=" + fecha +
                ", pago=" + pago +
                ", establecimiento='" + establecimiento + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
