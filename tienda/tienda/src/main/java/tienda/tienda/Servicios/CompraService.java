package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Compra;
import tienda.tienda.Repositorios.CompraRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompraService {

    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public boolean existsById(Long id) {
        return compraRepository.existsById(id);
    }

    public Optional<Compra> findById(Long id) {
        return compraRepository.findById(id);
    }

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra save(Compra compra) {
        try {
            return compraRepository.save(compra);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar la compra: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        compraRepository.deleteById(id);
    }
}
