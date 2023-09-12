package tienda.tienda.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Pedido;
import tienda.tienda.Repositorios.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public boolean existsById(Long id) {
        return pedidoRepository.existsById(id);
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        try {
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el pedido: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
