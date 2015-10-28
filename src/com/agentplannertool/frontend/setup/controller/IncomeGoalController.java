/*  
 *  ** $Header:  IncomeGoalController.java, M Jeevan Kumar, 28/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* IncomeGoalController.java
* USAGE
* Maintains IncomeGoal Operations
* 
* DESCRIPTION
* It is responsible for handling View and Edit Income Goal records
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

import com.agentplannertool.frontend.setup.dto.IncomeGoalDto;
import com.agentplannertool.frontend.setup.dto.PersonalExpDto;
import com.agentplannertool.frontend.setup.service.IncomeGoalService;
import com.agentplannertool.frontend.setup.service.PersonalExpService;



public class IncomeGoalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log=Logger.getLogger(IncomeGoalController.class);
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
				 IncomeGoalService incomeGoalService=new IncomeGoalService();
				 IncomeGoalDto incomeGoalDto=incomeGoalService.viewIncomeGoal(username, year);
				 if(incomeGoalDto!=null){					 
					 request.setAttribute("incomeGoal",incomeGoalDto);
					
					 if(agent.equalsIgnoreCase("web")){
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/incomeGoal.jsp");
						 rd.forward(request, response);
					 }
					 else{
						 RequestDispatcher rd=request.getRequestDispatcher("/mobile/incomeGoal.jsp");
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
				
				double businessExpenses=Double.valueOf(request.getParameter("businessExpenses"));
				double personalExpenses=Double.valueOf(request.getParameter("personalExpenses"));
				double descretionaryIncome=Double.valueOf(request.getParameter("decretionaryIncome"));
				double savings=Double.valueOf(request.getParameter("savings"));
				double annualIncome=Double.valueOf(request.getParameter("annualIncome"));
				
				Calendar cal=Calendar.getInstance();
				 int year=cal.get(Calendar.YEAR);
				 
				 IncomeGoalDto incomeGoalDto=new IncomeGoalDto();
				 incomeGoalDto.setUsername(username);
				 incomeGoalDto.setYear(year);
				 incomeGoalDto.setAnnualIncomeGoal(annualIncome);
				 incomeGoalDto.setBusinessExpenses(businessExpenses);
				 incomeGoalDto.setPersonalExpenses(personalExpenses);
				 incomeGoalDto.setDescretionaryIncome(descretionaryIncome);
				 incomeGoalDto.setSavings(savings);
				 
				 IncomeGoalService incomeGoalService=new IncomeGoalService();
				 String insert_result=incomeGoalService.editIncomeGoal(incomeGoalDto);
				 if(!insert_result.equalsIgnoreCase("success")){
						response.setStatus(400);
				  }	 			
			}
			catch(SQLException e){
				response.setStatus(400);
				log.error("Record Already exists, Error in inserting Personal Expenses");
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
