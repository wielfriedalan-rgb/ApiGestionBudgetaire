package com.gestionBudgetaire.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionBudgetaire.api.service.ProjectService;

@SpringBootApplication
public class ApiGestionBudgetaireApplication implements CommandLineRunner{

	@Autowired
	private ProjectService projectService;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGestionBudgetaireApplication.class, args);
	}
	
	public void run(String... args) {
		System.out.println(projectService.findProjectById(3));
	}

}
