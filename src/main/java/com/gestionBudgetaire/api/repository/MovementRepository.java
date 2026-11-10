package com.gestionBudgetaire.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionBudgetaire.api.model.Movement;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Integer>{

	public Iterable<Movement> findByProjectId(int id);
	
	@Query(value = "SELECT COALESCE(SUM(montant), 0) FROM mouvement " +
			"WHERE projet_id = :projectId AND type_mouvement = 'ENTREE'", 
			nativeQuery=true)
	public double getTotalEntrees(@Param("projectId") int projectId);
	
	@Query("SELECT COALESCE(SUM(m.montant), 0) FROM Movement m " +
			"WHERE m.project.id = :projectId " +
			"AND m.type = com.gestionBudgetaire.api.model.TypeMovement.SORTIE")
	public double getTotalSorties(@Param("projectId") int projectId);
	
}
