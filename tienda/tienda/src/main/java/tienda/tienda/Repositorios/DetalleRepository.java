package tienda.tienda.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Detalle;
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
