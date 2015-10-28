package com.agentplannertool.frontend.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet{
	
	public void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
			execute(requset,response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		
		HttpSession session = request.getSession();
		session.invalidate();
				response.sendRedirect("./index.jsp");
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
				
}