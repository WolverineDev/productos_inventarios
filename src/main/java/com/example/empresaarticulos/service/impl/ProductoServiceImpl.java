package com.example.empresaarticulos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresaarticulos.adapter.ProductoAdapter;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Producto;
import com.example.empresaarticulos.repository.ProductoRepository;
import com.example.empresaarticulos.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	
	@Autowired
	private ProductoRepository _productoRepository;
	
	@Autowired
	private ProductoAdapter _productoAdapter;


	
	/**
	 * Metodo para crear / actualizar producto
	 * Param ProductoDTO
	 */
	@Override
	public ProductoDTO crearProducto(ProductoDTO productoDto) {
		System.out.println("Ingresa service crearProducto");
		try {
			ProductoDTO productoQuery = consultarProductoPorId(productoDto.getId());
			if(productoQuery != null) {
				Producto productoEnt = _productoAdapter.dtoToEntity(productoDto);
				_productoRepository.save(productoEnt);
				System.out.println("Almacenado producto con id  "+productoDto);
			}
		} catch (Exception e) {
			System.out.println("Error crearProducto: "+e.getMessage());
		}
		System.out.println("Finaliza service crearProducto");
		return productoDto;
	}

	
	/**
	 * Metodo para consultar un producto por ID
	 * Param id
	 */
	@Override
	public ProductoDTO consultarProductoPorId(String id) {
		System.out.println("Ingresa service consultarProductoPorId");
		ProductoDTO productoDto = new ProductoDTO();
		try {
			Producto productoEnt = _productoRepository.findByIdProducto(id);
			if(productoEnt == null) {
				System.out.println("No existe producto con el id "+id);
			}
			else {
				productoDto = _productoAdapter.entityToDto(productoEnt);
				System.out.println("Existe producto con el id "+id);
			}
		} catch (Exception e) {
			System.out.println("Error consultarProductoPorId: "+e.getMessage());
		}
		System.out.println("Finaliza service consultarProductoPorId");
		return productoDto;
	}
	

	/**
	 * Metodo para eliminar un producto por ID
	 * Param id
	 */
	@Override
	public ProductoDTO eliminarProducto(String id) {
		System.out.println("Ingresa service eliminarProducto");
		ProductoDTO productoDto = new ProductoDTO();
		try {
			ProductoDTO productoQuery = consultarProductoPorId(id);
			if(productoQuery != null) {
				Producto productoEnt = _productoAdapter.dtoToEntity(productoQuery);
				_productoRepository.delete(productoEnt);
				System.out.println("Eliminado producto con id  "+productoDto);
			}
		} catch (Exception e) {
			System.out.println("Error eliminarProducto: "+e.getMessage());
		}
		System.out.println("Finaliza service eliminarProducto");
		return productoDto;
	}

	
	/**
	 * Metodo para consultar lista de productos
	 */
	@Override
	public List<ProductoDTO> consultarListaProductos() {
		System.out.println("Ingresa service consultarListaProductos");
		List<ProductoDTO> listaProductoDto = new ArrayList<>();
		List<Producto> listaProductoEnt = new ArrayList<>();
		try {
			listaProductoEnt = _productoRepository.findAll();
			if(!listaProductoEnt.isEmpty()) {
				for(Producto prodEnt: listaProductoEnt) {
					ProductoDTO productoDto = new ProductoDTO();
					productoDto = _productoAdapter.entityToDto(prodEnt);
					listaProductoDto.add(productoDto);
				}
				System.out.println("Información de "+listaProductoEnt.size()+" datos");
			}
			else {
				System.out.println("No existe información de productos");
			}
		} catch (Exception e) {
			System.out.println("Error consultarListaProductos: "+e.getMessage());
		}
		System.out.println("Finaliza service consultarListaProductos");
		return listaProductoDto;
	}
	

}
