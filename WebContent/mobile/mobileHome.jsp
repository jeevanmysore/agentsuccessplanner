


<%@ include file="header.jsp" %>


<head>
	<link rel="stylesheet" href="./mobile/css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen, mobile" title="main" charset="utf-8">
	<title>Login</title>
</head>

<body>
 <div class="toolbar">
        <a href="#" class="back" onclick="javascript:history.go(-1);"></a>                 
        <a href="#" class="setting"></a>
        <span>LOGIN</span>
    </div>
    <header></header>
   	<h4 align="center" style="color:red">		<% if( request.getAttribute("activation")!=null){
							out.println( request.getAttribute("activation"));
							} %>
						
							<% if( request.getAttribute("password")!=null){
								out.println( request.getAttribute("password"));
								} %>
							 <% if( request.getAttribute("regStatus")!=null){
								out.println( request.getAttribute("regStatus"));
								} %>
	</h4>
    <article id="login">
        <h3 class="title">Already a member?</h3>
        <section>
            <form method="post" action="./loginController">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td>Username<br />
                       <input type="text" value=""  name="username"  required="required" />
                    </td>
                </tr>
                <tr>
                    <td>Password<br />
                        <input type="password" value=""  name="password" required="required" />
                    </td>
                </tr>
                <tr>
                    <td id="sublog">
                        <div>
                            <input type="checkbox" /> Remember Me<br />
                            <a href="../forgetPasswordController">Forgot Password?</a>
                        </div>
                        <input type="submit" value="" />
                    </td>
                </tr>
            </table>   
            </form>                             
        </section>
        <h3 class="title"><a href="./registrationController">Register</a></h3>
    </article>
    
    <%@include file="footer.jsp" %>
    
    
 </body>