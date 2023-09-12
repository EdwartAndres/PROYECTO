package tienda.tienda.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.Compra;
import tienda.tienda.Servicios.CompraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Compra>> findAll() {
        List<Compra> compras = compraService.findAll();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Long id) {
        Optional<Compra> compra = compraService.findById(id);
        if (compra.isPresent()) {
            return new ResponseEntity<>(compra.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        Compra savedCompra = compraService.save(compra);
        return new ResponseEntity<>(savedCompra, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> update(@PathVariable Long id, @RequestBody Compra compra) {
        if (compraService.existsById(id)) {
            compra.setCodCompra(id.intValue());
            Compra updatedCompra = compraService.save(compra);
            return new ResponseEntity<>(updatedCompra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (compraService.existsById(id)) {
            compraService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
