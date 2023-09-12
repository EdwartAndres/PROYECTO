package tienda.tienda.Entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Devoluciones")
public class Devolucion {
    @Id
    @Column(name = "Cod_Devolucion")
    private int codDevolucion;

    @Column(name = "Cod_Identificacion", nullable = false)
    private int codIdentificacion;

    @Column(name = "Unidades", nullable = false)
    private int unidades;

    @ManyToOne
    @JoinColumn(name = "Cod_Identificacion", referencedColumnName = "Cod_Identificacion", insertable = false, updatable = false)
    private Detalle detalle;

    public Devolucion() {
    }

    public Devolucion(int codDevolucion, int codIdentificacion, int unidades) {
        this.codDevolucion = codDevolucion;
        this.codIdentificacion = codIdentificacion;
        this.unidades = unidades;
    }

    public int getCodDevolucion() {
        return codDevolucion;
    }

    public void setCodDevolucion(int codDevolucion) {
        this.codDevolucion = codDevolucion;
    }

    public int getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(int codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "codDevolucion=" + codDevolucion +
                ", codIdentificacion=" + codIdentificacion +
                ", unidades=" + unidades +
                '}';
    }
}
