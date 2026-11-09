package com.gestionBudgetaire.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionBudgetaire.api.DTO.FinancialSituationDTO;
import com.gestionBudgetaire.api.model.Project;
import com.gestionBudgetaire.api.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	private final ProjectService projectService;

	ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public Iterable<Project> getAllProject(){
		return projectService.findAllProject();
	}
	
	@GetMapping("/{id}")
	public Optional<Project> getProjectById(@PathVariable Integer id){
		return projectService.findProjectById(id);
	}
	
	@PostMapping("/project")
	public Project createProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	@PutMapping("/project/{id}")
	public Project updateProject(@PathVariable Integer id, @RequestBody Project project) {
		project.setId(id);
		return projectService.saveProject(project);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
	}
	
	@GetMapping("/{id}/finance")
	public FinancialSituationDTO financialSituation(@PathVariable Integer id) {
		return projectService.getFinancialSituation(id);
	}
}
