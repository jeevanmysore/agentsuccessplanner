/*  
 *  ** $Header:  ForgetController.java, Nnupur Krishnaa, 04/01/13
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* ForgetController.java
* USAGE
*to get the page to set new password and save in database
* to send mail of confirmation
* DESCRIPTION
* New user get the link int the email to click and reset their password
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
 * Servlet implementation class ForgetController
 */

public class ForgetController extends HttpServlet {
	private static Logger log=Logger.getLogger(LoginController.class);
		
   
	private static final long serialVersionUID = 1L;

	public ForgetController() {
        super();        
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try{	
			
			String[] ukey1=req.getQueryString().split("=");
			//System.out.println(ukey1[1]);
			String ukey=ukey1[1];
			HttpSession session=req.getSession();
			session.setAttribute("ukey", ukey);
			RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher(
						"/pages/newPassword.jsp");
			dispatch.forward(req, res);
					
	} catch (Exception ex) {
		ex.printStackTrace();
	}
		//doPost(req,res);
			
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	
			HttpSession session=request.getSession();
			String ukey=(String) session.getAttribute("ukey");
			
			//System.out.println(ukey);
			String newpassword=request.getParameter("newpassword");
			String confirmpassword=request.getParameter("confirmpassword");
			
			
			//System.out.println(newpassword);
			//System.out.println(confirmpassword);
			
			if((newpassword).equals(confirmpassword)){
				
				boolean flag=LoginService.updateUserPassword(ukey,newpassword);
				if (flag) {	
					request.setAttribute("password","Password Reset Successful, Please Login to Continue");
					RequestDispatcher dispatch = request.getRequestDispatcher("/home.jsp");
					dispatch.forward(request, response);
			} 
				}	else {
				response.sendRedirect("./pages/register.jsp");
			}	
			session.invalidate();
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
}
}
