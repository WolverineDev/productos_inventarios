package com.example.empresaarticulos.adapter;

import com.example.empresaarticulos.dto.InventarioDTO;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Inventario;

public interface InventarioAdapter {
	
	
	public InventarioDTO entityToDto(Inventario inventario, ProductoDTO productoDto);
	
	public Inventario dtoToEntity(InventarioDTO inventario);
	

}
