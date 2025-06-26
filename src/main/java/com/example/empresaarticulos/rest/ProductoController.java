package com.example.empresaarticulos.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Autowired
	private ProductoService _productoService;
	
	
	
	/**
	 * Metodo para crear / actualizar producto
	 * Param ProductoDTO
	 */
	@PostMapping(value = "/almacenar")
	public ProductoDTO crearProducto(@RequestBody @Validated ProductoDTO productoDto) {
		System.out.println("Ingresa metodo crearProducto");
		ProductoDTO productoCrear = new ProductoDTO();
		productoCrear = _productoService.crearProducto(productoDto);
		System.out.println("Finaliza metodo crearProducto");
		return productoCrear;
	}
	
	
	/**
	 * Metodo para consultar un producto por ID
	 * Param id
	 */
	@GetMapping(value = "/{idProducto}")
	public ProductoDTO consultarProductoPorId(@PathVariable String idProducto) {
		System.out.println("Ingresa metodo consultarProductoPorId");
		ProductoDTO productoDto = new ProductoDTO();
		productoDto = _productoService.consultarProductoPorId(idProducto);
		System.out.println("Finaliza metodo consultarProductoPorId");
		return productoDto;
	}
	
	
	/**
	 * Metodo para eliminar un producto por ID
	 * Param id
	 */
	@GetMapping(value = "/eliminar/{idProducto}")
	public ProductoDTO eliminarProducto(@PathVariable String idProducto) {
		System.out.println("Ingresa metodo eliminarProducto");
		ProductoDTO productoDto = new ProductoDTO();
		productoDto = _productoService.eliminarProducto(idProducto);
		System.out.println("Finaliza metodo eliminarProducto");
		return productoDto;
	}
	
	
	@GetMapping(value = "/listaProductos")
	public List<ProductoDTO> consultarListaProductos() {
		System.out.println("Ingresa metodo consultarListaProductos");
		List<ProductoDTO> listaProductos = new ArrayList();
		listaProductos = _productoService.consultarListaProductos();
		System.out.println("Finaliza metodo consultarListaProductos");
		return listaProductos;
	}

}
