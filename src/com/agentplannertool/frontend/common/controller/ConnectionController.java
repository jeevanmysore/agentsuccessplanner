package com.agentplannertool.frontend.common.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agentplannertool.backend.dbutil.DBUtil;

/**
 * Servlet implementation class ConnectionController
 */

public class ConnectionController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String driver=null;
	private String url=null;
	private String username=null;
	private String password=null;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context=getServletContext();
		driver=context.getInitParameter("driver");
		url=context.getInitParameter("url");
		username=context.getInitParameter("username");
		password=context.getInitParameter("password");		
		DBUtil.setDriver(driver);
		DBUtil.setUrl(url);
		DBUtil.setUsername(username);
		DBUtil.setPassword(password);
	}
	

}
