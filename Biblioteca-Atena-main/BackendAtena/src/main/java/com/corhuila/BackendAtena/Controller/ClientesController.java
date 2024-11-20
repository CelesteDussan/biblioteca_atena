package com.corhuila.BackendAtena.Controller;

import com.corhuila.BackendAtena.Entity.Clientes;
import com.corhuila.BackendAtena.IService.IClientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/clientes")
public class ClientesController {
    @Autowired
    private IClientesService service;

    @PostMapping("")
    public Clientes save(@RequestBody Clientes clientes) {
        return service.save(clientes);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Clientes clientes, @PathVariable Integer id) {
        service.update(clientes, id);
    }

    @GetMapping("")
    public List<Clientes> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/findByDocument/{cedula}")
    public Optional<Clientes> findByDocument(@PathVariable String cedula){
        return service.findByDocument(cedula);
    }
}

