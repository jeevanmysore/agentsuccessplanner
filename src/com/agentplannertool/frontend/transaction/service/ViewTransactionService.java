package com.agentplannertool.frontend.transaction.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.transaction.dao.ViewTransactionDao;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;

public class ViewTransactionService {
	
	public ArrayList<TransactionDto> viewTransactions(String username)throws Exception{
		DBUtil util=new DBUtil();
		Connection con=util.getConnection();
		ViewTransactionDao transDao=new ViewTransactionDao();
		ArrayList<TransactionDto> list=transDao.getTransactionsFromDB(username, con);
		con.close();
		return list;
	}

}
