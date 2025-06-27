package com.example.empresaarticulos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresaarticulos.adapter.ProductoAdapter;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Producto;
import com.example.empresaarticulos.repository.ProductoRepository;
import com.example.empresaarticulos.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	Logger logger = LogManager.getLogger(ProductoServiceImpl.class);
	
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
		logger.info("Ingresa service crearProducto");
		try {
			ProductoDTO productoQuery = consultarProductoPorId(productoDto.getId());
			if(productoQuery != null) {
				Producto productoEnt = _productoAdapter.dtoToEntity(productoDto);
				_productoRepository.save(productoEnt);
				logger.info("Almacenado producto con id  "+productoDto);
			}
		} catch (Exception e) {
			logger.error("Error crearProducto: "+e.getMessage());
		}
		logger.info("Finaliza service crearProducto");
		return productoDto;
	}

	
	/**
	 * Metodo para consultar un producto por ID
	 * Param id
	 */
	@Override
	public ProductoDTO consultarProductoPorId(String id) {
		logger.info("Ingresa service consultarProductoPorId");
		ProductoDTO productoDto = new ProductoDTO();
		try {
			Producto productoEnt = _productoRepository.findByIdProducto(id);
			if(productoEnt == null) {
				logger.info("No existe producto con el id "+id);
			}
			else {
				productoDto = _productoAdapter.entityToDto(productoEnt);
				logger.info("Existe producto con el id "+id);
			}
		} catch (Exception e) {
			logger.error("Error consultarProductoPorId: "+e.getMessage());
		}
		logger.info("Finaliza service consultarProductoPorId");
		return productoDto;
	}
	

	/**
	 * Metodo para eliminar un producto por ID
	 * Param id
	 */
	@Override
	public ProductoDTO eliminarProducto(String id) {
		logger.info("Ingresa service eliminarProducto");
		ProductoDTO productoDto = new ProductoDTO();
		try {
			ProductoDTO productoQuery = consultarProductoPorId(id);
			if(productoQuery != null) {
				Producto productoEnt = _productoAdapter.dtoToEntity(productoQuery);
				_productoRepository.delete(productoEnt);
				logger.info("Eliminado producto");
			}
		} catch (Exception e) {
			logger.error("Error eliminarProducto: "+e.getMessage());
		}
		logger.info("Finaliza service eliminarProducto");
		return productoDto;
	}

	
	/**
	 * Metodo para consultar lista de productos
	 */
	@Override
	public List<ProductoDTO> consultarListaProductos() {
		logger.info("Ingresa service consultarListaProductos");
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
				logger.info("Información de "+listaProductoEnt.size()+" datos");
			}
			else {
				logger.info("No existe información de productos");
			}
		} catch (Exception e) {
			logger.error("Error consultarListaProductos: "+e.getMessage());
		}
		logger.info("Finaliza service consultarListaProductos");
		return listaProductoDto;
	}
	

}
