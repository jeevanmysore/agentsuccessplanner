package com.agentplannertool.frontend.transaction.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.frontend.transaction.dto.TransactionDto;
import com.agentplannertool.frontend.transaction.service.EditTransactionService;
import com.agentplannertool.frontend.transaction.service.TransactionService;


public class EditTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(EditTransactionController.class);
       
    private String agent;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		agent=session.getAttribute("userAgent").toString();
		String username=session.getAttribute("username").toString();
		int id=Integer.parseInt(request.getParameter("id"));
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			try{
				EditTransactionService transService=new EditTransactionService();
				TransactionDto transDto=transService.getTransaction(id);
				if(transDto!=null){
					request.setAttribute("transactions",transDto);
					if(agent.equalsIgnoreCase("web")){
					RequestDispatcher rd=request.getRequestDispatcher("/pages/editTransaction.jsp");
					 rd.forward(request, response);	
					}
					else{
						RequestDispatcher rd=request.getRequestDispatcher("/mobile/editTransaction.jsp");
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
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try{
			String username=session.getAttribute("username").toString();
			
			String type=request.getParameter("type");
			int id=Integer.parseInt(request.getParameter("id"));
			double salesPrice=Double.valueOf(request.getParameter("salesPrice"));
			double commission=Double.valueOf(request.getParameter("commission"));
			
			TransactionDto transDto=new TransactionDto();
			transDto.setId(id);
			transDto.setUsername(username);
			transDto.setSalesPrice(salesPrice);
			transDto.setCommissionEarned(commission);
			transDto.setTrans_type(type);
			String dateString=request.getParameter("date");
			System.out.println("date  :"+dateString);
			Date date=new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH).parse(dateString);
			System.out.println(date);
			java.sql.Date sdate=new java.sql.Date(date.getTime());
			transDto.setDate(sdate);			
			Calendar cal=Calendar.getInstance();
			 int year=cal.get(Calendar.YEAR);
			 transDto.setYear(year);
			 
			 
			 System.out.println(transDto.getId());
			 System.out.println(transDto.getDate());
			 System.out.println(transDto.getSalesPrice());
			 System.out.println(transDto.getTrans_type());
			 System.out.println(transDto.getCommissionEarned());
			 System.out.println(transDto.getUsername());
			 System.out.println(transDto.getYear());
			
			EditTransactionService transService=new EditTransactionService();
			 String insert_result=transService.editTransaction(transDto);
			 if(!insert_result.equalsIgnoreCase("success")){
					response.setStatus(400);
			  }	 			
			
			
		}
		catch (NullPointerException e) {
			response.setStatus(400);
			response.sendRedirect("/agentplannertool/index.jsp");
			e.printStackTrace();
		}
		catch(SQLException e){
			response.setStatus(400);
			log.error(" Error in inserting Personal Expenses");
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			response.setStatus(401);
			log.error("Failed to insert IncomeGoal Details");
		}

		
		
	}

}
