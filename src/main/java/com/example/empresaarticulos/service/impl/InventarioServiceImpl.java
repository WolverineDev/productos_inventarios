package com.example.empresaarticulos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresaarticulos.adapter.InventarioAdapter;
import com.example.empresaarticulos.dto.InventarioDTO;
import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.entities.Inventario;
import com.example.empresaarticulos.repository.InventarioRepository;
import com.example.empresaarticulos.rest.ProductoController;
import com.example.empresaarticulos.service.InventarioService;
import com.example.empresaarticulos.service.ProductoService;


@Service
public class InventarioServiceImpl implements InventarioService {
	
	Logger logger = LogManager.getLogger(InventarioServiceImpl.class);
	
	
	@Autowired
	private InventarioRepository _inventarioRepository;
	
	@Autowired
	private InventarioAdapter _inventarioAdapter;
	
	@Autowired
	private ProductoService _productoService;
	
	
	
	/**
	 * Metodo para crear inventario
	 * Param inventarioDto
	 */
	@Override
	public InventarioDTO crearInventario(InventarioDTO inventarioDto) {
		logger.info("Ingresa service actualizarInventarioPorProducto");
		InventarioDTO inventarioProd = new InventarioDTO();
		try {
			inventarioProd = consultarInventarioPorProducto(inventarioDto.getProducto().getId());
			if(inventarioProd.getId() == null) {
				Inventario inventarioEnt = _inventarioAdapter.dtoToEntity(inventarioDto);
				_inventarioRepository.save(inventarioEnt);
				logger.info("Se ha creado el inventario de producto "+inventarioDto.getProducto().getId()+
						" con "+inventarioDto.getCantidad()+" elementos");
			}
		} catch (Exception e) {
			logger.error("Error actualizarInventarioPorProducto: "+e.getMessage());
		}
		logger.info("Finaliza service actualizarInventarioPorProducto");
		return inventarioDto;
	}
	
	
	
	/**
	 * Metodo para actualizar el inventario
	 * Param inventarioDto
	 */
	@Override
	public InventarioDTO actualizarInventarioPorProducto(InventarioDTO inventarioDto) {
		logger.info("Ingresa service actualizarInventarioPorProducto");
		InventarioDTO inventarioProd = new InventarioDTO();
		try {
			inventarioProd = consultarInventarioPorProducto(inventarioDto.getProducto().getId());
			if(inventarioProd.getId() != null) {
				logger.info("Hay cambios en el inventario "+inventarioProd.getId()+
						" de producto "+inventarioProd.getProducto().getNombre()+" con "+inventarioProd.getCantidad()+" elementos");
				inventarioProd.setCantidad(inventarioDto.getCantidad());
				Inventario inventarioEnt = _inventarioAdapter.dtoToEntity(inventarioProd);
				_inventarioRepository.save(inventarioEnt);
				logger.info("Actualizado el inventario de producto "+inventarioProd.getProducto().getNombre()+
						" a "+inventarioDto.getCantidad()+" elementos");
			}
		} catch (Exception e) {
			logger.error("Error actualizarInventarioPorProducto: "+e.getMessage());
		}
		logger.info("Finaliza service actualizarInventarioPorProducto");
		return inventarioProd;
	}
	
	
	
	/**
	 * Metodo para consultar inventario por id producto
	 * Param idProducto
	 */
	@Override
	public InventarioDTO consultarInventarioPorProducto(String idProducto) {
		logger.info("Ingresa service consultarInventarioPorProducto");
		InventarioDTO inventarioDto = new InventarioDTO();
		ProductoDTO productoDto = new ProductoDTO();
		try {
			productoDto = _productoService.consultarProductoPorId(idProducto);
			if(productoDto.getId() != null) {
				System.out.println("Producto: "+productoDto.getId());
				Inventario inventarioEnt = _inventarioRepository.findByProductoInventario(productoDto.getId());
				if(inventarioEnt != null) {
					inventarioDto = _inventarioAdapter.entityToDto(inventarioEnt, productoDto);
					logger.info("Existe información de inventario asociado al producto "+productoDto.getNombre());
				}
				else {
					logger.info("No existe inventario asociado al producto "+productoDto.getNombre());
				}
			}
			else {
				logger.info("No existe Producto.");
			}
		} catch (Exception e) {
			logger.error("Error consultarInventarioPorProducto: "+e.getMessage());
		}
		logger.info("Finaliza service consultarInventarioPorProducto");
		return inventarioDto;
	}
	
	
	
	/**
	 * Metodo para consultar inventario por id inventario
	 * Param idInventario
	 */
	public InventarioDTO consultarInventarioPorId(String idInventario) {
		logger.info("Ingresa service consultarInventarioPorId");
		InventarioDTO inventarioDto = new InventarioDTO();
		try {
			Inventario inventarioEnt = _inventarioRepository.findByIdInventario(idInventario);
			if(inventarioEnt == null) {
				logger.info("No existe inventario con el id "+idInventario);
			}
			else {
				ProductoDTO productoDto = _productoService.consultarProductoPorId(inventarioEnt.getProducto());
				inventarioDto = _inventarioAdapter.entityToDto(inventarioEnt, productoDto);
				logger.info("Existe información de inventario");
			}
		} catch (Exception e) {
			logger.error("Error consultarInventarioPorId: "+e.getMessage());
		}
		logger.info("Finaliza service consultarInventarioPorId");
		return inventarioDto;
	}
	
	
	
	
}
