package com.agentplannertool.frontend.setup.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.setup.dao.CommissionDao;
import com.agentplannertool.frontend.setup.dto.CommissionDto;

public class CommissionService {
	
	
	public CommissionDto viewCommission(String username,int year)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		CommissionDao commissionDao=new CommissionDao();
		CommissionDto commissionDto=commissionDao.viewCommissionFromDB(con, username, year);
		return commissionDto;
	}
	
	
	public String saveCommission(CommissionDto commissionDto)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		CommissionDao commissionDao=new CommissionDao();
		String result=commissionDao.saveCommissionToDB(con, commissionDto);
		con.close();
		return result;
	}

}
