package com.agentplannertool.frontend.transaction.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.transaction.dao.TransactionDao;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;

public class TransactionService {
	
	
	public String saveTransaction(TransactionDto transDto)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		TransactionDao transDao=new TransactionDao();
		String result=transDao.saveTransactionToDB(con, transDto);
		System.out.println(result);
		con.close();
		return result;
	}
	
	
	public Double getCommissionPerTransFromDao(String username,int year)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		TransactionDao transDao=new TransactionDao();
		Double commission=transDao.getCommissionPerTransaction(con, username, year);
		return commission;
	}

}
