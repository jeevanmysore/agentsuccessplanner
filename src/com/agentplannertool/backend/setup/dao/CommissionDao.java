package com.agentplannertool.backend.setup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.agentplannertool.frontend.setup.dto.CommissionDto;

public class CommissionDao {
	
	public CommissionDto viewCommissionFromDB(Connection con,String username,int year)throws Exception{
		String sql="SELECT * from commisions where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		CommissionDto commissionDto=new CommissionDto();
		if(rs.next()){
			commissionDto.setHousePrice(rs.getDouble(1));
			commissionDto.setCommisionRate(rs.getDouble(2));
			commissionDto.setCommisionSplit(rs.getDouble(3));
			commissionDto.setCommissionPerTransaction(rs.getDouble(4));
			commissionDto.setProspectusRatio(rs.getDouble(5));
			
		}		
		return commissionDto;
	}
	
	
	public String saveCommissionToDB(Connection con,CommissionDto commissionDto)throws Exception{
		String insert_result="fail";
		String sql="UPDATE commisions set house_price=?,comission_rate=?,comission_split=?,comission_per_transaction=?,prospectus_ratio=? where username=? and year=?";
	
		
		
		double annualTransactions;
		double annualProspects;	
		
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setDouble(1,commissionDto.getHousePrice());
		pstmt.setDouble(2,commissionDto.getCommisionRate());
		pstmt.setDouble(3,commissionDto.getCommisionSplit());
		pstmt.setDouble(4,commissionDto.getCommissionPerTransaction());
		pstmt.setDouble(5,commissionDto.getProspectusRatio());
		pstmt.setString(6,commissionDto.getUsername());
		pstmt.setInt(7,commissionDto.getYear());
		
		int r=pstmt.executeUpdate();
		
		double annual_income=getIncomeGoalFromDB(commissionDto, con);
		System.out.println("income:"+annual_income);
		
		System.out.println("cpt :"+commissionDto.getCommissionPerTransaction());
		annualTransactions=annual_income/commissionDto.getCommissionPerTransaction();
		//annualProspects=annualTransactions*commissionDto.getProspectusRatio();
		
		//modified by jeevan
		
		String sql2="UPDATE user_input set comission_per_transaction=?,annual_transaction_needed=?where username=? and year=? ";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setDouble(1,commissionDto.getCommissionPerTransaction());
		pstmt2.setDouble(2,annualTransactions);
		//pstmt2.setDouble(3,annualProspects);
		pstmt2.setString(3,commissionDto.getUsername());
		pstmt2.setInt(4,commissionDto.getYear());
		
		
		/*String sql2="UPDATE user_input set comission_per_transaction=? where username=? and year=? ";
		
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setDouble(1,commissionDto.getCommissionPerTransaction());
		pstmt2.setDouble(2,annualTransactions);
		pstmt2.setDouble(3,annualProspects);
		pstmt2.setString(2,commissionDto.getUsername());
		pstmt2.setInt(3,commissionDto.getYear());*/
		int r1=pstmt2.executeUpdate();		
		if(r>0){			
			if(r1>0){
				insert_result="success";
			}
		}
		System.out.println(insert_result);
		return insert_result;
	}
	
	
	public double getIncomeGoalFromDB(CommissionDto commissionDto,Connection con)throws Exception{
		double income_goal=0.0;
		String sql="SELECT income_goal from user_input where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,commissionDto.getUsername());
		pstmt.setInt(2,commissionDto.getYear());
		ResultSet rs=pstmt.executeQuery();
		
		
		if(rs.next()){
			income_goal=rs.getDouble(1);
		}
		System.out.println("com incom :"+income_goal);
		return income_goal;		
	}

	
	
}
