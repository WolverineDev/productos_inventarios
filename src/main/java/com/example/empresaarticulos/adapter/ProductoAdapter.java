package com.example.empresaarticulos.adapter;

import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Producto;

public interface ProductoAdapter {
	
	public ProductoDTO entityToDto(Producto productoEnt);
	
	public Producto dtoToEntity(ProductoDTO productoDto);


}
