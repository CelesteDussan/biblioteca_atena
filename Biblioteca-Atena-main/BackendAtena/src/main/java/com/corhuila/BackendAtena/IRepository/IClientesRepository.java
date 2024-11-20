package com.corhuila.BackendAtena.IRepository;

import com.corhuila.BackendAtena.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IClientesRepository extends JpaRepository<Clientes, Integer>{

    @Query(value = "SELECT * FROM clientes WHERE cedula = :cedula ",nativeQuery = true)
    Optional<Clientes> findByDocument(String cedula);
}
