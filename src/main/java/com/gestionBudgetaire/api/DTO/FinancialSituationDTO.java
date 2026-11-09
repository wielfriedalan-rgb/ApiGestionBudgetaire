package com.gestionBudgetaire.api.DTO;

public class FinancialSituationDTO {

	private double totalEntrees;
	private double totalSorties;
	private double solde;
	private double budgetRestant;
	
	public FinancialSituationDTO(double totalEntrees, double totalSorties, double solde, double budgetRestant) {
		this.totalEntrees = totalEntrees;
		this.totalSorties = totalSorties;
		this.solde = solde;
		this.budgetRestant = budgetRestant;
	}
	
	public double getTotalEntrees() {return totalEntrees;}
	public double getTotalSorties() {return totalSorties;}
	public double getSolde() {return solde;}
	public double getBudgetRestant() {return budgetRestant;}
	
}
