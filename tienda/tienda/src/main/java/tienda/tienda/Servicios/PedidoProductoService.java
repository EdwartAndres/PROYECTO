package tienda.tienda.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.PedidoProducto;
import tienda.tienda.Repositorios.PedidoProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoProductoService {

    private final PedidoProductoRepository pedidoProductoRepository;

    @Autowired
    public PedidoProductoService(PedidoProductoRepository pedidoProductoRepository) {
        this.pedidoProductoRepository = pedidoProductoRepository;
    }

    public boolean existsById(Long id) {
        return pedidoProductoRepository.existsById(id);
    }

    public Optional<PedidoProducto> findById(Long id) {
        return pedidoProductoRepository.findById(id);
    }

    public List<PedidoProducto> findAll() {
        return pedidoProductoRepository.findAll();
    }

    public PedidoProducto save(PedidoProducto pedidoProductos) {
        try {
            return pedidoProductoRepository.save(pedidoProductos);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el pedidoProductos: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        pedidoProductoRepository.deleteById(id);
    }
}
