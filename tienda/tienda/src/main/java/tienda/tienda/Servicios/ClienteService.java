package tienda.tienda.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.Entidades.Cliente;
import tienda.tienda.Repositorios.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            // Maneja la excepción aquí, por ejemplo, puedes registrarla
            throw new RuntimeException("Error al guardar el cliente: " + e.getMessage());
        }
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
