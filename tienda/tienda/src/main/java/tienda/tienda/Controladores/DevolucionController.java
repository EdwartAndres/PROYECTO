package tienda.tienda.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.Devolucion;
import tienda.tienda.Servicios.DevolucionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    private final DevolucionService devolucionService;

    @Autowired
    public DevolucionController(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Devolucion>> findAll() {
        List<Devolucion> devoluciones = devolucionService.findAll();
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> findById(@PathVariable Long id) {
        Optional<Devolucion> devolucion = devolucionService.findById(id);
        if (devolucion.isPresent()) {
            return new ResponseEntity<>(devolucion.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Devolucion> save(@RequestBody Devolucion devolucion) {
        Devolucion savedDevolucion = devolucionService.save(devolucion);
        return new ResponseEntity<>(savedDevolucion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> update(@PathVariable Long id, @RequestBody Devolucion devolucion) {
        if (devolucionService.existsById(id)) {
            devolucion.setCodDevolucion(id.intValue());
            Devolucion updatedDevolucion = devolucionService.save(devolucion);
            return new ResponseEntity<>(updatedDevolucion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (devolucionService.existsById(id)) {
            devolucionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
