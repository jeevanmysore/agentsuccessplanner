<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <fmt:setLocale value="en_US"/>
 
<!DOCTYPE html>
<html>
	<head>
		<title>Yearly Goals</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/page_common.css">
				
		<%
			
			HttpSession ses=request.getSession();
			String user=ses.getAttribute("user").toString();
			Calendar cal = Calendar.getInstance();
			
			int max_days = cal.getMaximum(Calendar.DAY_OF_YEAR);
			int today = cal.get(Calendar.DAY_OF_YEAR);
			int days_left = max_days - today;
			
			
			Date date;  
		    String result;  
		    SimpleDateFormat formatter;  
		    formatter = new SimpleDateFormat("MM/dd/yy");  
		    date = new Date();  
		    result = formatter.format(date);
		
		%>
    </head>
    <!-- Body-->
	<body>
		<div class="header">
		 <!------- LOGO SUBTITLE --------------->
		 	<div class="logo_subtitle">
				<div class="back_img">
					<a href="./homeController"><img src="pages/images/back_button.png" class="back"></img></a>
				</div>
				<div class="logo">
					<img src="pages/images/logo.png" class="logo_img" ></img>
				</div>
				<div class="subtitle">
					<img src="pages/images/sub_heading.png" class="logo_subtitle_img" ></img>		
				</div>
			</div>
			<!------- LOGO SUBTITLE1 --------------->
			<div class="logo_subtitle1">
			    <!---- view  ---->
				<div class="view" >
					View This Year's Goals
				</div>
				<div class="home_img">
					<a href="./homeController"> 
						<img src="pages/images/home_icon.png" class="home_img_detail"></img>
					</a>
				</div>
			</div>		
		</div>
		<!------- CONTENT --------------->
		<div class="content">
		
			<div class="content_data">Income Goals of 2013
			</div>
			<div class="content_data1">$ <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${yearGoals.incomeGoal}" />
			</div>
		
			<div class="content_data">#Transactions Needed / 2013
			</div>
			<div class="content_data1"><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.transactionsNeeded}" />
			</div>
			
			<div class="content_data">Transactions Closed
			</div>
			<div class="content_data1"><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.transactionsClosed}" />
			</div>
			
			<div class="content_data">Commission Earned (YTD)
			</div>
			<div class="content_data1">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${yearGoals.commissionEarned}" />
			</div>
			<div class="content_data">Transactions Needed(Rest of the year)
			</div>
			<div class="content_data1"><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.yearlyTransaction}" />
			</div>
			<div class="content_data">Prospects Needed(Rest of the year)
			</div>
			<div class="content_data1"><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.annualProspectsRemained}" />
			</div>
			<!----- DESIGN----->
			<div class="design">
				<img src="pages/images/footer_design.png" class="design_img"></img>
			</div>
			
			<div class="lower">Have you prospected today ?
			</div>
		</div>	
		
		<!-- Footer-->
			<div class="footer">
			<!-- Footer upper -->
				<div class="footer_upper">
					<div class="footer_upper_left" >
						<img src="pages/images/date_icon.png"class="imgf" ><div class="textf">Today's Date</div> </img>
					</div>
					<div class="footer_upper_right" >
						<div class="date">
						<%= result %>
						</div>
					</div>
					
				</div>
				<div>
				<hr>
				</div>
				<!-- Footer Lower-->
				<div class="footer_lower">
					<div class="footer_lower_left" >
						<img src="pages/images/day_icon.png"class="imgf2" ><div class="textf2">Days Left in Year </div> </img>
					</div>
					<div class="footer_lower_right" >
						<div class="day">
						<%= days_left %>
						</div>
					</div>
				
				</div>
				
			</div>
	</body>
</html>
