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
		<title>Business Expenses</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<link rel="stylesheet" type="text/css" href="pages/css/personal_expenses.css">
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    	<script src="./pages/js/businessExpense.js"></script>
	
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
					Enter your Monthly Business Expenses
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
		
			<div class="content_data">Desk Fee
			</div>
			<div class="content_data1" >
			
				<div class="content_data1_2" >$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay1" id="pay1" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay1}" />' onblur="callSum(this);"  type="text"></input></div>
			</div>
		<div style="clear:both"></div>
			<div class="content_data">MLS DUES
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input"  onkeypress="return isNumberKey(event);" name="pay2" id="pay2" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay2}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">MLS Lockbox
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay3" id="pay3" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay3}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Telephone
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay4" id="pay4" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay4}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">CellPhone
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay5" id="pay5" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay5}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Internet
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay6" id="pay6" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay6}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Computer Software
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay7" id="pay7" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay7}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Supplies
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay8" id="pay8" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay8}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Maintenance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay9" id="pay9" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay9}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Car Payment
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay10" id="pay10" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay10}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Gas and Oil
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay11" id="pay11" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay11}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Car Maintenance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay12" id="pay12" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay12}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Car Insurance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay13" id="pay13" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay13}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Business Meals
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay14" id="pay14" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay14}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Business Entertainment
			</div>
			<div class="content_data1">
			
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay15" id="pay15" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay15}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Seminars and Conventions
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay16" id="pay16" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay16}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Lead Generation Subscriptions
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay17" id="pay17" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay17}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Postcards
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay18" id="pay18" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay18}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Postage
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay19" id="pay19" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay19}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Flyers and Brochures
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay20" id="pay20" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay20}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Signs
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay21" id="pay21" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay21}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Website
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay22" id="pay22" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay22}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Internet Marketing
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay23" id="pay23" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay23}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Print Ads
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay24" id="pay24" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay24}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			<div class="content_data">Legal Services
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay25" id="pay25" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay25}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			<div class="content_data">Accounting Services
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);"  name="pay26" id="pay26" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay26}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			<div class="content_data">Assistants Salary/Bonus	
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay27" id="pay27" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay27}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			<div class="content_data">Payroll Taxes	
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input"  onkeypress="return isNumberKey(event);" name="pay28" id="pay28" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay28}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			<div class="content_data">Transaction Coordinator
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay29" id="pay29" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay29}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Listing Coordinator
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input"  onkeypress="return isNumberKey(event);" name="pay30" id="pay30" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay30}" />' onblur="callSum(this);"  type="text"></input>
				</div>
			</div>
			
			<div class="content_data">Dues and Subscriptions
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay31" id="pay31" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay31}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			
			<div class="content_data">License	
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay32" id="pay32" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay32}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			<div class="content_data">E and O Insurance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay33" id="pay33" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay33}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			<div class="content_data">Industrial Insurance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay34" id="pay34" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay34}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			<div class="content_data">Medical Insurance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay35" id="pay35" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay35}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>
			<div class="content_data">Disability Insurance
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay36" id="pay36" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay36}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>	
			
			<div class="content_data">Charity
			</div>
			<div class="content_data1">
				
				<div class="content_data1_2">$<input class="content_data1_input" onkeypress="return isNumberKey(event);" name="pay37" id="pay37" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay37}" />' onblur="callSum(this);" type="text"></input>
				</div>
			</div>	
			
			<div class="content_data2">TOTAL
			</div>
			<div class="content_data3">$<input class="content_data1_input1" name="total" id="total" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.total}" />'  type="text" readonly ></input>
			</div>
			
			<div class="save1">
				<input type="button" class="save" value="SAVE" id="saveBtn"></input>
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
