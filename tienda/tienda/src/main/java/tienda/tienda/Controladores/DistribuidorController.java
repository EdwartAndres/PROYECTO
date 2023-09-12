package tienda.tienda.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.Distribuidor;
import tienda.tienda.Servicios.DistribuidorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/distribuidores")
public class DistribuidorController {

    private final DistribuidorService distribuidorService;

    @Autowired
    public DistribuidorController(DistribuidorService distribuidorService) {
        this.distribuidorService = distribuidorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Distribuidor>> findAll() {
        List<Distribuidor> distribuidores = distribuidorService.findAll();
        return new ResponseEntity<>(distribuidores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distribuidor> findById(@PathVariable Long id) {
        Optional<Distribuidor> distribuidor = distribuidorService.findById(id);
        if (distribuidor.isPresent()) {
            return new ResponseEntity<>(distribuidor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Distribuidor> save(@RequestBody Distribuidor distribuidor) {
        Distribuidor savedDistribuidor = distribuidorService.save(distribuidor);
        return new ResponseEntity<>(savedDistribuidor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Distribuidor> update(@PathVariable Long id, @RequestBody Distribuidor distribuidor) {
        if (distribuidorService.existsById(id)) {
            distribuidor.setNitDistribuidor(id.intValue());
            Distribuidor updatedDistribuidor = distribuidorService.save(distribuidor);
            return new ResponseEntity<>(updatedDistribuidor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (distribuidorService.existsById(id)) {
            distribuidorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
