package com.corhuila.BackendAtena.Controller;

import com.corhuila.BackendAtena.Entity.Libros;
import com.corhuila.BackendAtena.IService.ILibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/libros")
public class LibrosController {
    @Autowired
    private ILibrosService service;

    @PostMapping("")
    public Libros save(@RequestBody Libros libros) {
        return service.save(libros);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Libros libros, @PathVariable Integer id) {
        service.update(libros, id);
    }

    @GetMapping("")
    public List<Libros> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Libros> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

