/*  
 *  ** $Header:  LoginController.java, M Jeevan Kumar, 25/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* LoginController.java
* USAGE
* Index page of the application
* 
* DESCRIPTION
* The Request for the application is received by this page and redirects to Mobile site or PC site based on User Agent
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 26-12-12
 * */

package com.agentplannertool.frontend.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.frontend.user.dto.UserDto;
import com.agentplannertool.frontend.user.service.LoginService;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static Logger log=Logger.getLogger(LoginController.class);
		
   
	private static final long serialVersionUID = 1L;
	private String agent;
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try
			{				
				String user=request.getParameter("username");
				String pwd=request.getParameter("password");
				
				LoginService loginService=new LoginService();
				
				UserDto userDto=loginService.validateUser(user, pwd);
				String loggedUser=userDto.getLastName();
				HttpSession session=request.getSession();
				agent=session.getAttribute("userAgent").toString();
				if(loggedUser!=null)				{
					
					session.setAttribute("user",loggedUser);  // users lastname
					session.setAttribute("username",user);	  // username of logged user	
					
					response.sendRedirect("./homeController");
					/*if(agent.equalsIgnoreCase("web")){
						response.sendRedirect("./pages/userHome.jsp");
					}
					else
					{
						response.sendRedirect("./mobile/userHome.jsp");
					}*/
				}
				else
				{
					request.setAttribute("regStatus","Invalid Username/ Password");
					if(agent.equalsIgnoreCase("web")){						
						RequestDispatcher dispatch = request.getRequestDispatcher("./home.jsp");
						dispatch.forward(request, response);
					}
					else{						
						RequestDispatcher dispatch = request.getRequestDispatcher("./mobileHome.jsp");
						dispatch.forward(request, response);
					}
				}
					
					
			}
			catch(Exception e){
				log.error(e.toString());
				if(agent.equalsIgnoreCase("web")){
					request.setAttribute("regStatus","Invalid Username/ Password");
					RequestDispatcher dispatch = request.getRequestDispatcher("./home.jsp");
					dispatch.forward(request, response);
				}
				else if(agent.equalsIgnoreCase("mobile")){
					request.setAttribute("regStatus","Invalid Username/ Password");
					RequestDispatcher dispatch = request.getRequestDispatcher("./mobileHome.jsp");
					dispatch.forward(request, response);
				}
			}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doGet(req, resp);
		resp.sendRedirect("./index.jsp");
	}
	
	
	
	
	
}
