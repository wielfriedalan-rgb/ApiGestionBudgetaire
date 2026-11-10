package com.gestionBudgetaire.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestionBudgetaire.api.DTO.FinancialSituationDTO;
import com.gestionBudgetaire.api.model.Project;
import com.gestionBudgetaire.api.repository.MovementRepository;
import com.gestionBudgetaire.api.repository.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final MovementRepository movementRepository;

	ProjectService(ProjectRepository projectRepository, MovementRepository movementRepository) {
		this.projectRepository = projectRepository;
		this.movementRepository = movementRepository;
	}
	
	
	public FinancialSituationDTO getFinancialSituation(int projectId) {
		double totalEntrees = movementRepository.getTotalEntrees(projectId);
		double totalSorties =movementRepository.getTotalSorties(projectId);
		double solde = totalEntrees - totalSorties;
		double budgetRestant = projectRepository.findById(projectId).get().getBudget() - totalSorties;
		return new FinancialSituationDTO(totalEntrees, totalSorties, solde, budgetRestant);
	}
	
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
