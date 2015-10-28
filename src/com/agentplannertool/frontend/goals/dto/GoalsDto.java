package com.agentplannertool.frontend.goals.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GoalsDto {
	private String username;
	private int year;
	private double incomeGoal;
	private double transactionsNeeded;
	private double transactionsClosed;
	private double commissionEarned;	
	private double prospectsNeeded;	
	private double yearlyTransaction;
	private double monthlyTransaction;
	private double weeklyTransaction;	
	private double annualProspectsRemained;	
	private double monthlyProspects;
	private double weeklyProspects;
	private double dailyProspects;
	private double monthlyProspectsRemained;
	private double weeklyProspectsRemained;
	private double incomeNeeded;
	
	

	
		

	public  double round(double value) {
	   int places=2;

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
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



	public double getIncomeGoal() {
		return round(incomeGoal);
	}



	public void setIncomeGoal(double incomeGoal) {
		this.incomeGoal = incomeGoal;
	}



	public double getTransactionsNeeded() {
		return round(transactionsNeeded);
	}



	public void setTransactionsNeeded(double transactionsNeeded) {
		this.transactionsNeeded = transactionsNeeded;
	}



	public double getTransactionsClosed() {
		return round(transactionsClosed);
	}



	public void setTransactionsClosed(double transactionsClosed) {
		this.transactionsClosed = transactionsClosed;
	}



	public double getCommissionEarned() {
		return round(commissionEarned);
	}



	public void setCommissionEarned(double commissionEarned) {
		this.commissionEarned = commissionEarned;
	}



	public double getProspectsNeeded() {
		return round(prospectsNeeded);
	}



	public void setProspectsNeeded(double prospectsNeeded) {
		this.prospectsNeeded = prospectsNeeded;
	}



	public double getYearlyTransaction() {
		return round(yearlyTransaction);
	}



	public void setYearlyTransaction(double yearlyTransaction) {
		this.yearlyTransaction = yearlyTransaction;
	}



	public double getMonthlyTransaction() {
		return round(monthlyTransaction);
	}



	public void setMonthlyTransaction(double monthlyTransaction) {
		this.monthlyTransaction = monthlyTransaction;
	}



	public double getWeeklyTransaction() {
		return round(weeklyTransaction);
	}



	public void setWeeklyTransaction(double weeklyTransaction) {
		this.weeklyTransaction = weeklyTransaction;
	}



	public double getAnnualProspectsRemained() {
		return round(annualProspectsRemained);
	}



	public void setAnnualProspectsRemained(double annualProspectsRemained) {
		this.annualProspectsRemained = annualProspectsRemained;
	}



	public double getMonthlyProspects() {
		return round(monthlyProspects);
	}



	public void setMonthlyProspects(double monthlyProspects) {
		this.monthlyProspects = monthlyProspects;
	}



	public double getWeeklyProspects() {
		return round(weeklyProspects);
	}



	public void setWeeklyProspects(double weeklyProspects) {
		this.weeklyProspects = weeklyProspects;
	}



	public double getDailyProspects() {
		return round(dailyProspects);
	}



	public void setDailyProspects(double dailyProspects) {
		this.dailyProspects = dailyProspects;
	}



	public double getMonthlyProspectsRemained() {
		return round(monthlyProspectsRemained);
	}



	public void setMonthlyProspectsRemained(double monthlyProspectsRemained) {
		this.monthlyProspectsRemained = monthlyProspectsRemained;
	}



	public double getWeeklyProspectsRemained() {
		return round(weeklyProspectsRemained);
	}



	public void setWeeklyProspectsRemained(double weeklyProspectsRemained) {
		this.weeklyProspectsRemained = weeklyProspectsRemained;
	}



	public double getIncomeNeeded() {
		return round(incomeNeeded);
	}



	public void setIncomeNeeded(double incomeNeeded) {
		this.incomeNeeded = incomeNeeded;
	}
	
	
	
	


	



	

	

}
