package com.gestionBudgetaire.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestionBudgetaire.api.model.Movement;
import com.gestionBudgetaire.api.repository.MovementRepository;

@Service
public class MovementService {

	private final MovementRepository movementRepository;

	MovementService(MovementRepository movementRepository) {
		this.movementRepository = movementRepository;
	}

	public Iterable<Movement> findMovementByProject(int projectId){
		return movementRepository.findByProjectId(projectId);
	}
	
	public Movement saveMovement(Movement movement) {
		return movementRepository.save(movement);
	}
	
	public Optional<Movement> findMovementById(int id) {
		return this.movementRepository.findById(id);
	}
	
	public void deleteMovement(int id) {
		movementRepository.deleteById(id);
	}
	
}
