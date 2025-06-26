package com.example.empresaarticulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpresaarticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaarticulosApplication.class, args);
		titleApp();
	}
	
	
	public static void titleApp() {
		String titulo = "  Empresa Articulos  ";		
		System.out.println("                                                                                        ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(titulo);
		System.out.println("----------------------------------------------------------------------------------------");
	}


}
