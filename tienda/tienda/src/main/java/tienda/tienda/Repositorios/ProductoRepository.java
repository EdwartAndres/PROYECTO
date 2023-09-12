package tienda.tienda.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
