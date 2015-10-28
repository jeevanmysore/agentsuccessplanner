package com.agentplannertool.frontend.common.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import com.agentplannertool.backend.emailutil.EmailUtil;





public class EmailController extends HttpServlet {
	private static String host;
	private static String protocol;
	private static String port;
	private static String auth;
	private static String starttls;
	private static String socketFactoryPort;
	private static String socketFactoryClass;
	private static String socketFactoryFallback;
	private static String usrname;
	private static String pasword;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context=getServletContext();
		host=context.getInitParameter("host");
		protocol=context.getInitParameter("protocol");
		port=context.getInitParameter("port");
		auth=context.getInitParameter("auth");
		starttls=context.getInitParameter("starttls");
		socketFactoryPort=context.getInitParameter("socketFactoryPort");
		socketFactoryClass=context.getInitParameter("socketFactoryClass");
		socketFactoryFallback=context.getInitParameter("socketFactoryFallback");
		usrname=context.getInitParameter("usrname");
		pasword=context.getInitParameter("pasword");	
		EmailUtil.setHost(host);
		EmailUtil.setProtocol(protocol);
		EmailUtil.setPort(port);
		EmailUtil.setAuth(auth);
		EmailUtil.setStarttls(starttls);
		EmailUtil.setSocketFactoryPort(socketFactoryPort);
		EmailUtil.setSocketFactoryClass(socketFactoryClass);
		EmailUtil.setSocketFactoryFallback(socketFactoryFallback);
		EmailUtil.setUsername(usrname);
		EmailUtil.setPassword(pasword);
		
	}
}