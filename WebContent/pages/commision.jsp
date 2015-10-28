<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>  
  	<%
		HttpSession ses=request.getSession();
		String user=ses.getAttribute("user").toString();

	%>
<!DOCTYPE html>
<html>
	<head>
		<title>Commision</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/personal_expenses.css">
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    	<script src="./pages/js/commission.js"></script>
  
		
   </head>
    <!-- Body-->
	<body onload="fillData();" >
		<div class="header">
		 <!------- LOGO SUBTITLE --------------->
		 	<div class="logo_subtitle">
				<div class="back_img">
					<a href="./setupController"><img src="pages/images/back_button.png" class="back"></img></a>
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
					Calculate Commission/Transaction
				</div>
				<div class="home_img">
					<a href="./homeController"> 
						<img src="pages/images/home_icon.png" class="home_img_detail"></img>
					</a>
				</div>
			</div>		
		</div>
		<!------- CONTENT --------------->
		<form action="" method="" class="content">
		
			<div class="content_data">Average House Price
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="housePrice" id="hp"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${commission.housePrice}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text"></input>
				</div>
			</div>
		
			<div class="content_data">Average commission (%)
			</div>
			<div class="content_data1">
			
				<div class="content_data1_2">%<input class="content_data1_input" name="commissionRate" id="cr" style="margin-left: 0px;"  onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2" value="${commission.commisionRate}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text"></input>
				</div>
				
			</div>
			
			<div class="content_data">Average Transaction Side Commission
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" readonly="readonly" onkeypress="return isNumberKey(event);" id="gc" type="text"></input>
				</div>
			</div>
			
		<!-- 	<div class="content_data">Average commission per side
			</div>
			 <div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" readonly="readonly" onkeypress="return isNumberKey(event);" id="cps" type="text"></input>
				</div>
			</div> -->
			<input class="content_data1_input" readonly="readonly" onkeypress="return isNumberKey(event);" id="cps" type="hidden" />
			<div class="content_data">Your commission split(%)
			</div>
			<div class="content_data1">
			    
				<div class="content_data1_2">%<input class="content_data1_input"  id="cs" style="margin-left: 0px;" onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2" groupingUsed="false" value="${commission.commisionSplit}" />'  onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Enter your Prospect to Sales Ratio 
			</div>
			<div class="content_data1">
			     
				<div class="content_data1_2">%<input class="content_data1_input" style="margin-left: 0px;" onkeypress="return isNumberKey(event);" name="prospectRatio" id="pr"   value='<fmt:formatNumber type="number" minFractionDigits="2" groupingUsed="false" value="${commission.prospectusRatio}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text"></input>
				</div>
			</div>
						
			<div class="content_data2">Commission/Transaction
			</div>
			<div class="content_data3">
				$<input class="content_data1_input1" id="cpt" name="cpt" readonly="readonly" value= '<fmt:formatNumber type="number" minFractionDigits="2"  value="${commission.commissionPerTransaction}" />'  type="text"></input>
			</div>
						
			<div class="save1">
					<input type="button" class="save" value="SAVE" id="saveBtn" >			</input>
					<input type="button" class="save" value="SAVE and CONTINUE"    id="continue" />
					<input type="button" class="save" value="HOME"    id="home" onclick="goHome();"/>
			 </div>
		
			<!----- DESIGN----->
			<div class="design">
				<img src="pages/images/footer_design.png" class="design_img"></img>
			</div>
		</div>	
		
		</form>
	</body>
</html>
