package com.gestionBudgetaire.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionBudgetaire.api.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
