var hp,cr,cs,pr,compt;
   
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
   
   function fillData(){
     hp=formatNumber(document.getElementById("hp").value);
	 cr=formatNumber(document.getElementById("cr").value);
	 cs=formatNumber(document.getElementById("cs").value);
	 pr=formatNumber(document.getElementById("pr").value);
     calculations();
   }
  
  
 function clearText(e){
	 
 }
 
 function calculations(){
	 
	 var gc=document.getElementById('gc');
	 var cps=document.getElementById('cps');
	 
	 var cpt=document.getElementById('cpt');
	
 	 
	 var gross=hp*(cr/100);
	 gc.value=CommaFormatted(gross.toFixed(2));
	 var amtperside=(gross.toFixed(2))/2;
	 cps.value=CommaFormatted(amtperside.toFixed(2));
	 var comsplit=amtperside*(cs/100);
	 cpt.value=CommaFormatted(comsplit.toFixed(2));
	 
 }
 
 function callSum(e){
	 if(e.value==""){
		 e.value=0.00;
	 }
	 else{
			var temp=formatNumber(e.value);
			e.value=CommaFormatted(temp.toFixed(2));
		 }
	 fillData();
 }
 function isNumberKey(evt)
 {
    var charCode =  event.keyCode
    if (charCode > 31 && (charCode < 43 || charCode > 57 ) )
       return false;
  
    return true;
 }
 
 
 $(function(){
	$("#continue").click(function(){
	         compt=formatNumber(document.getElementById("cpt").value);
			$.ajax({
				type:"POST",
				url:"/agentsuccessplanner/commissionController",
				data:{
						housePrice:hp,
						commissionRate:cr,
						commissionSplit:cs,
						commissionPerTransaction:compt,
						prospectRatio:pr
					
					 },
			   success: function(data){
				  location.href='/agentsuccessplanner/transactionController';
		       },
		       error: function (request, status, error) {
		    	   if(error==="Bad Request"){
		    		   alert("Please Enter all the Fileds");
		    		   
		    	   }
		    	   else
		           alert("Problem Saving Details, Try Again later");
		       }
			   
			});
		});	
 
 });
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
		
		$("#saveBtn").click(function(){
		         compt=formatNumber(document.getElementById("cpt").value);
				$.ajax({
				type:"POST",
				url:"/agentsuccessplanner/commissionController",
				data:{
						housePrice:hp,
						commissionRate:cr,
						commissionSplit:cs,
						commissionPerTransaction:compt,
						prospectRatio:pr					
					 },
			   success: function(data){
				   alert("Saved Successfully");
		       },
		       error: function (request, status, error) {
		    	   if(error==="Bad Request"){
		    		   alert("Please Enter all the Fileds");
		    		   
		    	   }
		    	   else
		           alert("Problem Saving Details, Try Again later");
		       }
			   
			});
		});	
	 });
	 function CommaFormatted(amount) {
		var delimiter = ","; // replace comma if desired
		var a = amount.split('.',2)
		var d = a[1];
		var i = parseInt(a[0]);
		if(isNaN(i)) { return ''; }
		var minus = '';
		if(i < 0) { minus = '-'; }
		i = Math.abs(i);
		var n = new String(i);
		var a = [];
		while(n.length > 3) {
			var nn = n.substr(n.length-3);
			a.unshift(nn);
			n = n.substr(0,n.length-3);
		}
		if(n.length > 0) { a.unshift(n); }
		n = a.join(delimiter);
		if(d.length < 1) { amount = n; }
		else { amount = n + '.' + d; }
		amount = minus + amount;
		return amount;
	}
 function goHome(){
   location.href='/agentsuccessplanner/homeController';
 }