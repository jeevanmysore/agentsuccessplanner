/*  
 *  ** $Header:  RegistrationController.java, Nnupur Krishnaa, 27/12/12
* Copyright (c) KNS Technologies Pvt. Ltd. 2012 All Rights Reserved
*
* NAME
* RegistrationController.java
* USAGE
*to register user
* to send mail of confirmation
* DESCRIPTION
* New user get themselves registered and a confirmation mail is sent to their specified email address
* NOTES
* CHANGES (most recent first)
* Nnupur Krishnaa, 27-12-12
 * */

/*
 *  Edited by Jeevan on 10-01-13
 *  
 *   Deactivated Mail functionality after Registration and  Randon key Generation
 *  
 *  */

package com.agentplannertool.frontend.user.controller;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;
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

public class RegistrationController extends HttpServlet {
	private static Logger log=Logger.getLogger(LoginController.class);
		
   
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
        super();        
    }

	private static String agent;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
				HttpSession session=req.getSession();				
				agent=session.getAttribute("userAgent").toString();
				if(agent.equalsIgnoreCase("web")){

					RequestDispatcher dispatch = this.getServletContext()
							.getRequestDispatcher(
									"/pages/register.jsp");
					dispatch.forward(req, res);
				}
				else
				{
					RequestDispatcher dispatch = this.getServletContext()
							.getRequestDispatcher(
									"/mobile/register.jsp");
					dispatch.forward(req, res);
				
			}
						
		} 
		catch (Exception ex) {
			
			if(agent.equalsIgnoreCase("web")){
				req.setAttribute("regStatus","Invalid Username/ Password");
				RequestDispatcher dispatch = req.getRequestDispatcher("./home.jsp");
				dispatch.forward(req, res);
			}
			else{
				req.setAttribute("regStatus","Invalid Username/ Password");
				RequestDispatcher dispatch = req.getRequestDispatcher("./mobile/mobileHome.jsp");
				dispatch.forward(req, res);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{						
			String user=request.getParameter("username");
			String pwd=request.getParameter("password");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email=request.getParameter("email");
			String hobby=request.getParameter("hobby");
			int activated=0;
			
			LoginService loginService=new LoginService();
			
			Boolean flag =loginService.registerUser(user,pwd,firstName,lastName,email,activated,hobby);
			
			Random randomGenerator = new Random();
			String constant="234678588";
			String ukey=(randomGenerator.nextInt(100))+constant;
			//System.out.println(ukey);
		//	loginService.insertUkey(ukey,user);         diadling key generation
			String from="knstech01@gmail.com";
			String to= request.getParameter("email");
			//System.out.println(to);
			String subject="Account Confirmation";
			
			String Body="Congratulations User!!You are successfully registered.please click on the link to activate your account"+"\n"+
					"http://www.knsclients.com:8080/agentsuccessplanner/activate?ukey="+ukey;
			EmailUtil eutil=new EmailUtil();
		//	eutil.sendMail(from, to, subject, Body);    deactivating mail sending functionality
			
			if (flag) {
				request.setAttribute("regStatus","Registration Successful");
				if(agent.equalsIgnoreCase("web")){					
					RequestDispatcher dispatch = request.getRequestDispatcher("./home.jsp");
					dispatch.forward(request, response);
				}
				else{
					RequestDispatcher dispatch = request.getRequestDispatcher("./mobile/mobileHome.jsp");
					dispatch.forward(request, response);
				}
			} else {
			
				request.setAttribute("regStatus","Username/Email Already Registered");
				if(agent.equalsIgnoreCase("web")){	
					RequestDispatcher dispatch = request.getRequestDispatcher("pages/register.jsp");
					dispatch.forward(request, response);
				}
				else{
					RequestDispatcher dispatch = request.getRequestDispatcher("mobile/register.jsp");
					dispatch.forward(request, response);
				}
			}	
		}
		catch(SQLException e){
			log.error("Fail to Register user");
			request.setAttribute("regStatus","Username/Email Already Registered");
			if(agent.equalsIgnoreCase("web")){	
				RequestDispatcher dispatch = request.getRequestDispatcher("pages/register.jsp");
				dispatch.forward(request, response);
			}
			else{
				RequestDispatcher dispatch = request.getRequestDispatcher("mobile/register.jsp");
				dispatch.forward(request, response);
			}
		}
		catch(ConnectException e){
			log.error(e.toString());
			if(agent.equalsIgnoreCase("web")){	
				response.sendRedirect("./pages/register.jsp");
			}
			else{
				response.sendRedirect("./mobile/register.jsp");
			}
		}
		catch(Exception e){
			log.error("Fail to Register user");
			request.setAttribute("regStatus","Username/Email Already Registered");
			if(agent.equalsIgnoreCase("web")){	
				RequestDispatcher dispatch = request.getRequestDispatcher("pages/register.jsp");
				dispatch.forward(request, response);
			}
			else{
				RequestDispatcher dispatch = request.getRequestDispatcher("mobile/register.jsp");
				dispatch.forward(request, response);
			}
		}
	}

	
	
}
