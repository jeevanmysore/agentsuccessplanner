package com.agentplannertool.frontend.transaction.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.transaction.dao.EditTransactionDao;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;

public class EditTransactionService {
	
	public TransactionDto getTransaction(int id)throws Exception{
		
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		EditTransactionDao transDao=new EditTransactionDao();
		TransactionDto transDto=transDao.getTransactionFromDB(con, id);
		con.close();
		return transDto;
	}
	
	
	public String editTransaction(TransactionDto transDto)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		EditTransactionDao transDao=new EditTransactionDao();
		String result=transDao.editTransactionToDB(con, transDto);
		con.close();
		return result;
		
	}
	

}
