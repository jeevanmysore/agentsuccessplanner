var ck_name = /^[A-z]+$/;
			var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/ ;
			var ck_username = /^[A-z0-9_]+$/;			
			var ck_password =  /^[A-Za-z0-9!@#$%^&*()_]+$/;
			
			
			var a=false;
			var b=false;
			var c=false;
			var d=false;
			var f=false;
			
			function checkName(e){
				var name=e.value;
								
				if(name==""){
					e.style.setProperty('color', '#ff0000');
					e.value=" * Name cannot be Empty";
					a=false;
				}
				else if (!ck_name.test(name)){	
					e.style.setProperty('color', '#ff0000');
					e.value=" * enter valid name";
					a=false;
				}
				else
					a=true;
			}
			function checkLName(e){
				var name=e.value;
								
				if(name==""){
					e.style.setProperty('color', '#ff0000');
					e.value=" * Name cannot be Empty";
					f=false;
				}
				else if (!ck_name.test(name)){	
					e.style.setProperty('color', '#ff0000');
					e.value=" * enter valid name";
					f=false;
				}
				else
					f=true;
			}
			
			function checkMail(e){
				var email=e.value;
				if (!ck_email.test(email)){	
					e.style.setProperty('color', '#ff0000');
					e.value=" * enter valid email";
					b=false;
				}
				else
					b=true;
			}
			
			function checkUser(e){
				var user=e.value;
				if (!ck_username.test(user)){	
					e.style.setProperty('color', '#ff0000');
					e.value=" * Special Characters not allowed";
					c= false;
				}
				if(user.length<6){					
					e.style.setProperty('color', '#ff0000');
					e.value="* Atleast 6 Characters required";
					c= false;
				}
				else if(user.length>20){
						e.style.setProperty('color', '#ff0000');
						e.value="* Maximum Characters should 20";
						c= false;
				}
				else
					c= true;
			}
			
			function checkPwd(e){
				
				var pwd=e.value;
				if(pwd.length<6){
					
					e.style.setProperty('color', '#ff0000');
					alert("* Password should be minimum of 6 Characters");
					d= false;
				}
				else if(pwd.length>20){
					e.style.setProperty('color', '#ff0000');
					alert("* Password should be maximum of 20 Characters");
					d= false;
				}
				else
					d= true;
			}
			
			
			function valRadio(btn) {
			    var cnt = -1;
			    for (var i=btn.length-1; i > -1; i--) {
			        if (btn[i].checked) {cnt = i; i = -1;}
			    }
			    if (cnt > -1) return btn[cnt].value;
			    else return null;
			}
			
			
			function validate(){
				var res=valRadio(form.hobby);
				var g=false;
				if (res != null)				
					g=true;				
				if(a==true && b==true && c== true && d==true && f==true && g==true){
					return true;
				}
				else{
					alert("Fill all the Fields");
					return false;
				}
				
				
			}
			
			
			
			function clearNText(e){
				if(a==true){
					e.style.removeProperty('color');
				}				
				else
				{
					e.value="";					
					e.style.removeProperty('color');
				}
			}
			function clearLText(e){
				if(f==true){
					e.style.removeProperty('color');
				}				
				else
				{
					e.value="";					
					e.style.removeProperty('color');
				}
			}

			function clearMText(e){
				if(b==true){
					e.style.removeProperty('color');
				}				
				else
				{
					e.value="";					
					e.style.removeProperty('color');
				}
			}

			function clearUText(e){
				if(c==true){
					e.style.removeProperty('color');
				}				
				else
				{
					e.value="";					
					e.style.removeProperty('color');
				}
			}
				

			function clearPText(e){
				if(d==true){
					e.style.removeProperty('color');
				}				
				else
				{
					e.value="";					
					e.style.removeProperty('color');
				}
			}	
			
			