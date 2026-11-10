package com.gestionBudgetaire.api.model;

import java.time.Instant;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Instant startDate;
	
	@Column(name="date_fin")
	private Instant endDate;
	
	@Enumerated(EnumType.STRING)
	private Statut statut;

	
}
