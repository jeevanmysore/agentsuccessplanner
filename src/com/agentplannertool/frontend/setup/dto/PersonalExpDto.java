package com.agentplannertool.frontend.setup.dto;

import java.text.DecimalFormat;

public class PersonalExpDto {
	private String username;
	private static double pay1;
	private double pay2;
	private double pay3;
	private double pay4;
	private double pay5;
	private double pay6;
	private double pay7;
	private double pay8;
	private double pay9;
	private double pay10;
	private double pay11;
	private double pay12;
	private double total;
	private int year;
	
	 DecimalFormat decim = new DecimalFormat("#.00");
	
	 
	// For getting digits after Decimal Point
	
			
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getPay1() {
		pay1=Double.parseDouble(decim.format(pay1));
		return pay1;
	}
	public void setPay1(double pay1) {
		PersonalExpDto.pay1 = pay1;
	}
	public double getPay2() {
		return pay2;
	}
	public void setPay2(double pay2) {
		this.pay2 = pay2;
	}
	public double getPay3() {
		return pay3;
	}
	public void setPay3(double pay3) {
		this.pay3 = pay3;
	}
	public double getPay4() {
		return pay4;
	}
	public void setPay4(double pay4) {
		this.pay4 = pay4;
	}
	public double getPay5() {
		return pay5;
	}
	public void setPay5(double pay5) {
		this.pay5 = pay5;
	}
	public double getPay6() {
		return pay6;
	}
	public void setPay6(double pay6) {
		this.pay6 = pay6;
	}
	public double getPay7() {
		return pay7;
	}
	public void setPay7(double pay7) {
		this.pay7 = pay7;
	}
	public double getPay8() {
		return pay8;
	}
	public void setPay8(double pay8) {
		this.pay8 = pay8;
	}
	public double getPay9() {
		return pay9;
	}
	public void setPay9(double pay9) {
		this.pay9 = pay9;
	}
	public double getPay10() {
		return pay10;
	}
	public void setPay10(double pay10) {
		this.pay10 = pay10;
	}
	public double getPay11() {
		return pay11;
	}
	public void setPay11(double pay11) {
		this.pay11 = pay11;
	}
	public double getPay12() {
		return pay12;
	}
	public void setPay12(double pay12) {
		this.pay12 = pay12;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	

}
