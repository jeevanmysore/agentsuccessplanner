/*  
 *  ** $Header:  UserDao.java, M Jeevan Kumar, 26/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* UserDao.java
* USAGE
*Data Access Layer for User
* 
* DESCRIPTION
* It interacts with Database.
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 26-12-12
 * */

package com.agentplannertool.backend.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;



public class UserDao {
	private static Logger log=Logger.getLogger(UserDao.class);
	private String loggedUser=null;
	public String validateUser(Connection con,String user,String pwd)throws Exception{
		PreparedStatement pstmt=con.prepareStatement("SELECT lastname FROM USER WHERE username=? and password=? and activated=1");
		pstmt.setString(1,user);
		pstmt.setString(2,pwd);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			loggedUser=rs.getString(1);	
			System.out.println(user);
			log.info("User is Validated");
		}
		return loggedUser;
	}
		
	public int registerUser(Connection con, String user, String pwd,
			 String firstName, String lastName,String email,int activated,String hobby) throws Exception
	{
		Calendar cal=Calendar.getInstance();
		 int year=cal.get(Calendar.YEAR);
		
		String sql="INSERT INTO USER(username,password,firstname,lastname,email,activated,hobby) VALUES (?, ?, ?, ?, ?,1,?)";
		
		String sql1="INSERT INTO personal_expenses(username,year) VALUES('" +user+"',"+year+")";
		String sql2="INSERT INTO business_expenses(username,year)VALUES('" +user+"',"+year+")";
		String sql3="INSERT INTO income_goal(username,year) VALUES('" +user+"',"+year+")";
		String sql4="INSERT INTO commisions(username,year) VALUES('" +user+"',"+year+")";
		String sql5="INSERT INTO user_input(username,year) VALUES('" +user+"',"+year+")";
				
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user);
		pstmt.setString(2,pwd);
		pstmt.setString(3, firstName);
		pstmt.setString(4, lastName);
		pstmt.setString(5, email);
		pstmt.setString(6,hobby);
		int pstmtReturn=pstmt.executeUpdate();
		
		Statement stmt=con.createStatement();
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
		stmt.addBatch(sql4);
		stmt.addBatch(sql5);
		int[]r=stmt.executeBatch();
		System.out.println("kkk"+r.length);
		
		
		
		if(pstmtReturn==1 && r.length==5){
			return 1;
		}else{
			return 0;
		}
	}
	public String getPassword(Connection con,String email) throws Exception {
		String sql="SELECT PASSWORD FROM USER WHERE EMAIL=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,email);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		return rs.getString("password");
	else 
	return null;
	
	
}
	public int UpdateUser(Connection con, String firstName, String lastName,String username) throws Exception {
		String sql="UPDATE USER SET firstname=?,lastname=? WHERE USERNAME=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, username);
		int pstmtReturn=pstmt.executeUpdate();
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
		
	}
	public String getPasswordbyUsername(Connection con, String username) throws Exception {
		String sql="SELECT PASSWORD FROM USER WHERE USERNAME=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		return rs.getString("password");
	else 
	return null;
		
	}
	public int ChangePassword(Connection con, String newpassword,
			String username) throws Exception {
		String sql="UPDATE USER SET password=? WHERE USERNAME=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, newpassword);
		pstmt.setString(2, username);
		int pstmtReturn=pstmt.executeUpdate();
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
	}
	
	public int insertUkey(Connection con, String ukey,String username) throws SQLException {
		String sql="UPDATE USER SET ukey=? WHERE USERNAME=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,ukey);
		pstmt.setString(2,username);
		
		int pstmtReturn=pstmt.executeUpdate();
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
	}
	public int updateAccount(Connection con, String ukey) throws SQLException {
		String sql="UPDATE USER SET activated=1,ukey=null WHERE ukey=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,ukey);
			
		int pstmtReturn=pstmt.executeUpdate();
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
	}
	public int insertUkeyforPassword(Connection con, String ukey, String email) throws SQLException {
		String sql="UPDATE USER SET ukey=? WHERE EMAIL=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,ukey);
		pstmt.setString(2,email);
		
		int pstmtReturn=pstmt.executeUpdate();
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
	}
	public int updatePassword(Connection con, String ukey, String newpassword) throws SQLException {
		String sql="UPDATE USER SET password=?,ukey=null WHERE UKEY=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,newpassword);
		pstmt.setString(2, ukey);
			
		int pstmtReturn=pstmt.executeUpdate();
		
		if(pstmtReturn==1){
			return 1;
		}else{
			return 0;
		}
	}
	
}
