package tienda.tienda.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.Detalle;
import tienda.tienda.Servicios.DetalleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles")
public class DetalleController {

    private final DetalleService detalleService;

    @Autowired
    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Detalle>> findAll() {
        List<Detalle> detalles = detalleService.findAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle> findById(@PathVariable Long id) {
        Optional<Detalle> detalle = detalleService.findById(id);
        if (detalle.isPresent()) {
            return new ResponseEntity<>(detalle.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Detalle> save(@RequestBody Detalle detalle) {
        Detalle savedDetalle = detalleService.save(detalle);
        return new ResponseEntity<>(savedDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle> update(@PathVariable Long id, @RequestBody Detalle detalle) {
        if (detalleService.existsById(id)) {
            detalle.setCodIdentificacion(id.intValue());
            Detalle updatedDetalle = detalleService.save(detalle);
            return new ResponseEntity<>(updatedDetalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (detalleService.existsById(id)) {
            detalleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
