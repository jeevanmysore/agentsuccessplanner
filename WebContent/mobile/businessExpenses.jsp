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
    	<script src="./pages/js/businessExpense.js"></script>
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Business Expenses</title>
</head>

<body onload="fillData();">
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>Enter Your Monthly Business Expenses</span>
    </div>
    <header></header>
    
    
    <article id="main" class="view">
      <form>
        <ul>
            <li><a href="#"><strong>Desk Fee</strong><span>$<input  id="pay1" name="pay1" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay1}" />' type="text" onblur="callSum(this);" tabindex="1" /></span></a></li>
            <li><a href="#"><strong>MLS Dues</strong><span>$<input  id="pay2" name="pay2" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay2}" />' type="text" onblur="callSum(this);"  tabindex="2"  /></span></a></li>            
            <li><a href="#"><strong>MLS Lockbox</strong><span>$<input  id="pay3" name="pay3" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay3}" />' type="text" onblur="callSum(this);"  tabindex="3"  /></span></a></li>            
            <li><a href="#"><strong>Telephone</strong><span>$<input  id="pay4" name="pay4" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay4}" />' type="text" onblur="callSum(this);"   tabindex="4" /></span></a></li>            
            <li><a href="#"><strong>CellPhone</strong><span>$<input  id="pay5" name="pay5" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay5}" />' type="text" onblur="callSum(this);"  tabindex="5" /></span></a></li> 
             <li><a href="#"><strong>Intenet</strong><span>$<input  id="pay6" name="pay6" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay6}" />' type="text" onblur="callSum(this);"  tabindex="6" /></span></a></li>
              <li><a href="#"><strong>Computer Software</strong><span>$<input  id="pay7" name="pay7" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay7}" />' type="text" onblur="callSum(this);"  tabindex="7" /></span></a></li>
               <li><a href="#"><strong>Supplies</strong><span>$<input  id="pay8" name="pay8" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay8}" />' type="text" onblur="callSum(this);"  tabindex="8" /></span></a></li>
                <li><a href="#"><strong>Maintenance</strong><span>$<input  id="pay9" name="pay9" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay9}" />' type="text" onblur="callSum(this);"  tabindex="9" /></span></a></li>
                 <li><a href="#"><strong>Education</strong><span>$<input  id="pay10" name="pay10" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay10}" />' type="text" onblur="callSum(this);"  tabindex="10" /></span></a></li>
                  <li><a href="#"><strong>Car Payment</strong><span>$<input  id="pay11" name="pay11" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay11}" />' type="text" onblur="callSum(this);"  tabindex="11" /></span></a></li>           
           	 <li><a href="#"><strong>Gas and Oil</strong><span>$<input  id="pay12" name="pay12" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay12}" />' type="text" onblur="callSum(this);"  tabindex="12" /></span></a></li>            
        <li><a href="#"><strong>Car Maintenance</strong><span>$<input  id="pay13" name="pay13" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay13}" />' type="text" onblur="callSum(this);"  tabindex="13" /></span></a></li>
            <li><a href="#"><strong>Business Meals</strong><span>$<input  id="pay14" name="pay14" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay14}" />' type="text" onblur="callSum(this);"  tabindex="14" /></span></a></li>            
            <li><a href="#"><strong>Business Entertainment</strong><span>$<input  id="pay15" name="pay15" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay15}" />' type="text" onblur="callSum(this);"  tabindex="15" /></span></a></li>            
            <li><a href="#"><strong>Seminars and Conventions</strong><span>$<input  id="pay16" name="pay16" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay16}" />' type="text" onblur="callSum(this);" tabindex="16"  /></span></a></li>            
            <li><a href="#"><strong>Lead Generation Subscriptions</strong><span>$<input  id="pay17" name="pay17" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay17}" />' type="text" onblur="callSum(this);"  tabindex="17" /></span></a></li> 
             <li><a href="#"><strong>Postcards</strong><span>$<input  id="pay18" name="pay18" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay18}" />' type="text" onblur="callSum(this);"  tabindex="18" /></span></a></li>
              <li><a href="#"><strong>Postage</strong><span>$<input  id="pay19" name="pay19" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay19}" />' type="text" onblur="callSum(this);"  tabindex="19" /></span></a></li>
               <li><a href="#"><strong>Flyers and Brochures</strong><span>$<input  id="pay20" name="pay8" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay20}" />' type="text" onblur="callSum(this);"  tabindex="20" /></span></a></li>
                <li><a href="#"><strong>Signs</strong><span>$<input  id="pay21" name="pay21" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay21}" />' type="text" onblur="callSum(this);" tabindex="21"/></span></a></li>
                 <li><a href="#"><strong>Website</strong><span>$<input  id="pay22" name="pay22" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay22}" />' type="text" onblur="callSum(this);" tabindex="22" /></span></a></li>
                  <li><a href="#"><strong>Internet Marketing</strong><span>$<input  id="pay23" name="pay11" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay23}" />' type="text" onblur="callSum(this);" tabindex="23"/></span></a></li>           
           	 <li><a href="#"><strong>Print Ads</strong><span>$<input  id="pay24" name="pay24" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay24}" />' type="text" onblur="callSum(this);" tabindex="24"/></span></a></li>            
    <li><a href="#"><strong></strong>Legal Services<span>$<input  id="pay25" name="pay25" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay25}" />' type="text" onblur="callSum(this);" tabindex="25"/></span></a></li>
            <li><a href="#"><strong>Accounting Services</strong><span>$<input  id="pay26" name="pay26" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay26}" />' type="text" onblur="callSum(this);" tabindex="26"/></span></a></li>            
            <li><a href="#"><strong>Assistant's Salary/Bonus</strong><span>$<input  id="pay27" name="pay27" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay27}" />' type="text" onblur="callSum(this);" tabindex="27"/></span></a></li>            
            <li><a href="#"><strong>Payroll Taxes</strong><span>$<input  id="pay28" name="pay28" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay28}" />' type="text" onblur="callSum(this);" tabindex="28"/></span></a></li>            
            <li><a href="#"><strong>Transaction Coordinator</strong><span>$<input  id="pay29" name="pay29" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay29}" />' type="text" onblur="callSum(this);" tabindex="29"/></span></a></li> 
             <li><a href="#"><strong>Listing Coordinator</strong><span>$<input  id="pay30" name="pay30" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay30}" />' type="text" onblur="callSum(this);" tabindex="30"/></span></a></li>
              <li><a href="#"><strong>Dues and Subscriptions</strong><span>$<input  id="pay31" name="pay31" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay31}" />' type="text" onblur="callSum(this);" tabindex="31"/></span></a></li>
               <li><a href="#"><strong>License</strong><span>$<input  id="pay32" name="pay32" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay32}" />' type="text" onblur="callSum(this);" tabindex="32"/></span></a></li>
                <li><a href="#"><strong>E and O Insurance</strong><span>$<input  id="pay33" name="pay33" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay33}" />' type="text" onblur="callSum(this);" tabindex="33"/></span></a></li>
                 <li><a href="#"><strong>Industrial Insurance</strong><span>$<input  id="pay34" name="pay34" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay34}" />' type="text" onblur="callSum(this);" tabindex="34" /></span></a></li>
                  <li><a href="#"><strong>Medical Insurance</strong><span>$<input  id="pay35" name="pay35" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay35}" />' type="text" onblur="callSum(this);" tabindex="35"/></span></a></li>           
           	 <li><a href="#"><strong>Disability Insurance</strong><span>$<input  id="pay36" name="pay36" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay36}" />' type="text" onblur="callSum(this);" tabindex="36"/></span></a></li>            
    		<li><a href="#"><strong>Charity</strong><span>$<input  id="pay37" name="pay37" onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.pay37}" />' type="text" onblur="callSum(this);" tabindex="37"/></span></a></li>
        </ul>
        <div class="pros cal">
            <h3>SUB TOTAL<span><input  id="total" name="total" readonly="readonly" value= '<fmt:formatNumber type="number" minFractionDigits="2"  value="${businessExpenses.total}" />'  type="text" /></span></h3>            
        </div>
        <input type="button" class="save"    id="saveBtn" />
        <input type="button" class="saveand" id="continue"  />
        
        </form>
    </article>
    
    
    
       
     
     <%@include file="footer.jsp" %>
</body>
    