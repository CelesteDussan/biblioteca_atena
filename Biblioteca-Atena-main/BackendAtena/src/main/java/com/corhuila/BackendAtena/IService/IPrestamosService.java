package com.corhuila.BackendAtena.IService;

import com.corhuila.BackendAtena.Entity.Prestamos;

import java.util.List;
import java.util.Optional;

public interface IPrestamosService{

            Prestamos save(Prestamos prestamos);
            void  update(Prestamos prestamos, Integer id);
            List<Prestamos> all();
            Optional<Prestamos> findById(Integer id);
            void delete(Integer id);

}

