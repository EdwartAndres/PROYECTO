package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Distribuidor;
import tienda.tienda.Repositorios.DistribuidorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DistribuidorService {

    private final DistribuidorRepository distribuidorRepository;

    @Autowired
    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }

    public boolean existsById(Long id) {
        return distribuidorRepository.existsById(id);
    }

    public Optional<Distribuidor> findById(Long id) {
        return distribuidorRepository.findById(id);
    }

    public List<Distribuidor> findAll() {
        return distribuidorRepository.findAll();
    }

    public Distribuidor save(Distribuidor distribuidor) {
        try {
            return distribuidorRepository.save(distribuidor);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el distribuidor: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        distribuidorRepository.deleteById(id);
    }
}
