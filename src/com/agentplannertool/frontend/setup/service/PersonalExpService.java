package com.agentplannertool.frontend.setup.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.setup.dao.PersonalExpDao;

import com.agentplannertool.frontend.setup.dto.PersonalExpDto;

public class PersonalExpService {
	

	public String editPersonalExpenses(PersonalExpDto personalExpDto) throws Exception
	{
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();
		PersonalExpDao personalExpDao=new PersonalExpDao();
		String result=personalExpDao.updatePersonsalExpToDB(con, personalExpDto);
		con.close();
		return result;
	}
	
	public PersonalExpDto viewPersonalExp(String username,int year) throws Exception{
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();
		PersonalExpDao personalExpDao=new PersonalExpDao();
		PersonalExpDto personalExpDto=personalExpDao.viewPersonalExpFromDB(con, username, year);
		return personalExpDto;
	}
}
