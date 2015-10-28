/*  
 *  ** $Header:  BusinessExpService.java, M Jeevan Kumar, 27/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* BusinessExpService.java
* USAGE
* Interacting with DAO
* 
* DESCRIPTION
* It is a service in the layer which 
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 27-12-12
 * */

package com.agentplannertool.frontend.setup.service;

import java.sql.Connection;

import com.agentplannertool.backend.dbutil.DBUtil;
import com.agentplannertool.backend.setup.dao.BusinessExpDao;
import com.agentplannertool.frontend.setup.dto.BusinessExpDto;

public class BusinessExpService {
	
	public String editBusinessExpenses(BusinessExpDto businessExpDto) throws Exception{
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();
		BusinessExpDao businessExpDao=new BusinessExpDao();
		String result=businessExpDao.updateBusinessExpToDB(con, businessExpDto);
		con.close();
		
		return result;
	}
	
	public BusinessExpDto viewBusinessExpenses(String username,int year) throws Exception{
		DBUtil util=new DBUtil();
		Connection con =util.getConnection();
		BusinessExpDao businessExpDao=new BusinessExpDao();
		BusinessExpDto businessExpDto=businessExpDao.viewBusinessExpFromDB(con, username, year);
		con.close();
		return businessExpDto;
	}

}
