<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="header.jsp" %>
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
    <title>User Home</title>
</head>

<body>
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>USER HOME</span>
    </div>
         <header></header>
      
    <article id="main">
    	<div class="todaymain">
            <h3>Today's Date<span><%=   result %></span></h3>
            <div>
                <div class="to1"> Days left in year<span><%= days_left %></span></div>
            </div>
        </div>
        <ul>
            <li><a href="/agentsuccessplanner/progressController">View Your Progress</a></li>
            <li><a href="/agentsuccessplanner/weekGoalsController">View This Week's Goals</a></li>
            <li><a href="/agentsuccessplanner/monthGoalsController">View This Month's Goals</a></li>
            <li><a href="/agentsuccessplanner/yearGoalsController">View This Year's Goals</a></li>
            <li><a href="/agentsuccessplanner/setupController">Set Up/Adjust your Goals</a></li>
            <li><a href="/agentsuccessplanner/transactionController">Enter/Edit a Transaction</a></li>
            <li><a href="/agentsuccessplanner/logoutController">Logout</a></li>
        </ul>
        
    </article>
    
     <%@include file="footer.jsp" %>
</body>