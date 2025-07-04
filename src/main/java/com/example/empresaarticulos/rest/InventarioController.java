package com.example.empresaarticulos.rest;

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

import com.example.empresaarticulos.dto.InventarioDTO;
import com.example.empresaarticulos.service.InventarioService;


@RestController
@RequestMapping("/inventario")
public class InventarioController {
	
	Logger logger = LogManager.getLogger(InventarioController.class);
	
	@Autowired
	private InventarioService _inventarioService;
	
	
	/**
	 * Metodo para crear inventario
	 * Param inventarioDto
	 */
	@PostMapping(value = "/almacenar")
	public ResponseEntity<InventarioDTO> crearInventario(@RequestBody @Validated InventarioDTO inventarioDto) {
		logger.info("Ingresa metodo crearInventario");
		InventarioDTO inventarioCrear = new InventarioDTO();
		inventarioCrear = _inventarioService.crearInventario(inventarioDto);
		logger.info("Finaliza metodo crearInventario");
		return ResponseEntity.ok(inventarioCrear);
	}
	
	
	
	/**
	 * Metodo para actualizar inventario
	 * Param inventarioDto
	 */
	@PostMapping(value = "/actualizar")
	public ResponseEntity<InventarioDTO> actualizarInventarioPorProducto(@RequestBody @Validated InventarioDTO inventarioDto) {
		logger.info("Ingresa metodo actualizarInventarioPorProducto");
		InventarioDTO InventarioActualizar = new InventarioDTO();
		InventarioActualizar = _inventarioService.actualizarInventarioPorProducto(inventarioDto);
		logger.info("Finaliza metodo actualizarInventarioPorProducto");
		return ResponseEntity.ok(InventarioActualizar);
	}
	
	
	
	/**
	 * Metodo para consultar un inventario por ID Producto
	 * Param idProducto
	 */
	@GetMapping(value = "/{idProducto}")
	public ResponseEntity<InventarioDTO> consultarInventarioPorIdProd(@PathVariable String idProducto) {
		logger.info("Ingresa metodo consultarInventarioPorIdProd");
		InventarioDTO inventarioDto = new InventarioDTO();
		inventarioDto = _inventarioService.consultarInventarioPorProducto(idProducto);
		logger.info("Finaliza metodo consultarInventarioPorIdProd");
		return ResponseEntity.ok(inventarioDto);
	}

}
