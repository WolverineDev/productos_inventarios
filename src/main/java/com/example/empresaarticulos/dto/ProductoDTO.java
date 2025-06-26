package com.example.empresaarticulos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ProductoDTO {
	
	private String id;
	private String nombre;
	private String precio;
	
}
