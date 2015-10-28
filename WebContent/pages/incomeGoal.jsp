<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>
	<%
		HttpSession ses=request.getSession();
		String user=ses.getAttribute("user").toString();

	%>
<!DOCTYPE html >
<html>
	<head>
		<title>Income Goals</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/personal_expenses.css">
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    		<script src="./pages/js/incomeGoal.js"></script>	
    </head>
    <!-- Body-->
	<body onload="fillData();">
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
					Set Income Goal
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
		
			<div class="content_data">Monthly Business Expenses
			</div>
			<div class="content_data1">
			
				<div class="content_data1_2">$<input class="content_data1_input" type="text" name="businessExp" id="be" style="border: none;" readonly value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${incomeGoal.businessExpenses}" />' />
				</div>
			</div>
		
			<div class="content_data">Monthly Personal Expenses
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" name="personalExp" id="pe" type="text" style="border: none;" readonly value='<fmt:formatNumber type="number" minFractionDigits="2"    value="${incomeGoal.personalExpenses}" />' />
				</div>
			</div>
			
			
			
			<div class="content_data">Monthly Discretionary  Income
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input2"  name="descretionaryIncome" id="di" type="text" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"    maxFractionDigits="2"  value="${incomeGoal.descretionaryIncome}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" />
				</div>
			</div>
			
			<div class="content_data">Monthly Desired savings
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input2" name="saving" id="saving"  type="text" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"   maxFractionDigits="2"  value="${incomeGoal.savings}" />' onfocus="clearText(this);" onclick="clearText(this);" onblur="callSum(this);" />
				</div>
			</div>
			
			<div class="content_data">Monthly Income Goal
			</div>
			<div class="content_data1">

				<div class="content_data1_2">$<input class="content_data1_input" id="income"  style="border: none;" readonly type="text" /> 
				</div>
			</div>
			
			<div class="content_data">Annual Income Goal
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" id="annualIncomeGoal" style="border: none;" readonly type="text" />
				</div>
			</div>			
			<div class="content_data">Estimated Income Tax %
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">%<input class="content_data1_input2" id="incomeTax"    type="text" value="30"  onblur="callSum(this);" />
				</div>
			</div>
			
			<div class="content_data2"> Annual Income Desired
			</div>
			<div class="content_data3">$<input class="content_data1_input1" style="border: none;" readonly name="annualIncome" id="annualIncome"   value='<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"   value="${incomeGoal.annualIncomeGoal}" />' onfocus="findSum();"  type="text" />
			</div>
			<div class="save1">
					<input type="button" class="save" value="SAVE" id="saveBtn">			</input>
					<input type="button" class="save" value="SAVE and CONTINUE"    id="continue" />
					<input type="button" class="save" value="Home"    id="HOME" onclick="goHome();"/>
			</div>
			<!----- DESIGN----->
			<div class="design">
				<img src="pages/images/footer_design.png" class="design_img"></img>
			</div>
		</div>	
		
		</form>
	</body>
</html>
