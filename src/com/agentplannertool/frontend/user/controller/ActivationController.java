/*  
 *  ** $Header:  ActivateController.java, Nnupur Krishnaa, 04/01/13
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* ActivateController.java
* USAGE
*to activate user account by clicking on the link provided in their email
* to send mail of confirmation
* DESCRIPTION
* New user get the link in the email to click and activate their account
* NOTES
* CHANGES (most recent first)
* Nnupur Krishnaa, 04-01-13
 * */
package com.agentplannertool.frontend.user.controller;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class ActivateController
 */

public class ActivationController extends HttpServlet {
	private static Logger log=Logger.getLogger(ActivationController.class);
		
   
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{						
			String ukey=request.getParameter("ukey");
			//System.out.println(ukey);
			boolean flag=LoginService.updateUserAccount(ukey);
			
			if (flag) {
				request.setAttribute("activation","Your Account is Activated, Please Login to Continue");
				RequestDispatcher dispatch = request.getRequestDispatcher("./home.jsp");
				dispatch.forward(request, response);
		} else {
			request.setAttribute("activation","Problem while Activating your Account, Please Try Again");
			RequestDispatcher dispatch = request.getRequestDispatcher("/pages/register.jsp");
			dispatch.forward(request, response);;
		}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
}
}
