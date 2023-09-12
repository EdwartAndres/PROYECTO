package tienda.tienda.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.Entidades.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
