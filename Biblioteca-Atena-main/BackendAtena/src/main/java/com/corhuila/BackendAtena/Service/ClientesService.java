package com.corhuila.BackendAtena.Service;

import com.corhuila.BackendAtena.Entity.Clientes;
import com.corhuila.BackendAtena.IRepository.IClientesRepository;
import com.corhuila.BackendAtena.IService.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService implements IClientesService{
    @Autowired
    private IClientesRepository repository;

    @Override
    public Clientes save(Clientes clientes) {
        return repository.save(clientes);
    }

    @Override
    public void update(Clientes clientes, Integer id) {
        // Verificar si el registro con el ID dado existe en la base de datos.
        Optional<Clientes> up = repository.findById(id);

        if (up.isPresent()) {
            Clientes existingClientes = up.get();
            // Actualizar los valores del objeto existente.
            existingClientes.setCedula(clientes.getCedula());
            existingClientes.setNombre(clientes.getNombre());
            existingClientes.setEmail(clientes.getEmail());
            existingClientes.setTelefono(clientes.getTelefono());

            // Guardar el objeto existente actualizado.
            repository.save(existingClientes);
        } else {
            System.out.println("No existe registro con ID: " + id);
        }
    }


    @Override
    public List<Clientes> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Clientes> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Clientes> findByDocument(String cedula){
        return repository.findByDocument(cedula);
    }
}

