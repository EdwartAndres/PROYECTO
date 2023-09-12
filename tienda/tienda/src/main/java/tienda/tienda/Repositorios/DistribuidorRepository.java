package tienda.tienda.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Distribuidor;

public interface DistribuidorRepository extends JpaRepository<Distribuidor, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
