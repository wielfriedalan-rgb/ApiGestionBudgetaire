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

import com.gestionBudgetaire.api.model.Movement;
import com.gestionBudgetaire.api.service.MovementService;
import com.gestionBudgetaire.api.service.ProjectService;

@RestController
@RequestMapping("/projects/{projectId}/movements")
public class MovementController {

	private final MovementService movementService;
	private final ProjectService projectService;

	MovementController(MovementService movementService, ProjectService projectService) {
		this.movementService = movementService;
		this.projectService = projectService;
	}
	
	@GetMapping
	public Iterable<Movement> getMovementByProject(@PathVariable Integer projectId){
		return movementService.findMovementByProject(projectId);
	}
	
	@GetMapping("/{id}")
	public Optional<Movement> getMovementById(@PathVariable Integer id) {
		return movementService.findMovementById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovement(@PathVariable Integer id) {
		movementService.deleteMovement(id);
	}
	
	@PostMapping("/movement")
	public Movement createMovement(@PathVariable Integer projectId, @RequestBody Movement movement) {
		movement.setProject(projectService.findProjectById(projectId).get());
		return movementService.saveMovement(movement);
	}
	
	@PutMapping("/movement/{id}")
	public Movement updateMovement(@PathVariable Integer projectId, @PathVariable Integer id, @RequestBody Movement movement) {
		movement.setId(id);
		movement.setProject(projectService.findProjectById(projectId).get());
		return movementService.saveMovement(movement);
	}
	
}
