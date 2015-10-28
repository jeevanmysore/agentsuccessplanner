package com.agentplannertool.frontend.setup.dto;

public class CommissionDto {
	private String username;
	private int year;
	private double housePrice;
	private double commisionRate;	
	private double commisionSplit;
	private double commissionPerTransaction;
	private double prospectusRatio;
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
	public double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(double housePrice) {
		this.housePrice = housePrice;
	}
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}
	
	public double getCommisionSplit() {
		return commisionSplit;
	}
	public void setCommisionSplit(double commisionSplit) {
		this.commisionSplit = commisionSplit;
	}
	
	public double getProspectusRatio() {
		return prospectusRatio;
	}
	public void setProspectusRatio(double prospectusRatio) {
		this.prospectusRatio = prospectusRatio;
	}
	public double getCommissionPerTransaction() {
		return commissionPerTransaction;
	}
	public void setCommissionPerTransaction(double commissionPerTransaction) {
		this.commissionPerTransaction = commissionPerTransaction;
	}
	
	
	
	

}
