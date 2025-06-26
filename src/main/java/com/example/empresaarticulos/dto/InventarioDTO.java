package com.example.empresaarticulos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InventarioDTO {

	private String id;
	private ProductoDTO producto;
	private Integer cantidad;
}
