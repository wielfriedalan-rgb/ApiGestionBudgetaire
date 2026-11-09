package com.gestionBudgetaire.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@DynamicUpdate
@Entity
@Table(name="projet")
public class Project {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom")
	private String name;
	
	private double budget;
	
	@Column(name="description_projet")
	private String description;
	
	@Column(name="date_debut")
	private LocalDate startDate;
	
	@Column(name="date_fin")
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	@OneToMany(
			mappedBy="project",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
			)
	private List<Movement> movements = new ArrayList<>();
	
	public void addMovement(Movement movement) {
		movements.add(movement);
		movement.setProject(this);
	}
	
	public void removeMovement(Movement movement) {
		movements.remove(movement);
		movement.setProject(null);
	}
	
}
