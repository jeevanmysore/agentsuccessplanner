<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="pages/css/login.css">
		<title>Login Page</title>
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		
    </head>
    <!-- Body-->
	<body>
		<div class="header">
		 <!-- For LOGO-->
			<div class="logo">
				<img src="pages/images/logo.png" class="logo_img" ></img>			
			</div>
			<div class="logo_subtitle">
				<img src="pages/images/home_title.png" class="logo_subtitle_img" ></img>		
			</div>
			<div class="error_msg">
					<div class="text_error"> 
						 <% if( request.getAttribute("activation")!=null){
							out.println( request.getAttribute("activation"));
							} %>
						
							<% if( request.getAttribute("password")!=null){
								out.println( request.getAttribute("password"));
								} %>
							 <% if( request.getAttribute("regStatus")!=null){
								out.println( request.getAttribute("regStatus"));
								} %>
					</div>
			</div>
			
		</div>
		<!-- For Content---->
			
			<form action="./loginController" method="post" class="content">
			
				<div class="content_top">
					<div class="login">LOGIN
					</div>
				</div>
				<!-- For username and password---->
				<div class="username">
					Username
				</div>
				<input type="text" value="" class="username_input" name="username"  required="required">
				</input>
				
				<div class="password">
					Password
				</div>
				<input type="password" value="" class="password_input" name="password" required="required">
				</input>
				<!-- Rember Me---->
				<div class="Remeber">
					<div class="tick"><input class="tick1" type="radio"></input>
					
					</div>
					<div class="Remeber_text">Remember Me
					</div>
				</div>
				<!-- ForGot password?---->
				<div class="forget">
					<div class="tick2">
					</div>
					<div class="forget_text">
						<a href="./forgetPasswordController">Forgot password?</a>
					</div>
				</div>
				
				<div class="go">
					<div class="go_text"> <input type="submit" name="submit" value="GO" /></div>
				</div>
				<!-------------- For Content Bottom---->
				<div class="content_bottom">
					
						<div class="bottom_img"><a href="./registrationController" class="bottom_img_text">REGISTER</a>
						</div>
				</div>
			</form>
	</body>
</html>
