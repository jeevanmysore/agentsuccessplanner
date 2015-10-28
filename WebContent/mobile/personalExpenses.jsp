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
    	<script src="./pages/js/personalExpense.js"></script>
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Personal Expenses</title>
</head>

<body onload="fillData();">
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>Enter Your Monthly Personal Expenses</span>
    </div>
    <header></header>
    
    
    <article id="main" class="view">
      <form>
        <ul>
            <li><a href="#"><strong>Mortgage Payment</strong><span>$ <input  id="pay1" name="pay1" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay1}" />' type="text" onblur="callSum(this);"  tabindex="1"  /></span></a></li>
            <li><a href="#"><strong>Household Heat</strong><span>$<input  id="pay2" name="pay2" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay2}" />' type="text" onblur="callSum(this);"  tabindex="2"  /></span></a></li>            
            <li><a href="#"><strong>Household Water</strong><span>$<input  id="pay3" name="pay3" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay3}" />' type="text" onblur="callSum(this);"   tabindex="3" /></span></a></li>            
            <li><a href="#"><strong>Household Electricity</strong><span>$<input  id="pay4" name="pay4" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay4}" />' type="text" onblur="callSum(this);"  tabindex="4"  /></span></a></li>            
            <li><a href="#"><strong>Groceries</strong><span>$<input  id="pay5" name="pay5" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay5}" />' type="text" onblur="callSum(this);"  tabindex="5"  /></span></a></li> 
             <li><a href="#"><strong>Dining</strong><span>$<input  id="pay6" name="pay6" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay6}" />' type="text" onblur="callSum(this);"   tabindex="6" /></span></a></li>
              <li><a href="#"><strong>Car Expenses</strong><span>$<input  id="pay7" name="pay7" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay7}" />' type="text" onblur="callSum(this);"   tabindex="7" /></span></a></li>
               <li><a href="#"><strong>Entertainment</strong><span>$<input  id="pay8" name="pay8" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay8}" />' type="text" onblur="callSum(this);"   tabindex="8" /></span></a></li>
                <li><a href="#"><strong>Child Care</strong><span>$<input  id="pay9" name="pay9" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay9}" />' type="text" onblur="callSum(this);"  tabindex="9"  /></span></a></li>
                 <li><a href="#"><strong>Education</strong><span>$<input  id="pay10" name="pay10" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay10}" />' type="text" onblur="callSum(this);"  tabindex="10" /></span></a></li>
                  <li><a href="#"><strong>Other Living Expenses</strong><span>$<input  id="pay11" name="pay11" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay11}" />' type="text" onblur="callSum(this);"  tabindex="11" /></span></a></li>           
            <li><a href="#"><strong>Other Living Expenses</strong><span>$<input  id="pay12" name="pay12" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.pay12}" />' type="text" onblur="callSum(this);"  tabindex="12" /></span></a></li>            
        </ul>
        <div class="pros cal">
            <h3>SUB TOTAL<span><input  id="total" name="total" readonly="readonly" value= '<fmt:formatNumber type="number" minFractionDigits="2"  value="${personalExpenses.total}" />'  type="text" /></span></h3>            
        </div>
        <input type="button" class="save"    id="saveBtn" />
        <input type="button" class="saveand" id="continue"  />
        </form>
    </article>
    
    
    
       
     
     <%@include file="footer.jsp" %>
</body>
    