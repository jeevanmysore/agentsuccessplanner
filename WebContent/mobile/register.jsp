<%@ include file="header.jsp" %>
<head>
	<link rel="stylesheet" href="mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
	<title>Registration</title>
	<script src="./pages/js/register.js"></script>
</head>
<body>
     <div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>                 
        <a href="#" class="setting"></a>
        <span>REGISTER</span>
    </div>
    <header>    </header>
    <h4 align="center" style="color:red">
    	<% if( request.getAttribute("regStatus")!=null){out.println( request.getAttribute("regStatus"));} %>  
		<% if( request.getAttribute("activation")!=null){out.println( request.getAttribute("activation"));} %>
    </h4>	
    <article id="login">
        <h3 class="title">Register Here</h3>
       <form action="./registrationController" method="post"  name="form" onSubmit="return validate()">
        <section>            
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td>Firstname<br />
                      <input type="text" value="" class="username_input"  name="firstName"   onblur="checkName(this);" onfocus="clearNText(this);" autocomplete="off" />
				
				
                    </td>
                </tr>
                <tr>
                    <td>Lastname<br />
                       <input type="text" value="" class="username_input" name="lastName"  onblur="checkLName(this);" onfocus="clearLText(this);" autocomplete="off" />
				
                    </td>
                </tr>
                <tr>
                    <td>Email-Id<br />
                        <input type="text" value="" class="username_input" name="email"  onblur="checkMail(this);" onfocus="clearMText(this);" autocomplete="off" />
				
                    </td>
                </tr>
                <tr>
                    <td>Username<br />
                       <input type="text" value="" class="username_input" name="username"  onblur="checkUser(this);" onfocus="clearUText(this);" on autocomplete="off" />
			 
                    </td>
                </tr>
                <tr>
                    <td>Password<br />
                      <input type="password" value="" class="password_input" name="password"  autocomplete="off" onblur="checkPwd(this);" onfocus="clearPText(this);" />
				
                    </td>
                </tr>
                <tr>
                    <td>
                        What’s your hobby?
                        <ul>
                            <li><input type="radio" name="hobby"  value="reading" />Reading</li>
                            <li><input type="radio"  name="hobby"  value="writing"/>Watching TV</li>
                            <li><input type="radio" name="hobby"  value="watchingTv" />Writing</li>
                            <li><input type="radio" name="hobby"  value="sports" />Sports</li>
                        </ul>
                    </td>
                </tr>
            </table>   
                                      
        </section>
        <h3 class="title"><input type="submit" class="btregis" value=""/><span>Already Registered?  <a href="./mobileHome.jsp">Login</a></span></h3>
        </form>   
    </article>
    
    <%@include file="footer.jsp" %>
    
    
 </body>