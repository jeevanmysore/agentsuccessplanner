<%@page import="com.agentplannertool.frontend.transaction.dto.TransactionDto"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>
     	<%
		HttpSession ses=request.getSession();
		String user=ses.getAttribute("user").toString();
		
		
		    TransactionDto transDto=(TransactionDto)request.getAttribute("transactions");
		   String date=formatDate(transDto.getDate());
			
	%>
	
	<%! 
public String formatDate(Date date)
{
	String format="MM/dd/yyyy";
	SimpleDateFormat sdf=new SimpleDateFormat(format);
	String dateString=sdf.format(date);
	return dateString;
}

%>
	
    
<!DOCTYPE html>
<html>
	<head>
		<title>Close Transaction</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/close_transaction.css">
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
		<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
		<script src="./pages/js/editTransaction.js"></script>		
		<style>
			.ui-datepicker-trigger{
				width:10%;
			}
		
		</style>
	</head> 
	
	
	
	
    <!-- Body-->
	<body onload="fillData();">
		<div class="header">
		 <!------- LOGO SUBTITLE --------------->
		 	<div class="logo_subtitle">
				<div class="logo">
					<div class="back_img">
						<a href="./homeController"><img src="pages/images/back_button.png" class="back"></img></a>
					</div>
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
					 Enter/Edit a transaction 
				</div>
				<div class="home_img">
					<a href="./homeController"> 
						<img src="pages/images/home_icon.png" class="home_img_detail"></img>
					</a>
				</div>
			</div>	
		<!------- CONTENT --------------->
			<form action="" method="" class="content">
				<div id="container_fix">
					<table>
						<tr> <input type="hidden" name="id1" id="id1" value="${transactions.id}" />
							<td>Enter Date</td>
							<td><input  id="datepicker" name="date" class="content_data1_input" value=<%= date %> type="text" /></td>
						</tr>
						<tr>
							<td>Transaction Type</td>
							<td>
								<%if(transDto.getTrans_type().equalsIgnoreCase("LISTING")){
								%>
								
								
								<select class="selection" name="type"  id="type" onchange="setType(this);" >
									<option value="LISTING">LISTING</option>
									<option value="BUY">BUY</option>								
								</select>	
								<%}
								else{						
								%>								
								<select class="selection" name="type"  id="type" onchange="setType(this);" >
									<option value="BUY">BUY</option>
									<option value="LISTING">LISTING</option>
																	
								</select>
								<%} %>
								
								
								
							</td>
						</tr>
						<tr>
							<td>Sales Price</td>
							<td>$ <input class="content_data1_input"  name="salesPrice" id="salesPrice" value='<fmt:formatNumber type="number" minFractionDigits="2"  maxFractionDigits="2" value="${transactions.salesPrice}" />'  type="text" required="required" onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" /></td>
						</tr>
						<tr>
							<td>Commission Earned</td>
							<td>$ <input class="content_data1_input" name="commission" id="commission" value='<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactions.commissionEarned}" />' type="text" required="required"  onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" /></td>
						</tr>
					</table>
					<div class="record4">
						<input type="button" class="record3" value="EDIT" id="recordBtn" ></input>
						<input type="button" class="record3" value="HOME" onclick="goHome();" ></input>
					</div>
				</div>
			</form>
			
		</div>
		</div>
	</body>
</html>