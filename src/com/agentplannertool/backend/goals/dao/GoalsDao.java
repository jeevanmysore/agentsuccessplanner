package com.agentplannertool.backend.goals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.agentplannertool.frontend.goals.dto.GoalsDto;
import com.agentplannertool.frontend.setup.dto.CommissionDto;


public class GoalsDao {
	
	
	public GoalsDto  getProgressFromDB(Connection con,String username,int year)throws Exception{
		
		String sql="SELECT * FROM user_input where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		GoalsDto goalsDto=new GoalsDto();
		if(rs.next()){
		     goalsDto.setIncomeGoal(rs.getDouble(1));
		     goalsDto.setTransactionsNeeded(rs.getDouble(3));
		     goalsDto.setProspectsNeeded(rs.getDouble(4));
		     goalsDto.setYear(rs.getInt(6));
		}
		return goalsDto;
	}
	
	
	public Map getComissionEarnedFromDB(Connection con,String username,int year)throws Exception{
		
		String sql="SELECT count(*),sum(comission_earned) from transactions where username=? ";
		Map<String,Object> commissionMap=new HashMap<String, Object>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
	//	pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			commissionMap.put("transactions",rs.getInt(1));
			commissionMap.put("commission", rs.getDouble(2));
		}
		return commissionMap;
		
	}
	public CommissionDto  getCommissionPerTransaction(Connection con,String username,int year)throws Exception{
		String sql="SELECT comission_per_transaction,prospectus_ratio from commisions where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		CommissionDto comDto=new CommissionDto();
		if(rs.next()){
			comDto.setCommissionPerTransaction(rs.getDouble(1));
			comDto.setProspectusRatio(rs.getDouble(2));
		}
		return comDto;
	}

}
