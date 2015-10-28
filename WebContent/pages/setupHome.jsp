<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Setup Goals</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="css/common.css">
		
<%

	HttpSession ses=request.getSession();
	
	try{
		String user=ses.getAttribute("user").toString();
	}
	catch(Exception e){
		response.sendRedirect("/agentsuccessplanner/index.jsp");
	}	
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
		 <!-- For LOGO-->
			<div class="logo">
				<img src="images/logo.png" class="logo_img" ></img>			
			</div>
			<div class="logo_subtitle">
				<img src="images/home_title.png" class="logo_subtitle_img" ></img>		
			</div>	
		<!-- For Content-->
			<div class="user_content">
			<!-- For Button1-->
				<div class="button">
					<a href="/agentsuccessplanner/personalExpController">
						<span class="content_button1">
							<div class="button_text">Enter your Monthly Personal Expenses</div>
						</span>
					</a>
				</div>
				<!-- For Button2-->
				<div class="button">
					<a href="/agentsuccessplanner/businessExpController">
						<span class="content_button1">
							<div class="button2_text">Enter your Monthly Business Expenses</div>
						</span>
					</a>
				</div>
				<!-- For Button3-->
				<div class="button">
					<a href="/agentsuccessplanner/incomeGoalController">
						<span class="content_button1">
							<div class="button2_text">Set Income Goal </div>
						</span>
					</a>
				</div>
				<!-- For Button4-->
				<div class="button">
					<a href="/agentsuccessplanner/commissionController">
						<span class="content_button1">
							<div class="button2_text">Calculate Commission/Transaction </div>
						</span>
					</a>
				</div>
				
				<div class="button">
					<a href="/agentsuccessplanner/homeController">
						<span class="content_button1">
							<div class="button2_text">Home</div>
						</span>
					</a>
				</div>
			</div>
		</div>
		<!-- Footer-->
			<div class="footer">
			<!-- Footer upper -->
				<div class="footer_upper">
					<div class="footer_upper_left" >
						<img src="images/date_icon.png"class="imgf" ><div class="textf">Today's Date</div> </img>
					</div>
					<div class="footer_upper_right" >
						<div class="date">
						<%=   result %>
						</div>
					</div>					
				</div>
				<div>
				<hr>
				</div>
				<!-- Footer Lower-->
				<div class="footer_lower">
					<div class="footer_lower_left" >
						<img src="images/day_icon.png"class="imgf2" ><div class="textf2">Days Left in Year </div> </img>
					</div>
					<div class="footer_lower_right" >
						<div class="day">
						<%=days_left %>
						</div>
					</div>
				
				</div>
				
			</div>
	
	
	
	</body>


</html>
