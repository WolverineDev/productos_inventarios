package com.example.empresaarticulos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpresaarticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaarticulosApplication.class, args);
		titleApp();
	}
	
	
	public static void titleApp() {
		Logger logger = LogManager.getLogger(EmpresaarticulosApplication.class);
		String titulo = "  Empresa Articulos  ";		
		System.out.println("                                                                                        ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(titulo);
		System.out.println("----------------------------------------------------------------------------------------");
		logger.info(titulo);
	}


}
