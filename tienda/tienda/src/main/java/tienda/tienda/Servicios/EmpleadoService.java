package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Empleado;
import tienda.tienda.Repositorios.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public boolean existsById(Long id) {
        return empleadoRepository.existsById(id);
    }

    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado save(Empleado empleado) {
        try {
            return empleadoRepository.save(empleado);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el empleado: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
