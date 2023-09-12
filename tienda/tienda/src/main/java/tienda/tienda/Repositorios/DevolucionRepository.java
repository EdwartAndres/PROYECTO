package tienda.tienda.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
