/*  
 *  ** $Header:  LoginService.java, M Jeevan Kumar, 26/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* UserDto.java
* USAGE
* All the business logic logic for User operations done here.
* 
* DESCRIPTION
* It is a service layer which implements business logic for user level operations
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 26-12-12
 * */


package com.agentplannertool.frontend.user.service;

import java.sql.Connection;
import java.sql.SQLException;


import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.user.dao.UserDao;

import com.agentplannertool.frontend.user.dto.UserDto;

public class LoginService{
	
	
	public UserDto validateUser(String user, String pwd)throws Exception {
		
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		String result=userDao.validateUser(con, user, pwd);
		UserDto userDto=new UserDto();
		userDto.setLastName(result);
		con.close();
		return userDto;
	}
	
	public Boolean registerUser(String user, String pwd,
			String firstName, String lastName,String email,int activated,String hobby) throws Exception {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.registerUser(con, user, pwd,firstName,lastName,email,activated,hobby);
		con.close();
		if(flag==1){
			return true;
		}else{
			return false;
		}
	}

	

	public String getPassword(String email) throws Exception {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		String password=userDao.getPassword(con,email);
		return password;
	}

	public Boolean UpdateUser(String firstName, String lastName,String username) throws Exception {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.UpdateUser(con, firstName,lastName,username);
		con.close();
		if(flag==1){
			return true;
		}else{
			return false;
		}
		
	}

	public String getPasswordByUsername(String username) throws Exception {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		String password=userDao.getPasswordbyUsername(con,username);
		return password;
		
	}

	public Boolean ChangePassword(String newpassword, String username) throws Exception {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.ChangePassword(con, newpassword,username);
		con.close();
		if(flag==1){
			return true;
		}else{
			return false;
		}
	}

	

	public void insertUkey(String ukey,String username) throws SQLException {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.insertUkey(con,ukey,username);
		con.close();
		
	}

	public static Boolean updateUserAccount(String ukey) throws SQLException {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.updateAccount(con,ukey);
		con.close();
		if(flag==1){
			return true;
		}else{
			return false;
		}
		
	}

	public void insertUkeyforPassword(String ukey, String email) throws SQLException {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.insertUkeyforPassword(con,ukey,email);
		con.close();
	}

	public static boolean updateUserPassword(String ukey, String newpassword) throws SQLException {
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();		
		UserDao userDao=new UserDao();
		int flag=userDao.updatePassword(con,ukey,newpassword);
		con.close();
		if(flag==1){
			return true;
		}else{
			return false;
		}
	}
	

}
