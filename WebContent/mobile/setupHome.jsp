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
    <title>Setup Home</title>
</head>

<body>
	<div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>        
        <a href="#" class="setting"></a>
        <span>SETUP HOME</span>
    </div>
    
     <header></header>
    <article id="main">
    	<div class="todaymain">
            <h3>Today's Date<span><%= result %></span></h3>
            <div>
                <div class="to1"> Days left in year<span><%=days_left %></span></div>
            </div>
        </div>
        <ul>
           <li><a href="/agentsuccessplanner/personalExpController">Enter Your Monthly Personal Expenses</a></li>
            <li><a href="/agentsuccessplanner/businessExpController">Enter Your Monthly Business Expenses</a></li>
            
            <li><a href="/agentsuccessplanner/incomeGoalController">Set Income Goal</a></li>
          
            <li><a href="/agentsuccessplanner/commissionController">Calculate Commission / Transaction</a></li>
            <li><a href="./userHome.jsp">Home</a></li>
        </ul>
        
    </article>
    
     <%@include file="footer.jsp" %>
</body>