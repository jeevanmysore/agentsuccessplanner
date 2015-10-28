<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>

<html>
	<head>
	<title>Registration</title>
		<link rel="stylesheet" type="text/css" href="pages/css/common.css">
		<meta name="viewport" content="width=device-width, user-scalable=false "/>
		<script src="./pages/js/register.js"></script>		
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
						<% if( request.getAttribute("regStatus")!=null){out.println( request.getAttribute("regStatus"));} %>  
						<% if( request.getAttribute("activation")!=null){out.println( request.getAttribute("activation"));} %></h2> 					
					</div>
			</div>			
		</div>
		<!-- For Content---->
		
			<form action="./registrationController" method="post" class="content" name="form" onSubmit="return validate()">
				<div class="content_top">
					<div class="login">REGISTER
					</div>
				</div>
				<!-- For username and password---->
				<div class="username">
					Firstname
				</div>
				<input type="text" value="" class="username_input"  name="firstName"   onblur="checkName(this);" onfocus="clearNText(this);" autocomplete="off">
				
				</input>
				
				<div class="username">
					Lastname
				</div>
				<input type="text" value="" class="username_input" name="lastName"  onblur="checkLName(this);" onfocus="clearLText(this);" autocomplete="off">
				</input>
				
				<div class="username">
					Email-Id
				</div>
				<input type="text" value="" class="username_input" name="email"  onblur="checkMail(this);" onfocus="clearMText(this);" autocomplete="off">
				</input>
				
				<div class="username">
					Username
				</div>
				<input type="text" value="" class="username_input" name="username"  onblur="checkUser(this);" onfocus="clearUText(this);" on autocomplete="off">
				</input>
				
				<div class="password">
					Password
				</div>
				<input type="password" value="" class="password_input" name="password"  autocomplete="off" onblur="checkPwd(this);" onfocus="clearPText(this);">
				</input>
				<div class="password">
					What's your Hobby?
				</div>
				<div class="register_radio">
					<label class="hobby"><input type="radio" name="hobby"  value="reading"  class="big"></input>Reading</label>
					<label class="hobby"><input type="radio" name="hobby"  value="writing" class="big"></input>Writing</label>
					<label class="hobby"><input type="radio" name="hobby"  value="watchingTv" class="big"></input>Watching TV</label>
					<label class="hobby"><input type="radio" name="hobby"  value="sports" class="big"></input>Sports</label>
				</div>		
								
				<!-------------- For Content Bottom---->
				<div class="content_bottom">
						<div class="go">
							<div class="go_text"> <input type="submit" name="submit" value="REGISTER"  /></div>
						</div>
						<div class="already">
							<a href="./home.jsp" class="already1" > Already Registered? Login</a>
						</div>
				</div>
				
			
			</div>
			
			
		</form>
		
	</body>
</html>
