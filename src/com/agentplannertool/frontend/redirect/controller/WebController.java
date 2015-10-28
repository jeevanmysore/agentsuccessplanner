package com.agentplannertool.frontend.redirect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class WebController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(WebController.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("inside doGet()");
		HttpSession session=req.getSession();
		try{
			
			String agent=session.getAttribute("userAgent").toString();
			 if(agent.equalsIgnoreCase("web")){
					
				 RequestDispatcher rd=req.getRequestDispatcher("/pages/home.jsp");
				 rd.forward(req, resp);
			 }
			 else{
				 RequestDispatcher rd=req.getRequestDispatcher("/mobile/mobileHome.jsp");
				 rd.forward(req, resp);
			 }
		}
		 catch(NullPointerException e){
			 log.error("Authentication failed");
			 resp.sendRedirect("/agentsuccessplanner/index.jsp");
		 }
		catch(Exception e){
			log.error("Error while showing home page");
		}
		
		
	}
}
