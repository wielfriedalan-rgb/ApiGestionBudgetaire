package com.gestionBudgetaire.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionBudgetaire.api.model.Project;
import com.gestionBudgetaire.api.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public Iterable<Project> getAllProject(){
		return projectService.findAllProject();
	}
	
	@GetMapping("/{id}")
	public Optional<Project> getProjectById(@PathVariable Integer id){
		return projectService.findProjectById(id);
	}
	
	@PostMapping("/project")
	public Project createProject(Project project) {
		return projectService.saveProject(project);
	}
	
	@PutMapping("/project/{id}")
	public Project updateProject(@PathVariable Integer id, Project project) {
		project.setId(id);
		return projectService.saveProject(project);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
	}
}
