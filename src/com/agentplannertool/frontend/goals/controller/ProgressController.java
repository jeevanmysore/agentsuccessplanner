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
import com.agentplannertool.frontend.setup.dto.CommissionDto;
import com.agentplannertool.frontend.setup.service.CommissionService;


public class ProgressController extends HttpServlet {
	private static Logger log=Logger.getLogger(ProgressController.class);
	private String agent;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		
			agent=session.getAttribute("userAgent").toString();
			Calendar cal=Calendar.getInstance();
			 int year=cal.get(Calendar.YEAR);
			 try{
				 String username=session.getAttribute("username").toString();
				 GoalsService goalService=new GoalsService();
				  GoalsDto goalsDto=goalService.viewProgress(username, year);
				 if(goalsDto!=null){	
					 System.out.println(goalsDto.getCommissionEarned());
					 System.out.println(goalsDto.getIncomeGoal());
					 System.out.println(goalsDto.getTransactionsClosed());
					 System.out.println("tranactions Needed12"+goalsDto.getTransactionsNeeded());
					 System.out.println(goalsDto.getProspectsNeeded());					 
					 request.setAttribute("progress",goalsDto);				 
					 if(agent.equalsIgnoreCase("web")){
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/progress.jsp");
						 rd.forward(request, response);	
					 }
					 else{
						 RequestDispatcher rd=request.getRequestDispatcher("/mobile/progress.jsp");
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
				 e.printStackTrace();
			 }
			 
			
		
		
	}

	
	

}
