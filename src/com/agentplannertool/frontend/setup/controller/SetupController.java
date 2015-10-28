/*  
 *  ** $Header:  SetupController.java, M Jeevan Kumar, 25/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* SetupController.java
* USAGE
* Index page of the application
* 
* DESCRIPTION
* The Request for the application is received by this page and redirects to Mobile site or PC site based on User Agent
* NOTES
* CHANGES (most recent first)
* M JEEVAN KUMAR, 26-12-12
 * */

package com.agentplannertool.frontend.setup.controller;

import java.io.IOException;
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

public class SetupController extends HttpServlet {
	private static Logger log=Logger.getLogger(SetupController.class);
		
   
	private static final long serialVersionUID = 1L;
	private String agent;

	 public SetupController() {
			super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {			
			HttpSession session=request.getSession();
			agent=session.getAttribute("userAgent").toString();
			try{
				String username=session.getAttribute("username").toString();
				if(username.equals(null)){
					response.sendRedirect("/agentsuccessplanner/index.jsp");
				}
				else{
					if(agent.equalsIgnoreCase("web")){
						response.sendRedirect("./pages/setupHome.jsp");
					}
					else{
						response.sendRedirect("./mobile/setupHome.jsp");
					}
				}
			}
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
	}
		 
	
	
	
}
