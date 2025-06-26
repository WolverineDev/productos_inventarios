package com.example.empresaarticulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.empresaarticulos.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
	
	@Query(value = "select * from Producto p where p.id = ?1", nativeQuery = true)
	Producto findByIdProducto(String id);
	
	
}
