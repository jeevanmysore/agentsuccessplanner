package com.agentplannertool.frontend.transaction.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.frontend.setup.controller.CommissionController;
import com.agentplannertool.frontend.transaction.dto.TransactionDto;
import com.agentplannertool.frontend.transaction.service.ViewTransactionService;


public class ViewTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(ViewTransactionController.class);
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			try{
				ViewTransactionService transService=new ViewTransactionService();
				ArrayList<TransactionDto> list=transService.viewTransactions(username);
				
				if(list!=null){
					request.setAttribute("transactions",list);
					RequestDispatcher rd=request.getRequestDispatcher("/pages/viewTransaction.jsp");
					 rd.forward(request, response);	
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
		
	}

}
