package com.corhuila.BackendAtena.Controller;

import com.corhuila.BackendAtena.Entity.Prestamos;
import com.corhuila.BackendAtena.IService.IPrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/prestamos")
public class PrestamosController {
    @Autowired
    private IPrestamosService service;

    @PostMapping("")
    public Prestamos save(@RequestBody Prestamos prestamos) {
        return service.save(prestamos);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Prestamos prestamos, @PathVariable Integer id) {
        service.update(prestamos, id);
    }

    @GetMapping("")
    public List<Prestamos> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Prestamos> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

