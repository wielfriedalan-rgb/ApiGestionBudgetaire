package com.gestionBudgetaire.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionBudgetaire.api.model.Project;
import com.gestionBudgetaire.api.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Iterable<Project> findAllProject() {
		return projectRepository.findAll();
	}
	
	public Optional<Project> findProjectById(int id) {
		return projectRepository.findById(id);
	}
	
	public void deleteProject(int id) {
		projectRepository.deleteById(id);
	}
	
}
