/*  
 *  ** $Header:  UserDto.java, M Jeevan Kumar, 26/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* UserDto.java
* USAGE
* Data Transfer Layer for user
* 
* DESCRIPTION
* It is a user model used to transfer User Data between the layers.
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 26-12-12
 * */



package com.agentplannertool.frontend.user.dto;

public class UserDto {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	
	/*public UserDto(){
		
	}*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
