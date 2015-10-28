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
	
	Calendar cal = Calendar.getInstance();
	
	int max_days = cal.getMaximum(Calendar.DAY_OF_YEAR);
	int today = cal.get(Calendar.DAY_OF_YEAR);
	int days_left = max_days - today;
	
	
	Date date;  
    String result;  
    SimpleDateFormat formatter;  
    formatter = new SimpleDateFormat("MM/dd/yy");  
    date = new Date();  
    result = formatter.format(date);

%>

<head>
	
	 <link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
    <title>Year Goals</title>
</head>

<body>
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>View This Year's Goals</span>
    </div>
    
     <header></header>
     <article id="main" class="view">
     	<div class="todaymain">
            <h3>Today's Date<span><%= result %></span></h3>
            <div>
                <div class="to1"> Days left in year<span><%=days_left %></span></div>
            </div>
        </div>
        <ul>
            <li><a href="#"><strong>Income Goals in 2013</strong><span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${yearGoals.incomeGoal}" /></span></a></li>
            <li><a href="#"><strong># Transactions needed /2013</strong><span><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.transactionsNeeded}" /></span></a></li>            
            <li><a href="#"><strong>Transactions Closed</strong><span><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.transactionsClosed}" /></span></a></li>            
            <li><a href="#"><strong>Commission Earned (YTD)</strong><span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${yearGoals.commissionEarned}" /></span></a></li>            
            <li><a href="#"><strong>Transaction Needed (Rest of the year)</strong><span><fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="0" value="${yearGoals.yearlyTransaction}" /></span></a></li>            
            <li><a href="#"><strong>Prospects  Needed (Rest of the year)</strong><span><fmt:formatNumber type="number" minFractionDigits="0"  maxFractionDigits="0" value="${yearGoals.annualProspectsRemained}" /></span></a></li>            
        </ul>
        <div class="tip">
            <h3>Tip for the day</h3>
            Make 25 calls to your Sphere
        </div>
        
    </article>
     
     
     
     
     <%@include file="footer.jsp" %>
</body>