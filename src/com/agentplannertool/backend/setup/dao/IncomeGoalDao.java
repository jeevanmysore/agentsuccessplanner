package com.agentplannertool.backend.setup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.agentplannertool.frontend.setup.dto.IncomeGoalDto;

public class IncomeGoalDao {
	
	public IncomeGoalDto viewIncomeGoalFromDB(Connection con,String username,int year)throws Exception{
		String sql="SELECT * FROM income_goal where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		IncomeGoalDto incomeGoalDto=new IncomeGoalDto();
		if(rs.next()){
			incomeGoalDto.setBusinessExpenses(rs.getDouble(1));
			incomeGoalDto.setPersonalExpenses(rs.getDouble(2));
			incomeGoalDto.setDescretionaryIncome(rs.getDouble(3));
			incomeGoalDto.setSavings(rs.getDouble(4));
			incomeGoalDto.setAnnualIncomeGoal(rs.getDouble(5));
		}
		
		return incomeGoalDto;		
	}
	
	public String updateIncomeGoalToDB(IncomeGoalDto incomeGoalDto,Connection con)throws Exception{
		String insert_result="fail";
		String sql1="UPDATE income_goal set descretionary_income=?,savings=?,annual_income_goal=? where username=? and year=?";
		String sql2="UPDATE user_input set income_goal=? where username=? and year=? ";
		
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		
		// for PSTMT1
		
		pstmt1.setDouble(1,incomeGoalDto.getDescretionaryIncome());
		pstmt1.setDouble(2,incomeGoalDto.getSavings());
		pstmt1.setDouble(3,incomeGoalDto.getAnnualIncomeGoal());
		pstmt1.setString(4,incomeGoalDto.getUsername());
		pstmt1.setInt(5,incomeGoalDto.getYear());
		
		int r=pstmt1.executeUpdate();
		pstmt2.setDouble(1,incomeGoalDto.getAnnualIncomeGoal());
		pstmt2.setString(2,incomeGoalDto.getUsername());
		pstmt2.setInt(3,incomeGoalDto.getYear());		
		
		
		if(r>0){
			int r1=pstmt2.executeUpdate();
			if(r1>0){
				this.updateCommissionwhenIncomeGoalChanged(con, incomeGoalDto); // if user updates incomegoal, inorder to reflect changes in commission
				insert_result="success";
			}
		}	
		
		return insert_result;
	}
	
	
	public void updateCommissionwhenIncomeGoalChanged(Connection con,IncomeGoalDto incomeGoalDto)throws Exception{
		int r=0;
		String sql="SELECT comission_rate,comission_per_transaction,prospectus_ratio from commisions where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,incomeGoalDto.getUsername());
		pstmt.setInt(2,incomeGoalDto.getYear());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			double comissionRate=rs.getDouble(1);
			double comissionPerTransaction=rs.getDouble(2);
			double prospectRatio=rs.getDouble(3);
			double annualTransactions;
			double annualProspects;
			if(comissionRate!=0.0 && comissionPerTransaction!=0.0 ){
				String sql1="UPDATE user_input set annual_transaction_needed=?,annual_prospects_needed =? where username=? and year=? ";
				PreparedStatement pstmt2=con.prepareStatement(sql1);
				annualTransactions=incomeGoalDto.getAnnualIncomeGoal()/comissionPerTransaction;
				annualProspects=annualTransactions*prospectRatio;
				
				pstmt2.setDouble(1,annualTransactions);
				pstmt2.setDouble(2,annualProspects);
				pstmt2.setString(3,incomeGoalDto.getUsername());
				pstmt2.setInt(4,incomeGoalDto.getYear());
				
				 r=pstmt2.executeUpdate();
				
				
			}
		}
		
	}

}
