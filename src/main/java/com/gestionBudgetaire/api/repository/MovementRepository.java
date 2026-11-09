package com.gestionBudgetaire.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionBudgetaire.api.model.Movement;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Integer>{

	public Iterable<Movement> findByProjectId(Integer id);
	
}
