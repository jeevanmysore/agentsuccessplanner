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
    	<script src="./pages/js/commission.js"></script>
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Calculate Commission</title>
</head>

<body onload="fillData();">
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>Calculate Commission/Transaction</span>
    </div>
    <header></header>
      <article id="main" class="view">
      <form>
        <ul>
            <li><a href="#"><strong>Average Hours Price</strong><span>$<input onkeypress="return isNumberKey(event);" name="housePrice" id="hp"  value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${commission.housePrice}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text"  tabindex="1"/></span></a></li>
            <li><a href="#"><strong>Average Commission (%)</strong><span>%<input  name="commissionRate" id="cr"  onkeypress="return isNumberKey(event);" value='<fmt:formatNumber type="number" minFractionDigits="2" value="${commission.commisionRate}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text" tabindex="2" /></span></a></li>            
            <li><a href="#"><strong>Average Transaction Side Commission</strong><span>$<input readonly="readonly" onkeypress="return isNumberKey(event);" id="gc" type="text" /></span></a></li>            
          <!--   <li><a href="#"><strong>Average Commission per side</strong><span>$<input readonly="readonly"  onkeypress="return isNumberKey(event);" id="cps" type="text" /></span></a></li>      -->       
              <input readonly="readonly"  onkeypress="return isNumberKey(event);" id="cps" type="hidden" />
            <li><a href="#"><strong>Your Commission per split(%)</strong><span>%<input   id="cs" onkeypress="return isNumberKey(event);"  value='<fmt:formatNumber type="number" minFractionDigits="2" groupingUsed="false" value="${commission.commisionSplit}" />'  onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text" tabindex="3" /></span></a></li>            
            <li><a href="#"><strong>Enter your prospect to Sales Ratio</strong><span>%<input  onkeypress="return isNumberKey(event);" name="prospectRatio" id="pr"   value='<fmt:formatNumber type="number" minFractionDigits="2" groupingUsed="false" value="${commission.prospectusRatio}" />' onclick="clearText(this);" onfocus="clearText(this);" onblur="callSum(this);" type="text" tabindex="4" /></span></a></li>            
        </ul>
        <div class="pros cal">
            <h3>Commission/Transaction<span>$<input  id="cpt" name="cpt" readonly="readonly" value= '<fmt:formatNumber type="number" minFractionDigits="2"  value="${commission.commissionPerTransaction}" />'  type="text" tabindex="5"/></span></h3>            
        </div>
        <input type="button" class="save"  id="saveBtn"/>
        <input type="button" class="saveand"   id="continue" />
        </form>
    </article>
    
    
        
     <%@include file="footer.jsp" %>
</body>
    