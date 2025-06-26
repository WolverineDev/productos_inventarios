package com.example.empresaarticulos.service;

import com.example.empresaarticulos.dto.InventarioDTO;

public interface InventarioService {
	
	public InventarioDTO crearInventario(InventarioDTO inventarioDto);
	
	public InventarioDTO actualizarInventarioPorProducto(InventarioDTO inventarioDto);
	
	public InventarioDTO consultarInventarioPorProducto(String idProducto);
	
	public InventarioDTO consultarInventarioPorId(String idInventario);
	

}
