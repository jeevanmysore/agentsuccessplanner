package com.agentplannertool.frontend.setup.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.setup.dao.IncomeGoalDao;
import com.agentplannertool.frontend.setup.dto.IncomeGoalDto;

public class IncomeGoalService {
	
	
	public IncomeGoalDto viewIncomeGoal(String username,int year)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		IncomeGoalDao incomeGoalDao=new IncomeGoalDao();
		IncomeGoalDto incomeGoalDto=incomeGoalDao.viewIncomeGoalFromDB(con, username, year);
		con.close();
		return incomeGoalDto;
	}
	
	public String editIncomeGoal(IncomeGoalDto incomeGoalDto)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		IncomeGoalDao incomeGoalDao=new IncomeGoalDao();
		String result=incomeGoalDao.updateIncomeGoalToDB(incomeGoalDto, con);
		con.close();
		return result;
	}

}
