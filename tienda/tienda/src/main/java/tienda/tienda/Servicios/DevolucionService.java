package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Devolucion;
import tienda.tienda.Repositorios.DevolucionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DevolucionService {

    private final DevolucionRepository devolucionRepository;

    @Autowired
    public DevolucionService(DevolucionRepository devolucionRepository) {
        this.devolucionRepository = devolucionRepository;
    }

    public boolean existsById(Long id) {
        return devolucionRepository.existsById(id);
    }

    public Optional<Devolucion> findById(Long id) {
        return devolucionRepository.findById(id);
    }

    public List<Devolucion> findAll() {
        return devolucionRepository.findAll();
    }

    public Devolucion save(Devolucion devolucion) {
        try {
            return devolucionRepository.save(devolucion);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar la devolución: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        devolucionRepository.deleteById(id);
    }
}
