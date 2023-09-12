package tienda.tienda.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.Entidades.Empleado;
import tienda.tienda.Servicios.EmpleadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Empleado>> findAll() {
        List<Empleado> empleados = empleadoService.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoService.findById(id);
        if (empleado.isPresent()) {
            return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.save(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado empleado) {
        if (empleadoService.existsById(id)) {
            empleado.setCcEmpleado(id.intValue());
            Empleado updatedEmpleado = empleadoService.save(empleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (empleadoService.existsById(id)) {
            empleadoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
