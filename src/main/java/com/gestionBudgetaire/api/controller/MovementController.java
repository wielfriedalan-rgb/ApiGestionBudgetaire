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

import com.gestionBudgetaire.api.model.Movement;
import com.gestionBudgetaire.api.service.MovementService;

@RestController
@RequestMapping("/projects/{projectId}/movements")
public class MovementController {

	@Autowired
	private MovementService movementService;
	
	@GetMapping
	public Iterable<Movement> getMovementByProject(@PathVariable Integer projectId){
		return movementService.findMovementByProject(0);
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
	public Movement createMovement(Movement movement) {
		return movementService.saveMovement(movement);
	}
	
	@PutMapping("/movement/{id}")
	public Movement updateMovement(@PathVariable Integer id, Movement movement) {
		movement.setId(id);
		return movementService.saveMovement(movement);
	}
	
}
