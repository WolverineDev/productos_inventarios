package com.example.empresaarticulos.adapter.impl;

import org.springframework.stereotype.Service;

import com.example.empresaarticulos.adapter.InventarioAdapter;
import com.example.empresaarticulos.dto.InventarioDTO;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Inventario;


@Service
public class InventarioAdapterImpl implements InventarioAdapter {

	@Override
	public InventarioDTO entityToDto(Inventario inventarioEnt, ProductoDTO producto) {
		InventarioDTO inventarioDto = new InventarioDTO();
		inventarioDto.setId(inventarioEnt.getId());
		inventarioDto.setProducto(producto);
		inventarioDto.setCantidad(inventarioEnt.getCantidad());
		return inventarioDto;
	}

	@Override
	public Inventario dtoToEntity(InventarioDTO inventarioDto) {
		Inventario inventarioEnt = new Inventario();
		inventarioEnt.setId(inventarioDto.getId());
		inventarioEnt.setProducto(inventarioDto.getProducto().getId());
		inventarioEnt.setCantidad(inventarioDto.getCantidad());
		return inventarioEnt;
	}

}
