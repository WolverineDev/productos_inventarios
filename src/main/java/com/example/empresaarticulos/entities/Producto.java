package com.example.empresaarticulos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@Table(name = "Producto")
public class Producto {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private String precio;
	
	
	public Producto() {}

}
