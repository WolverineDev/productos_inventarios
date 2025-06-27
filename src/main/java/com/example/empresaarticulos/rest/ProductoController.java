package com.example.empresaarticulos.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresaarticulos.dto.ProductoDTO;
import com.example.empresaarticulos.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	Logger logger = LogManager.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService _productoService;
	
	
	
	/**
	 * Metodo para crear / actualizar producto
	 * Param ProductoDTO
	 */
	@PostMapping(value = "/almacenar")
	public ResponseEntity<ProductoDTO> crearProducto(@RequestBody @Validated ProductoDTO productoDto) {
		logger.info("Ingresa metodo crearProducto");
		ProductoDTO productoCrear = new ProductoDTO();
		productoCrear = _productoService.crearProducto(productoDto);
		logger.info("Finaliza metodo crearProducto");
		return ResponseEntity.ok(productoCrear);
	}
	
	
	/**
	 * Metodo para consultar un producto por ID
	 * Param id
	 */
	@GetMapping(value = "/{idProducto}")
	public ResponseEntity<ProductoDTO> consultarProductoPorIdP(@PathVariable String idProducto) {
		logger.info("Ingresa metodo consultarProductoPorId");
		ProductoDTO productoDto = new ProductoDTO();
		productoDto = _productoService.consultarProductoPorId(idProducto);
		logger.info("Finaliza metodo consultarProductoPorId");
		if(productoDto.getId() != null) {
			return ResponseEntity.ok(productoDto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	/**
	 * Metodo para eliminar un producto por ID
	 * Param id
	 */
	@GetMapping(value = "/eliminar/{idProducto}")
	public ResponseEntity<ProductoDTO> eliminarProducto(@PathVariable String idProducto) {
		logger.info("Ingresa metodo eliminarProducto");
		ProductoDTO productoDto = new ProductoDTO();
		productoDto = _productoService.eliminarProducto(idProducto);
		logger.info("Finaliza metodo eliminarProducto");
		return ResponseEntity.ok(productoDto);
	}
	
	
	@GetMapping(value = "/listaProductos")
	public ResponseEntity<List<ProductoDTO>> consultarListaProductos() {
		logger.info("Ingresa metodo consultarListaProductos");
		List<ProductoDTO> listaProductos = _productoService.consultarListaProductos();
		logger.info("Finaliza metodo consultarListaProductos");
		return ResponseEntity.ok(listaProductos);
	}
	
	

}
