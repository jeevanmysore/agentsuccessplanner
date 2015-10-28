/*  
 *  ** $Header:  IncomeGoalDto.java, M Jeevan Kumar, 28/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* IncomeGoalDto.java
* USAGE
* Data Transfer Object between layers.
* 
* DESCRIPTION
* It is responsible for handling View and Edit Income Goal records
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 28-12-12
 * */



package com.agentplannertool.frontend.setup.dto;

public class IncomeGoalDto {
	
	private double businessExpenses;
	private double personalExpenses;
	private double descretionaryIncome;
	private double savings;
	private double annualIncomeGoal;
	private String username;
	private int year;
	public double getBusinessExpenses() {
		return businessExpenses;
	}
	public void setBusinessExpenses(double businessExpenses) {
		this.businessExpenses = businessExpenses;
	}
	public double getPersonalExpenses() {
		return personalExpenses;
	}
	public void setPersonalExpenses(double personalExpenses) {
		this.personalExpenses = personalExpenses;
	}
	public double getDescretionaryIncome() {
		return descretionaryIncome;
	}
	public void setDescretionaryIncome(double descretionaryIncome) {
		this.descretionaryIncome = descretionaryIncome;
	}
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	public double getAnnualIncomeGoal() {
		return annualIncomeGoal;
	}
	public void setAnnualIncomeGoal(double annualIncomeGoal) {
		this.annualIncomeGoal = annualIncomeGoal;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	

}
