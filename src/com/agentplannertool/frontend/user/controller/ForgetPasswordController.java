/*  
 *  ** $Header:  ForgetPasswordController.java, Nnupur Krishnaa, 27/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* ForgetPasswordController.java
* USAGE
*
* to send password to user through his mail
* DESCRIPTION
* User call this to retrieve their password
* NOTES
* CHANGES (most recent first)
* Nnupur Krishnaa, 27-12-12
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


import com.agentplannertool.backend.emailutil.EmailUtil;
import com.agentplannertool.frontend.user.dto.UserDto;
import com.agentplannertool.frontend.user.service.LoginService;

/**
 * Servlet implementation class LoginController
 */

public class ForgetPasswordController extends HttpServlet {
	private static Logger log=Logger.getLogger(LoginController.class);
		
   
	private static final long serialVersionUID = 1L;

	public ForgetPasswordController() {
        super();        
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {

			RequestDispatcher dispatch = this.getServletContext()
					.getRequestDispatcher(
							"/pages/forgetPassword.jsp");
			dispatch.forward(req, res);
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try
			{						
				
				String email=request.getParameter("email");
				Random randomGenerator = new Random();
				String constant="234678588"; 
				String ukey=(randomGenerator.nextInt(100))+constant;
				System.out.println(ukey);
				
				
				LoginService loginService=new LoginService();
				
				
				String to= request.getParameter("email");
				loginService.insertUkeyforPassword(ukey,email);
				System.out.println(to);
				
				
				//String pass =loginService.getPassword(email);
				//System.out.println(pass);
				String from="knstech01@gmail.com";
				String subject="Password Recovery";
				
				String Body="Click on the link to reset your password"+"\n"+
						"http://ec2-54-224-168-232.compute-1.amazonaws.com:7090/agentsuccessplanner/forget?ukey="+ukey;
				
				EmailUtil eutil=new EmailUtil();
				eutil.sendMail(from, to, subject, Body);
				/*loginService.sendMail( from, to,
						subject, Body);*/
						
					RequestDispatcher dispatch = request.getRequestDispatcher("./index.jsp");
					dispatch.forward(request, response);
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
}
