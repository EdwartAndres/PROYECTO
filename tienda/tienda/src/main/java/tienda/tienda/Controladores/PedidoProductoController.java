package tienda.tienda.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.PedidoProducto;
import tienda.tienda.Servicios.PedidoProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido-productos")
public class PedidoProductoController {

    private final PedidoProductoService pedidoProductoService;

    @Autowired
    public PedidoProductoController(PedidoProductoService pedidoProductoService) {
        this.pedidoProductoService = pedidoProductoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoProducto>> findAll() {
        List<PedidoProducto> pedidoProducto = pedidoProductoService.findAll();
        return new ResponseEntity<>(pedidoProducto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProducto> findById(@PathVariable Long id) {
        Optional<PedidoProducto> pedidoProducto = pedidoProductoService.findById(id);
        if (pedidoProducto.isPresent()) {
            return new ResponseEntity<>(pedidoProducto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<PedidoProducto> save(@RequestBody PedidoProducto pedidoProducto) {
        PedidoProducto savedPedidoProducto = pedidoProductoService.save(pedidoProducto);
        return new ResponseEntity<>(savedPedidoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoProducto> update(@PathVariable Long id, @RequestBody PedidoProducto pedidoProducto) {
        if (pedidoProductoService.existsById(id)) {
            pedidoProducto.setCod(id.intValue());
            PedidoProducto updatedPedidoProducto = pedidoProductoService.save(pedidoProducto);
            return new ResponseEntity<>(updatedPedidoProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pedidoProductoService.existsById(id)) {
            pedidoProductoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
