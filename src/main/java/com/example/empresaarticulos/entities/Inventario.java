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
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Inventario")
public class Inventario {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "producto")
	private String producto;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	
	
	public Inventario() {}

}
