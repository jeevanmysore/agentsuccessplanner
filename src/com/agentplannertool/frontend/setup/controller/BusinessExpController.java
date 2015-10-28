package com.agentplannertool.frontend.setup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.agentplannertool.frontend.setup.dto.BusinessExpDto;

import com.agentplannertool.frontend.setup.service.BusinessExpService;


public class BusinessExpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(BusinessExpController.class);
	private String agent;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		agent=session.getAttribute("userAgent").toString();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			Calendar cal=Calendar.getInstance();
			 int year=cal.get(Calendar.YEAR);
			 try{
				BusinessExpService businessExpService=new BusinessExpService();
				 BusinessExpDto businessExpDto=businessExpService.viewBusinessExpenses(username, year);
				 if(businessExpDto!=null){					 
					 request.setAttribute("businessExpenses",businessExpDto);
					
					 if(agent.equalsIgnoreCase("web")){
						 RequestDispatcher rd=request.getRequestDispatcher("/pages/businessExpenses.jsp");
						 rd.forward(request, response);
					 }
					 else{
						 RequestDispatcher rd=request.getRequestDispatcher("/mobile/businessExpenses.jsp");
						 rd.forward(request, response);
					 }
				 }
			 }
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
			 catch(Exception e){
				 log.error(e.toString());
			 }
			 
		}
	}

	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		if(username.equals(null)){
			response.sendRedirect("/agentsuccessplanner/index.jsp");
		}
		else{
			try{
				double pay1=Double.valueOf(request.getParameter("pay1"));
				double pay2=Double.valueOf(request.getParameter("pay2"));
				double pay3=Double.valueOf(request.getParameter("pay3"));
				double pay4=Double.valueOf(request.getParameter("pay4"));
				double pay5=Double.valueOf(request.getParameter("pay5"));
				double pay6=Double.valueOf(request.getParameter("pay6"));
				double pay7=Double.valueOf(request.getParameter("pay7"));
				double pay8=Double.valueOf(request.getParameter("pay8"));
				double pay9=Double.valueOf(request.getParameter("pay9"));
				double pay10=Double.valueOf(request.getParameter("pay10"));
				double pay11=Double.valueOf(request.getParameter("pay11"));
				double pay12=Double.valueOf(request.getParameter("pay12"));
				double pay13=Double.valueOf(request.getParameter("pay13"));
				double pay14=Double.valueOf(request.getParameter("pay14"));
				double pay15=Double.valueOf(request.getParameter("pay15"));
				double pay16=Double.valueOf(request.getParameter("pay16"));
				double pay17=Double.valueOf(request.getParameter("pay17"));
				double pay18=Double.valueOf(request.getParameter("pay18"));
				double pay19=Double.valueOf(request.getParameter("pay19"));
				double pay20=Double.valueOf(request.getParameter("pay20"));
				double pay21=Double.valueOf(request.getParameter("pay21"));
				double pay22=Double.valueOf(request.getParameter("pay22"));
				double pay23=Double.valueOf(request.getParameter("pay23"));
				double pay24=Double.valueOf(request.getParameter("pay24"));
				double pay25=Double.valueOf(request.getParameter("pay25"));
				double pay26=Double.valueOf(request.getParameter("pay26"));
				double pay27=Double.valueOf(request.getParameter("pay27"));
				double pay28=Double.valueOf(request.getParameter("pay28"));
				double pay29=Double.valueOf(request.getParameter("pay29"));
				double pay30=Double.valueOf(request.getParameter("pay30"));
				double pay31=Double.valueOf(request.getParameter("pay31"));
				double pay32=Double.valueOf(request.getParameter("pay32"));
				double pay33=Double.valueOf(request.getParameter("pay33"));
				double pay34=Double.valueOf(request.getParameter("pay34"));
				double pay35=Double.valueOf(request.getParameter("pay35"));
				double pay36=Double.valueOf(request.getParameter("pay36"));
				double pay37=Double.valueOf(request.getParameter("pay37"));				
				
				
				double total=Double.valueOf(request.getParameter("total"));
				Calendar cal=Calendar.getInstance();
				 int year=cal.get(Calendar.YEAR);
				 
				BusinessExpDto businessExpDto=new BusinessExpDto();
				businessExpDto.setUsername(username);
				
				
				businessExpDto.setPay1(pay1);
				businessExpDto.setPay2(pay2);
				businessExpDto.setPay3(pay3);
				businessExpDto.setPay4(pay4);
				businessExpDto.setPay5(pay5);
				businessExpDto.setPay6(pay6);
				businessExpDto.setPay7(pay7);
				businessExpDto.setPay8(pay8);
				businessExpDto.setPay9(pay9);
				businessExpDto.setPay10(pay10);
				businessExpDto.setPay11(pay11);
				businessExpDto.setPay12(pay12);
				businessExpDto.setPay13(pay13);
				businessExpDto.setPay14(pay14);
				businessExpDto.setPay15(pay15);
				businessExpDto.setPay16(pay16);
				businessExpDto.setPay17(pay17);
				businessExpDto.setPay18(pay18);
				businessExpDto.setPay19(pay19);
				businessExpDto.setPay20(pay20);
				businessExpDto.setPay21(pay21);
				businessExpDto.setPay22(pay22);
				businessExpDto.setPay23(pay23);
				businessExpDto.setPay24(pay24);
				businessExpDto.setPay25(pay25);
				businessExpDto.setPay26(pay26);
				businessExpDto.setPay27(pay27);
				businessExpDto.setPay28(pay28);
				businessExpDto.setPay29(pay29);
				businessExpDto.setPay30(pay30);
				businessExpDto.setPay31(pay31);
				businessExpDto.setPay32(pay32);
				businessExpDto.setPay33(pay33);
				businessExpDto.setPay34(pay34);
				businessExpDto.setPay35(pay35);
				businessExpDto.setPay36(pay36);
				businessExpDto.setPay37(pay37);
						
								
				businessExpDto.setTotal(total);
				businessExpDto.setYear(year);
				
				BusinessExpService businessExpService=new BusinessExpService();
				String insert_result=businessExpService.editBusinessExpenses(businessExpDto);
				
				if(!insert_result.equalsIgnoreCase("success")){
					response.setStatus(400);
				}
			}
			catch(SQLException e){
				response.setStatus(400);
				log.error("Record Already exists, Error in inserting Personal Expenses");
				e.printStackTrace();
			}
			 catch(NullPointerException e){
				 log.error("Authentication failed");
				 response.sendRedirect("/agentsuccessplanner/index.jsp");
			 }
			catch(Exception e){
				e.printStackTrace();
				response.setStatus(401);
				log.error("Failed to insert BusinessExp Details");
			}
		}
	}

}
