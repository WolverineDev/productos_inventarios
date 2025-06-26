package com.example.empresaarticulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.empresaarticulos.entities.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, String> {
	
	@Query(value = "select * from Inventario i where i.Producto = ?1", nativeQuery = true)
	Inventario findByProductoInventario(String producto);
	
//	@Query("select i from Inventario i where i.producto = ?1")
//	Inventario findByIdProducto(String producto);
	
	@Query(value = "select * from Inventario i where i.id = ?1", nativeQuery = true)
	Inventario findByIdInventario(String id);

}
