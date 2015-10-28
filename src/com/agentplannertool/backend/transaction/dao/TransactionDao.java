package com.agentplannertool.backend.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.agentplannertool.frontend.setup.dto.CommissionDto;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;

public class TransactionDao {
	public String saveTransactionToDB(Connection con,TransactionDto transDto)throws Exception{
		System.out.println("in dao");
		String insert_result="fail";
		String sql="INSERT INTO transactions(date,type,sales_price,comission_earned,username) values (?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setDate(1, (Date) transDto.getDate());
		pstmt.setString(2,transDto.getTrans_type());
		pstmt.setDouble(3,transDto.getSalesPrice());
		pstmt.setDouble(4,transDto.getCommissionEarned());
		pstmt.setString(5,transDto.getUsername());
		
		int r=pstmt.executeUpdate();
		
		/*  modified by jeevan on 11-01 */
		 
		
		
		if(r>0){
			int r1=this.saveAnnualData(con, transDto);
			if(r1>0)
				insert_result="success";
		}
		System.out.println(insert_result);
		return insert_result;
		
	}
	
	
	// Added on 11-01.
	
	public CommissionDto getCommissionDetails(Connection con,TransactionDto transDto)throws Exception{
		String sql="SELECT comission_per_transaction,prospectus_ratio from commisions where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,transDto.getUsername());
		pstmt.setInt(2,transDto.getYear());
		ResultSet rs=pstmt.executeQuery();
		CommissionDto comDto=new CommissionDto();
		if(rs.next()){
			comDto.setCommissionPerTransaction(rs.getDouble(1));
			comDto.setProspectusRatio(rs.getDouble(2));
		}
		
		return comDto;
	}
	
	public double getIncomeGoalFromDB(TransactionDto transDto,Connection con)throws Exception{
		double income_goal=0.0;
		String sql="SELECT income_goal from user_input where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,transDto.getUsername());
		pstmt.setInt(2,transDto.getYear());
		ResultSet rs=pstmt.executeQuery();		
		if(rs.next()){
			income_goal=rs.getDouble(1);
		}
		System.out.println("incomegoal :"+income_goal);
		return income_goal;		
	}
	
	
	public int saveAnnualData(Connection con,TransactionDto transDto) throws Exception{
		int res=0;
		String sql="UPDATE user_input set annual_transaction_needed=?,annual_prospects_needed =? where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		double incomeGoal=this.getIncomeGoalFromDB(transDto, con);
		CommissionDto comDto=this.getCommissionDetails(con, transDto);
		Map comMap=this.getComissionEarnedFromDB(con,transDto.getUsername(),transDto.getYear());
		double commissionEarned=(Double) comMap.get("commission");
		double incomeNeeded=incomeGoal-commissionEarned;
		System.out.println("incomeNeeded "+incomeNeeded);
	    double annualTransactions=incomeGoal/comDto.getCommissionPerTransaction();
	    System.out.println("AnnualTransactions: "+annualTransactions);
	    double annualProspects=annualTransactions*comDto.getProspectusRatio();
	    System.out.println("annual prospects: "+annualProspects);
	    
	    pstmt.setDouble(1,annualTransactions);
	    pstmt.setDouble(2, annualProspects);
	    pstmt.setString(3,transDto.getUsername());
	    pstmt.setInt(4,transDto.getYear());
	    int r=pstmt.executeUpdate();
	    if(r>0)
	    	res=1;
	    return res;
		
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
	
	
	public Double getCommissionPerTransaction(Connection con,String username,int year)throws Exception{
		String sql="SELECT comission_per_transaction from user_input where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setInt(2, year);
		ResultSet rs=pstmt.executeQuery();
		Double commission=0.0;
		if(rs.next()){
			commission=rs.getDouble(1);
		}
		return commission;
	}
}
