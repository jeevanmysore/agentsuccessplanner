var salesPrice;
		var commission;
		$(function() {
			$( "#datepicker" ).datepicker({
				showOn: "button",
				buttonImage: "pages/images/date_icon.png",
				buttonImageOnly: true
			});
		});
		function formatNumber(number){		
			number       = number.toString(); 
			var simpleNumber = '';  
			// Strips out the dollar sign and commas. 
			for (var i = 0; i < number.length; ++i) 
			{ 
				if ("0123456789.".indexOf(number.charAt(i)) >= 0) 
					simpleNumber += number.charAt(i); 
			} 		 
			number = parseFloat(simpleNumber); 
			return number;
		}
		
		
		var type;
		function setType(e){
			type=e.value;
		}
		
		$(document).ready(function(){	
			
			
			$('input').live("keypress", function(e) {
		        /* ENTER PRESSED*/
		        if (e.keyCode == 13) {
		            /* FOCUS ELEMENT */
		            var inputs = $(this).parents("form").eq(0).find(":input");
		            var idx = inputs.index(this);

		            if (idx == inputs.length - 1) {
		                inputs[0].select();
		            } else {
		                inputs[idx + 1].focus(); //  handles submit buttons
		                inputs[idx + 1].select();
		            }
		            return false;
		        }
		    });
			
			type=$('#type').val();	
			
			$("#recordBtn").click(function(){
				$.ajax({
					type:"POST",
					url:"/agentsuccessplanner/editTransaction",
					data:{
							id:$('#id1').val(),
							date:$('#datepicker').val(),
							type:type,
							salesPrice:salesPrice,
							commission:commission				
						 },
				   success: function(data){
					   alert("Saved Successfully");
			       },
			       error: function (request, status, error) {
			    	   if(error==="Bad Request"){
			    		   alert("Failed to insert Data");
			    		   
			    	   }
			    	   else
			           alert("Problem Saving Details, Try Again later");
			       }
				   
				});
			});	
			
		 
		 });
		
		function setType(e){
			type=e.value;
		}
		
		function validate(){
			var sales=document.getElementById("salesPrice").value();
			var com=document.getElementById("commission").value();
			
			if(sales==="" || com===""){
				return false;				
			}
			else
				return true;
		}
		function fill(e){
			if(e.value===""){
				e.value=0.0;
			}
			fillData();
			
		}

		function clearText(e){
			
		}
		
		function goHome(){
		location.href='/agentsuccessplanner/homeController';
		}
		function goMobileHome(){
			location.href='/agentsuccessplanner/homeController';
			}
		
		 function isNumberKey(evt)
		 {
			var charCode =  event.keyCode
			if (charCode > 31 && (charCode < 43 || charCode > 57 ) )
			   return false;
		  
			return true;
		 }
		 
		 function fillData(){			
			salesPrice=formatNumber(document.getElementById("salesPrice").value);
			commission=formatNumber(document.getElementById("commission").value);		 
		 }