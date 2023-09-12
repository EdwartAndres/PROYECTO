package tienda.tienda.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
