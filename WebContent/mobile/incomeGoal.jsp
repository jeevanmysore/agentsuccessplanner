<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="header.jsp" %>
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

<head>
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	 <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    	<script src="./pages/js/incomeGoal.js"></script>
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Income Goal</title>
</head>

<body onload="fillData();">
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>Set Income Goal</span>
    </div>
    <header></header>
    <form>
     <article id="main" class="view">
        <ul>
            <li><a href="#"><strong>Monthly Business Expenses</strong><span>$<input  type="text" name="businessExp" id="be" style="border: none;" readonly value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${incomeGoal.businessExpenses}" />' /></span></a></li>
            <li><a href="#"><strong>Monthly Personal Expenses</strong><span>$<input  type="text" name="personalExp" id="pe" style="border: none;" readonly value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${incomeGoal.personalExpenses}" />' /></span></a></li>            
          
            <li><a href="#"><strong>Monthly Discretionary  Income</strong><span>$<input  name="descretionaryIncome" id="di" type="text" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"    maxFractionDigits="2"  value="${incomeGoal.descretionaryIncome}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" tabindex="1"/></span></a></li>            
            <li><a href="#"><strong>Desired Savings</strong><span>$<input name="saving" id="saving" type="text" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"    maxFractionDigits="2"  value="${incomeGoal.savings}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" tabindex="2"/> </span></a></li>            
            <li><a href="#"><strong>Monthly Income Goal</strong><span>$<input id="income"  style="border: none;" readonly type="text" /> </span></a></li>
            <li><a href="#"><strong>Annual Income Goal</strong><span>$<input  id="annualIncomeGoal" style="border: none;" readonly type="text" /></span></a></li>            
        	<li><a href="#"><strong>Estimated Income Tax %</strong><span>%<input  id="incomeTax"    type="text" value="30"  onblur="callSum(this);" tabindex="3"/></span></a></li>
        	
        </ul>
        <div class="pros cal">
            <h3>Annual Income /desired<span>$<input  style="border: none;" readonly name="annualIncome" id="annualIncome"   value='<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"   value="${incomeGoal.annualIncomeGoal}" />' onfocus="findSum();"  type="text" /></span></h3>            
        </div>
        <input type="button" class="save" id="saveBtn" />
        <input type="button" class="saveand" id="continue"  />
        </form>
    </article>
    
    
        
     <%@include file="footer.jsp" %>
</body>
    