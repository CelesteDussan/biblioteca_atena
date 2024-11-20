package com.corhuila.BackendAtena.IService;

import com.corhuila.BackendAtena.Entity.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesService{

        Clientes save(Clientes clientes);
        void  update(Clientes clientes, Integer id);
        List<Clientes> all();
        Optional<Clientes> findById(Integer id);
        void delete(Integer id);
        Optional<Clientes> findByDocument(String cedula);

}

