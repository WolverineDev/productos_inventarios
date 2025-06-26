package com.example.empresaarticulos.service;

import java.util.List;

import com.example.empresaarticulos.dto.ProductoDTO;

public interface ProductoService {

	
	public ProductoDTO crearProducto(ProductoDTO producto);
	
	public ProductoDTO consultarProductoPorId(String id);
	
	public ProductoDTO eliminarProducto(String id);
	
	public List<ProductoDTO> consultarListaProductos();
	
	
}
