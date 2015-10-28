<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>
 	<%
		 	HttpSession ses=request.getSession();
			try{
				String user=ses.getAttribute("user").toString();
			}
			catch(Exception e){
				response.sendRedirect("/agentsuccessplanner/index.jsp");
			}

	%>
<!DOCTYPE html >
<html>
	<head>
			<title>Personal Expenses</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/personal_expenses.css">
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	 <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    	<script src="./pages/js/personalExpense.js"></script>
    	

    	    	 
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
					Enter your Monthly Personal Expenses
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
		
			<div class="content_data">Mortgage Payment
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" id="pay1" name="pay1" onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay1}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
		
			<div class="content_data">Household Heat
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay2" name="pay2" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay2}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Household Water
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay3" name="pay3"  onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay3}" />' type="text" onblur="callSum(this);"  ></input>
				</div>
			</div>
			
			<div class="content_data">Household Electricity
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input"  id="pay4" name="pay4" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay4}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Groceries
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay5" name="pay5" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay5}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Dining
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay6" name="pay6" onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay6}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Car Expenses
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay7" name="pay7" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay7}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Entertainment 
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay8" name="pay8"  onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay8}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Child Care
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay9" name="pay9" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay9}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Education
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay10" name="pay10" onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay10}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Other Living Expenses
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay11" name="pay11" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay11}" />' type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
			<div class="content_data">Other Living Expenses
			</div>
			<div class="content_data1">
				<div class="content_data1_2">$<input class="content_data1_input" id="pay12" name="pay12" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay12}" />'type="text" onblur="callSum(this);" ></input>
				</div>
			</div>
			
				<div class="content_data2">SUB TOTAL
				</div>
				<div class="content_data3">$<input class="content_data1_input1" id="total" name="total" readonly="readonly" value= '<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.total}" />'  type="text"></input>
				</div>
			<div class="save1">
					<input type="button" class="save" value="SAVE"  id="saveBtn" />
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
