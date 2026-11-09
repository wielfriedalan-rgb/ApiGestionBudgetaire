package com.gestionBudgetaire.api.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@DynamicUpdate
@Entity
@Table(name="mouvement")
public class Movement {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="projet_id")
	private Project project;
	
	@Column(name="nom")
	private String name;
	
	private String libelle;
	
	private double montant;
	
	@Column(name="type_mouvement")
	@Enumerated(EnumType.STRING)
	private TypeMovement type;
	
	@Column(name="date_mouvement")
	private LocalDate date;
	
	@Column(name="description_mouvement")
	private String description;
	
}
