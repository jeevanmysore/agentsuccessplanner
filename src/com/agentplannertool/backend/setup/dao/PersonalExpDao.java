package com.agentplannertool.backend.setup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agentplannertool.frontend.setup.dto.PersonalExpDto;




public class PersonalExpDao {
	
	/*
	public String insertPersonsalExpToDB(Connection con,PersonalExpDto personalExpDto) throws Exception{
		String sql="INSERT INTO personal_expenses(mortgage,heat,water,electricity,groceries,dining,car,entertainment,child_care,education,others1,others2,total,username,year) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String insert_result="fail";
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1,personalExpDto.getPay1());
			pstmt.setDouble(2,personalExpDto.getPay2());
			pstmt.setDouble(3,personalExpDto.getPay3());
			pstmt.setDouble(4,personalExpDto.getPay4());
			pstmt.setDouble(5,personalExpDto.getPay5());
			pstmt.setDouble(6,personalExpDto.getPay6());
			pstmt.setDouble(7,personalExpDto.getPay7());
			pstmt.setDouble(8,personalExpDto.getPay8());
			pstmt.setDouble(9,personalExpDto.getPay9());
			pstmt.setDouble(10,personalExpDto.getPay10());
			pstmt.setDouble(11,personalExpDto.getPay11());
			pstmt.setDouble(12,personalExpDto.getPay12());
			pstmt.setDouble(13,personalExpDto.getTotal());
			pstmt.setString(14,personalExpDto.getUsername());
			pstmt.setInt(15,personalExpDto.getYear());
			
			int r=pstmt.executeUpdate();
			if(r>0){
				insert_result="success";
			}
		
		return insert_result;
	}*/

	public String updatePersonsalExpToDB(Connection con,PersonalExpDto personalExpDto) throws Exception{
		String sql="UPDATE personal_expenses set mortgage=?,heat=?,water=?,electricity=?,groceries=?,dining=?,car=?,entertainment=?,child_care=?,education=?,others1=?,others2=?,total=? where username=? and year=?";
		String update_result="fail";
		String sql2="UPDATE income_goal set personal_expenses=? where username=? and year=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			PreparedStatement pstmt2=con.prepareStatement(sql2);// for updating personal_exp total to income_goals.
			pstmt.setDouble(1,personalExpDto.getPay1());
			pstmt.setDouble(2,personalExpDto.getPay2());
			pstmt.setDouble(3,personalExpDto.getPay3());
			pstmt.setDouble(4,personalExpDto.getPay4());
			pstmt.setDouble(5,personalExpDto.getPay5());
			pstmt.setDouble(6,personalExpDto.getPay6());
			pstmt.setDouble(7,personalExpDto.getPay7());
			pstmt.setDouble(8,personalExpDto.getPay8());
			pstmt.setDouble(9,personalExpDto.getPay9());
			pstmt.setDouble(10,personalExpDto.getPay10());
			pstmt.setDouble(11,personalExpDto.getPay11());
			pstmt.setDouble(12,personalExpDto.getPay12());
			pstmt.setDouble(13,personalExpDto.getTotal());
			pstmt.setString(14,personalExpDto.getUsername());
			pstmt.setInt(15,personalExpDto.getYear());
			
			
			
			
			pstmt2.setDouble(1,personalExpDto.getTotal());
			pstmt2.setString(2,personalExpDto.getUsername());
			pstmt2.setInt(3,personalExpDto.getYear());
			int r=pstmt.executeUpdate();
			if(r>0){
				int r1=pstmt2.executeUpdate();
				if(r1>0){
					update_result="success";
					
				}
			}
		
		return update_result;
	}
	
	public PersonalExpDto viewPersonalExpFromDB(Connection con,String username,int year) throws Exception{
		String sql="SELECT * FROM personal_expenses where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		PersonalExpDto personalExpDto=new PersonalExpDto();
		if(rs.next()){
			personalExpDto.setPay1(rs.getDouble(1));
			personalExpDto.setPay2(rs.getDouble(2));
			personalExpDto.setPay3(rs.getDouble(3));
			personalExpDto.setPay4(rs.getDouble(4));
			personalExpDto.setPay5(rs.getDouble(5));
			personalExpDto.setPay6(rs.getDouble(6));
			personalExpDto.setPay7(rs.getDouble(7));
			personalExpDto.setPay8(rs.getDouble(8));
			personalExpDto.setPay9(rs.getDouble(9));
			personalExpDto.setPay10(rs.getDouble(10));
			personalExpDto.setPay11(rs.getDouble(11));
			personalExpDto.setPay12(rs.getDouble(12));
			personalExpDto.setTotal(rs.getDouble(13));
			personalExpDto.setUsername(rs.getString(14));
			personalExpDto.setYear(rs.getInt(15));
		}
		return personalExpDto;

	}

}
