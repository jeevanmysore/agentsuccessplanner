package com.agentplannertool.frontend.transaction.dto;

import java.util.Date;

public class TransactionDto {
	
	private String username;
	private int year;
	private int id;
	private Date date;
	private String trans_type;
	private double salesPrice;
	private double commissionEarned;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public double getCommissionEarned() {
		return commissionEarned;
	}
	public void setCommissionEarned(double commissionEarned) {
		this.commissionEarned = commissionEarned;
	}
	
	

}
