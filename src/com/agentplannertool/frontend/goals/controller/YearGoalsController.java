package com.agentplannertool.frontend.goals.controller;

import java.io.IOException;
import java.util.Calendar;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.frontend.goals.dto.GoalsDto;
import com.agentplannertool.frontend.goals.service.GoalsService;


public class YearGoalsController extends HttpServlet {
	private static Logger log=Logger.getLogger(YearGoalsController.class);
	private static final long serialVersionUID = 1L;
	private String agent;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try{
			agent=session.getAttribute("userAgent").toString();
				String username=session.getAttribute("username").toString();
				Calendar cal=Calendar.getInstance();
				 int year=cal.get(Calendar.YEAR);			
				 GoalsService goalService=new GoalsService();
				 GoalsDto goalsDto=goalService.viewProgress(username, year);
				 if(goalsDto!=null){	
					 System.out.println(goalsDto.getCommissionEarned());
					 System.out.println(goalsDto.getIncomeGoal());
					 System.out.println(goalsDto.getTransactionsClosed());
					 System.out.println(goalsDto.getTransactionsNeeded());
					 System.out.println(goalsDto.getProspectsNeeded());
					 
					 request.setAttribute("yearGoals",goalsDto);
					 
					
					 if(agent.equalsIgnoreCase("web")){
							
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/yearGoals.jsp");
						 rd.forward(request, response);
					 }
					 else{
						 RequestDispatcher rd=request.getRequestDispatcher("/mobile/yearGoals.jsp");
						 rd.forward(request, response);
					 }
				 }
			
			
			
			}
			catch (NullPointerException e) {
				response.sendRedirect("/agentsuccessplanner/index.jsp");
				e.printStackTrace();
			}
			catch(Exception e){
				
			}
		}

	

}
