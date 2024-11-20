package com.corhuila.BackendAtena.IRepository;

import com.corhuila.BackendAtena.Entity.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamosRepository extends JpaRepository<Prestamos, Integer> {
}
