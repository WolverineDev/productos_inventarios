package com.example.empresaarticulos.adapter.impl;

import org.springframework.stereotype.Service;

import com.example.empresaarticulos.adapter.ProductoAdapter;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Producto;

@Service
public class ProductoAdapterImpl implements ProductoAdapter {

	@Override
	public ProductoDTO entityToDto(Producto productoEnt) {
		ProductoDTO ProductoDto = new ProductoDTO();
		ProductoDto.setId(productoEnt.getId());
		ProductoDto.setNombre(productoEnt.getNombre());
		ProductoDto.setPrecio(productoEnt.getPrecio());
		return ProductoDto;
	}

	@Override
	public Producto dtoToEntity(ProductoDTO productoDto) {
		Producto productoEnt = new Producto();
		productoEnt.setId(productoDto.getId());
		productoEnt.setNombre(productoDto.getNombre());
		productoEnt.setPrecio(productoDto.getPrecio());
		return productoEnt;
	}
	
	

}
