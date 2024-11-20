package com.corhuila.BackendAtena.Service;

import com.corhuila.BackendAtena.Entity.Prestamos;
import com.corhuila.BackendAtena.IRepository.IPrestamosRepository;
import com.corhuila.BackendAtena.IService.IPrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamosService implements IPrestamosService {
    @Autowired
    private IPrestamosRepository repository;

    @Override
    public Prestamos save(Prestamos prestamos) {
        return repository.save(prestamos);
    }

    @Override
    public void update(Prestamos prestamos, Integer id) {
        // Verificar si el registro con el ID dado existe en la base de datos.
        Optional<Prestamos> up = repository.findById(id);

        if (up.isPresent()) {
            Prestamos existingPrestamos = up.get();
            // Actualizar los valores del objeto existente.
            existingPrestamos.setCantidad(prestamos.getCantidad());
            existingPrestamos.setFechaPrestamo(prestamos.getFechaPrestamo());
            existingPrestamos.setFechaDevolucion(prestamos.getFechaDevolucion());
            existingPrestamos.setClientesId(prestamos.getClientesId());
            existingPrestamos.setLibrosId(prestamos.getLibrosId());
            existingPrestamos.setEstado(prestamos.getEstado());

            // Guardar el objeto existente actualizado.
            repository.save(existingPrestamos);
        } else {
            System.out.println("No existe registro con ID: " + id);
        }
    }


    @Override
    public List<Prestamos> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Prestamos> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}

