package tienda.tienda.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
