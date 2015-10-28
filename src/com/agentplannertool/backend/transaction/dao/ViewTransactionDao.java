package com.agentplannertool.backend.transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;

public class ViewTransactionDao {
	
	public ArrayList<TransactionDto> getTransactionsFromDB(String username,Connection con) throws Exception{
		
		String sql="SELECT * FROM transactions where username=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		ResultSet rs=pstmt.executeQuery();
		ArrayList<TransactionDto> list=new ArrayList<TransactionDto>();
		final String OLD_FORMAT = "yyyy/MM/dd";
		final String NEW_FORMAT = "MM/dd/yyyy";
		while(rs.next()){
			TransactionDto transDto=new TransactionDto();
			transDto.setId(rs.getInt(1));
			//transDto.setDate(rs.getDate(2));			
			
			
			transDto.setDate(rs.getDate(2));		
			transDto.setTrans_type(rs.getString(3));
			transDto.setSalesPrice(rs.getDouble(4));
			transDto.setCommissionEarned(rs.getDouble(5));
			list.add(transDto);			
		}
		return list;		
	}

}
