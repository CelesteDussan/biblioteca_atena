package com.corhuila.BackendAtena.IService;

import com.corhuila.BackendAtena.Entity.Libros;

import java.util.List;
import java.util.Optional;

public interface ILibrosService{

        Libros save(Libros libros);
        void  update(Libros libros, Integer id);
        List<Libros> all();
        Optional<Libros> findById(Integer id);
        void delete(Integer id);

}

