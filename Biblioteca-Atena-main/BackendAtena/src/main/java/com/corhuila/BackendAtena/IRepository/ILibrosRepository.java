package com.corhuila.BackendAtena.IRepository;

import com.corhuila.BackendAtena.Entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibrosRepository extends JpaRepository<Libros, Integer> {
}
