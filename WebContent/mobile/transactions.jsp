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
	
	Date date;  
	    String result;  
	    SimpleDateFormat formatter;  
	    formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    date = new Date();  
	    result = formatter.format(date);

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
    	<script src="./pages/js/transactions.js"></script>
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
            <li><a href="#"><strong>Enter Date</strong><span class="date"><input  id="datepicker" name="date" readonly="readonly" class="content_data1_input" value="<%= result %>" type="text" /><img src="./mobile/images/note.png" alt=""  tabindex="1"/></span></a></li>
            <li><a href="#"><strong>Transaction Type</strong><span>
            	<select name="type" id="type" onchange="setType(this);" tabindex="2" >
									<option value="LISTING">LISTING</option>
									<option value="BUY">BUY</option>
								</select>
            </span></a></li>            
            <li><a href="#"><strong>Sales Price</strong><span>$<input class="content_data1_input" value="0.00" name="salesPrice" id="salesPrice"  type="text" required="required" onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" tabindex="3"/></span></a></li>            
            <li><a href="#"><strong>Commission Earned</strong><span>$<input class="content_data1_input" value='<fmt:formatNumber type="number" minFractionDigits="2"  value="${commission}" />' name="commission" id="commission"  type="text" required="required" onkeypress="return isNumberKey(event)" onblur="fill(this);" onclick="clearText(this);" onfocus="clearText(this);" tabindex="4"/></span></a></li>                   
        </ul>
        </form>
        <div class="edittran2">
            <input type="button" value="" id="recordBtn" class="btsale"/>
            <input type="button" value="" class="bthome" onclick="goMobileHome();"/>
        </div>
        <div class="pretran">
            Previous Transactions
        </div>
        <table border="0" cellpadding="0" cellspacing="0" class="tabletran">
            <tr>
                <th>Date</th>
                <th>Type</th>
                <th>Sales Price</th>
                <th>Commission Earned</th>
                <th></th>
            </tr>
           <c:forEach var="transaction" items="${transactions }">
					  <tr>
					    <td><fmt:formatDate value="${transaction.date }" pattern="MM/dd/yyyy"/> </td>
					    <td>${transaction.trans_type }</td>
						<td><fmt:formatNumber type="number" minFractionDigits="2"  value="${transaction.salesPrice}" /></td>
						<td><fmt:formatNumber type="number" minFractionDigits="2"  value="${transaction.commissionEarned}" /></td>
						<td><a href="/agentsuccessplanner/editTransaction?id=${transaction.id}" >EDIT</a> </td>
					 </tr>
					</c:forEach>
            
        </table>
    </article>
    
    
    
    
     
     <%@include file="footer.jsp" %>
</body>