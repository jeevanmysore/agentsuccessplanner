package com.agentplannertool.frontend.goals.service;

import java.sql.Connection;
import java.util.Map;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.goals.dao.GoalsDao;
import com.agentplannertool.frontend.goals.dto.GoalsDto;
import com.agentplannertool.frontend.setup.dto.CommissionDto;


public class GoalsService {
	
	public GoalsDto viewProgress(String username,int year)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		GoalsDao goalsDao=new GoalsDao();
		GoalsDto goalsDto=goalsDao.getProgressFromDB(con, username, year);
		Map commissionMap=goalsDao.getComissionEarnedFromDB(con, username, year);
		double commissionEarned=(Double) commissionMap.get("commission");
		CommissionDto comDto=goalsDao.getCommissionPerTransaction(con, username, year);
		double incomeNeeded=goalsDto.getIncomeGoal()-commissionEarned;
		System.out.println("incomeNeede: "+incomeNeeded);
		double transactionNeeded=incomeNeeded/comDto.getCommissionPerTransaction();
		double prospectsNeeded=transactionNeeded*comDto.getProspectusRatio();
		System.out.println("trans "+transactionNeeded);
		System.out.println(prospectsNeeded);
		double totalTransactionsNeeded=goalsDto.getIncomeGoal()/comDto.getProspectusRatio();
		System.out.println("transactions Needed"+goalsDto.getTransactionsNeeded());
		
		//goalsDto.setTransactionsNeeded(totalTransactionsNeeded);
		goalsDto.setCommissionEarned((Double) commissionMap.get("commission"));
		goalsDto.setTransactionsClosed((Integer) commissionMap.get("transactions"));	
		goalsDto.setIncomeNeeded(incomeNeeded);
		goalsDto.setYearlyTransaction(transactionNeeded);
		goalsDto.setAnnualProspectsRemained(prospectsNeeded);
		goalsDto.setMonthlyTransaction(goalsDto.getYearlyTransaction()/12);
		goalsDto.setWeeklyTransaction(goalsDto.getYearlyTransaction()/52);
		goalsDto.setMonthlyProspectsRemained(goalsDto.getAnnualProspectsRemained()/12);
		goalsDto.setWeeklyProspectsRemained(goalsDto.getAnnualProspectsRemained()/52);
		goalsDto.setDailyProspects(goalsDto.getAnnualProspectsRemained()/365);
		
		return goalsDto;		
	}
	
}
