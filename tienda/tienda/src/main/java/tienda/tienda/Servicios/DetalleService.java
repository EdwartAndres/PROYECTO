package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Detalle;
import tienda.tienda.Repositorios.DetalleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetalleService {

    private final DetalleRepository detalleRepository;

    @Autowired
    public DetalleService(DetalleRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    public boolean existsById(Long id) {
        return detalleRepository.existsById(id);
    }

    public Optional<Detalle> findById(Long id) {
        return detalleRepository.findById(id);
    }

    public List<Detalle> findAll() {
        return detalleRepository.findAll();
    }

    public Detalle save(Detalle detalle) {
        try {
            return detalleRepository.save(detalle);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el detalle: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        detalleRepository.deleteById(id);
    }
}
