package tienda.tienda.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.PedidoProducto;

public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
