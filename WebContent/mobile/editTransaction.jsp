<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.agentplannertool.frontend.transaction.dto.TransactionDto"%><fmt:setLocale value="en_US"/>
<%

	HttpSession ses=request.getSession();
	try{
		String user=ses.getAttribute("user").toString();
	}
	catch(Exception e){
		response.sendRedirect("/agentsuccessplanner/index.jsp");
	}

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

<head>
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    	 <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    	 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
		<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>	
   		 <script src="./pages/js/editTransaction.js"></script>	
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Enter/Edit a Transaction</title>
</head>

<body onload="fillData();">
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>Enter/Edit a Transaction</span>
    </div>
    <header></header>
    
    <article id="main" class="view transaction">
      <form>
        <ul>
        	<input type="hidden" name="id1" id="id1" value="${transactions.id}" />
            <li><a href="#"><strong>Enter Date</strong><span class="date"><input  id="datepicker" name="date" readonly="readonly" class="content_data1_input" value="<%= date %>" type="text" /><img src="./mobile/images/note.png" alt="" /></span></a></li>
            <li><a href="#"><strong>Transaction Type</strong><span>
            
            <%if(transDto.getTrans_type().equalsIgnoreCase("LISTING")){
								%>
            	<select name="type" id="type" onchange="setType(this);" >
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
								
            </span></a></li>            
            <li><a href="#"><strong>Sales Price</strong><span>$<input name="salesPrice" id="salesPrice" value='<fmt:formatNumber type="number" minFractionDigits="2"  maxFractionDigits="2" value="${transactions.salesPrice}" />'  type="text" required="required" onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" tabindex="1" /></span></a></li>            
            <li><a href="#"><strong>Commission Earned</strong><span>$<input  name="commission" id="commission" value='<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactions.commissionEarned}" />' type="text" required="required"  onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" tabindex="2" /></span></a></li>                   
        </ul>
        <div class="edittran">
            <input type="button" value="" id="recordBtn"  class="btedit"/>
            <input type="button" value="" class="bthome" onclick="goMobileHome();"/>
        </div>
        </form>
    </article>
    
    
    
    
     
     <%@include file="footer.jsp" %>
</body>