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

import com.agentplannertool.frontend.setup.dto.PersonalExpDto;
import com.agentplannertool.frontend.setup.service.PersonalExpService;



public class PersonalExpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(PersonalExpController.class);
	private String agent;
	
    public PersonalExpController() {
        super();       
        log.info("inside PersonalExpController");
    }

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
				 PersonalExpService personalExpService=new PersonalExpService();
				 PersonalExpDto personalExpDto=personalExpService.viewPersonalExp(username, year);
				 if(personalExpDto!=null){					 
					 request.setAttribute("personalExpenses",personalExpDto);
					 
					if(agent.equalsIgnoreCase("web")){
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/personalExpenses.jsp");
						 rd.forward(request, response);
					}
				 else{
					 RequestDispatcher rd=request.getRequestDispatcher("/mobile/personalExpenses.jsp");
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
    
    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			try{
				double pay1=Double.valueOf(request.getParameter("pay1"));
				double pay2=Double.valueOf(request.getParameter("pay2"));
				double pay3=Double.valueOf(request.getParameter("pay3"));
				double pay4=Double.valueOf(request.getParameter("pay4"));
				double pay5=Double.valueOf(request.getParameter("pay5"));
				double pay6=Double.valueOf(request.getParameter("pay6"));
				double pay7=Double.valueOf(request.getParameter("pay7"));
				double pay8=Double.valueOf(request.getParameter("pay8"));
				double pay9=Double.valueOf(request.getParameter("pay9"));
				double pay10=Double.valueOf(request.getParameter("pay10"));
				double pay11=Double.valueOf(request.getParameter("pay11"));
				double pay12=Double.valueOf(request.getParameter("pay12"));
				double total=Double.valueOf(request.getParameter("total"));
				Calendar cal=Calendar.getInstance();
				 int year=cal.get(Calendar.YEAR);
				 
				PersonalExpDto personalExpDto=new PersonalExpDto();
				personalExpDto.setUsername(username);
				
				
				personalExpDto.setPay1(pay1);
				personalExpDto.setPay2(pay2);
				personalExpDto.setPay3(pay3);
				personalExpDto.setPay4(pay4);
				personalExpDto.setPay5(pay5);
				personalExpDto.setPay6(pay6);
				personalExpDto.setPay7(pay7);
				personalExpDto.setPay8(pay8);
				personalExpDto.setPay9(pay9);
				personalExpDto.setPay10(pay10);
				personalExpDto.setPay11(pay11);
				personalExpDto.setPay12(pay12);
				personalExpDto.setTotal(total);
				personalExpDto.setYear(year);
				
				PersonalExpService personalExpService=new PersonalExpService();
				String insert_result=personalExpService.editPersonalExpenses(personalExpDto);
				if(!insert_result.equalsIgnoreCase("success")){
					response.setStatus(400);
				}
			}
			catch(SQLException e){
				response.setStatus(400);
				log.error("Record Already exists, Error in inserting Personal Expenses");
				
			}
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");e.printStackTrace();
			 }
			catch(Exception e){
				response.setStatus(401);
				log.error("Failed to insert PersonalExp Details");
				e.printStackTrace();
			}
		}
	}
															

}
