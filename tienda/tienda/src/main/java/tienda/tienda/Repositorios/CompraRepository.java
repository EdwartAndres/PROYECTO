package tienda.tienda.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
