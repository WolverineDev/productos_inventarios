package com.example.empresaarticulos.rest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private InventarioService _inventarioService;
	
	
	/**
	 * Metodo para crear inventario
	 * Param inventarioDto
	 */
	@PostMapping(value = "/almacenar")
	public InventarioDTO crearInventario(@RequestBody @Validated InventarioDTO inventarioDto) {
		System.out.println("Ingresa metodo crearInventario");
		InventarioDTO inventarioCrear = new InventarioDTO();
		inventarioCrear = _inventarioService.crearInventario(inventarioDto);
		System.out.println("Finaliza metodo crearInventario");
		return inventarioCrear;
	}
	
	
	
	/**
	 * Metodo para actualizar inventario
	 * Param inventarioDto
	 */
	@PostMapping(value = "/actualizar")
	public InventarioDTO actualizarInventarioPorProducto(@RequestBody @Validated InventarioDTO inventarioDto) {
		System.out.println("Ingresa metodo actualizarInventarioPorProducto");
		InventarioDTO InventarioActualizar = new InventarioDTO();
		InventarioActualizar = _inventarioService.actualizarInventarioPorProducto(inventarioDto);
		System.out.println("Finaliza metodo actualizarInventarioPorProducto");
		return InventarioActualizar;
	}
	
	
	
	/**
	 * Metodo para consultar un inventario por ID Producto
	 * Param idProducto
	 */
	@GetMapping(value = "/{idProducto}")
	public InventarioDTO consultarInventarioPorIdProd(@PathVariable String idProducto) {
		System.out.println("Ingresa metodo consultarInventarioPorIdProd");
		InventarioDTO inventarioDto = new InventarioDTO();
		inventarioDto = _inventarioService.consultarInventarioPorProducto(idProducto);
		System.out.println("Finaliza metodo consultarInventarioPorIdProd");
		return inventarioDto;
	}

}
