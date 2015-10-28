package com.agentplannertool.frontend.user.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.org.json.JSONObject;
import twitter4j.org.json.JSONTokener;



import com.agentplannertool.frontend.user.dto.UserDto;
import com.agentplannertool.frontend.user.service.LoginService;

/**
 * Servlet implementation class JLoginController
 */
public class JLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	
			System.out.println("Inside Controller");
		    InputStream stream=request.getInputStream();		
			StringBuffer buffer = new StringBuffer();
			byte[] b = new byte[4096];			
			for (int n; (n = stream.read(b)) != -1;) 
			{
				buffer.append(new String(b,0,n));
			}
			String s=buffer.toString();
			System.out.println("request: "+s);
			JSONTokener tokenizer=new JSONTokener(s);
			JSONObject json=new JSONObject(tokenizer);
					
		    
			String user=json.getString("username");
			String pwd=json.getString("password");
			System.out.println(user);
			LoginService loginService=new LoginService();
			
			
			UserDto userDto=loginService.validateUser(user, pwd);
			String loggedUser=userDto.getLastName();
			System.out.println(loggedUser);
			String data=null;
			if(loggedUser!=null)
			{
				 data="success";
			}
			else {
				 data="failure";
			}
			JSONObject jason =new JSONObject();
			jason.accumulate("STATUS", data);
			System.out.println(data);
			PrintWriter out = response.getWriter();
			out.println(jason.toString());
		
		}
		catch(Exception e){
			
		}
		
	}

}
