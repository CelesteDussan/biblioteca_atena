package com.corhuila.BackendAtena.Service;

import com.corhuila.BackendAtena.Entity.Libros;
import com.corhuila.BackendAtena.IRepository.ILibrosRepository;
import com.corhuila.BackendAtena.IService.ILibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService implements ILibrosService {
    @Autowired
    private ILibrosRepository repository;

    @Override
    public Libros save(Libros libros) {
        return repository.save(libros);
    }

    @Override
    public void update(Libros libros, Integer id) {
        // Verificar si el registro con el ID dado existe en la base de datos.
        Optional<Libros> up = repository.findById(id);

        if (up.isPresent()) {
            Libros existingLibros = up.get();
            // Actualizar los valores del objeto existente.
            existingLibros.setAutor(libros.getAutor());
            existingLibros.setCategoria(libros.getCategoria());
            existingLibros.setTitulo(libros.getTitulo());

            // Guardar el objeto existente actualizado.
            repository.save(existingLibros);
        } else {
            System.out.println("No existe registro con ID: " + id);
        }
    }


    @Override
    public List<Libros> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Libros> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}

