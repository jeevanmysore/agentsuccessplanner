/*  
 *  ** $Header:  IncomeGoalController.java, M Jeevan Kumar, 28/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* CommissioController.java
* USAGE
* Handles Commission operations
* 
* DESCRIPTION
* It handles all the operations related to Commission 
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 28-12-12
 * */



package com.agentplannertool.frontend.setup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.backend.setup.dao.CommissionDao;
import com.agentplannertool.frontend.setup.dto.CommissionDto;
import com.agentplannertool.frontend.setup.dto.IncomeGoalDto;
import com.agentplannertool.frontend.setup.service.CommissionService;
import com.agentplannertool.frontend.setup.service.IncomeGoalService;

public class CommissionController extends HttpServlet {
	private static Logger log=Logger.getLogger(CommissionController.class);
	
	private static final long serialVersionUID = 1L;
	
    private String agent;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		agent=session.getAttribute("userAgent").toString();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			Calendar cal=Calendar.getInstance();
			 int year=cal.get(Calendar.YEAR);
			 try{
				 CommissionService commissionService=new CommissionService();
				  CommissionDto commissionDto=commissionService.viewCommission(username, year);
				 
				 if(commissionDto!=null){					 
					 request.setAttribute("commission",commissionDto);	
					 if(agent.equalsIgnoreCase("web")){
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/commision.jsp");
						 rd.forward(request, response);		
					 }
					 else{
						 RequestDispatcher rd=request.getRequestDispatcher("/mobile/commision.jsp");
						 rd.forward(request, response);		
					 }
				 }
			 }
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
			 catch(Exception e){
				 log.error(e.toString());
			 }
			 
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			try{
				double housePrice=Double.valueOf(request.getParameter("housePrice"));
				double commissionRate=Double.valueOf(request.getParameter("commissionRate"));
				double commissionSplit=Double.valueOf(request.getParameter("commissionSplit"));
				double commissionPerTransaction=Double.valueOf(request.getParameter("commissionPerTransaction"));
				double prospectRatio=Double.valueOf(request.getParameter("prospectRatio"));
				
				Calendar cal=Calendar.getInstance();
				 int year=cal.get(Calendar.YEAR);
				 CommissionDto commissionDto=new CommissionDto();
				 commissionDto.setHousePrice(housePrice);
				 commissionDto.setCommisionRate(commissionRate);
				 commissionDto.setCommisionSplit(commissionSplit);
				 commissionDto.setCommissionPerTransaction(commissionPerTransaction);
				 commissionDto.setProspectusRatio(prospectRatio);
				 commissionDto.setUsername(username);
				 commissionDto.setYear(year);
				 
				 CommissionService commissionService=new CommissionService();
				 String insert_result= commissionService.saveCommission(commissionDto);
				 if(!insert_result.equalsIgnoreCase("success")){
						response.setStatus(400);
				  }	 
			}
			catch(SQLException e){
				response.setStatus(400);
				log.error("Record Already exists, Error in inserting Commission Details");
				e.printStackTrace();
			}
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
			catch(Exception e){
				e.printStackTrace();
				response.setStatus(401);
				log.error("Failed to insert IncomeGoal Details");
			}

		}
		
	}

}
