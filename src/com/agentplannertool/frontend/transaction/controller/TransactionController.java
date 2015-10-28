package com.agentplannertool.frontend.transaction.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.agentplannertool.frontend.transaction.service.TransactionService;
import com.agentplannertool.frontend.transaction.service.ViewTransactionService;


public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(TransactionController.class);
	private String agent;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		agent=session.getAttribute("userAgent").toString();
		try{
			String username=session.getAttribute("username").toString();
			ViewTransactionService transService=new ViewTransactionService();
			ArrayList<TransactionDto> list=transService.viewTransactions(username);
			Calendar cal=Calendar.getInstance();
			 int year=cal.get(Calendar.YEAR);
				TransactionService service=new TransactionService();
			 Double commissionperTrans=service.getCommissionPerTransFromDao(username, year);
			 request.setAttribute("commission", commissionperTrans);
			if(list!=null){
				request.setAttribute("transactions",list);
				if(agent.equalsIgnoreCase("web")){
					RequestDispatcher rd=request.getRequestDispatcher("/pages/transactions.jsp");
					 rd.forward(request, response);	
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("/mobile/transactions.jsp");
					 rd.forward(request, response);	
				}
				
			}
			else{
				if(agent.equalsIgnoreCase("web")){
					RequestDispatcher rd=request.getRequestDispatcher("/pages/transactions.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("/mobile/transactions.jsp");
					rd.forward(request, response);
				}
			}
			
		}	
		catch (NullPointerException e) {
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		catch(Exception e){
			log.error(e.toString());
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try{
			String username=session.getAttribute("username").toString();
			
			String type=request.getParameter("type");
			
			double salesPrice=Double.valueOf(request.getParameter("salesPrice"));
			double commission=Double.valueOf(request.getParameter("commission"));
			
			TransactionDto transDto=new TransactionDto();
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
			
			TransactionService transService=new TransactionService();
			 String insert_result=transService.saveTransaction(transDto);
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
