var be,pe,di,savings,income,annualIncomeGoal,incomeTax,incomeDesired;
  
 function clearText(e){
	 //e.value="";
 }
 
 
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
	be=formatNumber(document.getElementById("be").value);
	pe=formatNumber(document.getElementById("pe").value);
	di=formatNumber(document.getElementById("di").value);
	savings=formatNumber(document.getElementById("saving").value);
	
	incomeTax=formatNumber(document.getElementById("incomeTax").value);
	
	findSum();
 }
 
 function findSum(){
	/* var businessExp=parseFloat(document.getElementById("be").value);
	 var personalExp=parseFloat(document.getElementById("pe").value);
	 var descIncome=parseFloat(document.getElementById("di").value);
	 var savings=parseFloat(document.getElementById("saving").value);
	 var income=document.getElementById("income");
	 var annualIncomeGoal=document.getElementById("annualIncomeGoal");
	 var incomeTax=document.getElementById("incomeTax").value;
	 var annualIncome=document.getElementById("annualIncome"); */
	 
	  var income=document.getElementById("income");
	 var annualIncomeGoal=document.getElementById("annualIncomeGoal");	
	 var annualIncome=document.getElementById("annualIncome"); 
	 var sum=be+pe+di+savings;
	 income.value=CommaFormatted(sum.toFixed(2));
	 var monthlyGoal=sum;
	 annualIncomeGoal.value=CommaFormatted((monthlyGoal*12).toFixed(2));
	 var annualAmt=monthlyGoal*12;
	 var tax=1-(incomeTax/100);
	 var annualBE=be*12;
	 //var taxedamt=sum+sum*0.3;
	// incomeNeeded.value=taxedamt.toFixed(2);
	 //annualIncome.value=CommaFormatted((annualAmt-be/tax+be).toFixed(2));
	 annualIncome.value=CommaFormatted((((annualAmt-annualBE)/tax)+annualBE).toFixed(2));
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
 
 $(function(){
	$("#continue").click(function(){
				incomeDesired=formatNumber(document.getElementById("annualIncome").value);
			$.ajax({
				type:"POST",
				url:"/agentsuccessplanner/incomeGoalController",
				data:{
						businessExpenses:be,
						personalExpenses:pe,
						decretionaryIncome:di,
						savings:savings,
						annualIncome:incomeDesired
					
					 },
			   success: function(data){
				   location.href='/agentsuccessplanner/commissionController';
		       },
		       error: function (request, status, error) {
		    	   if(error==="Bad Request"){
		    		   alert("Record Already Exists,Go for Edit");
		    		   
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
			incomeDesired=formatNumber(document.getElementById("annualIncome").value);
			$.ajax({
				type:"POST",
				url:"/agentsuccessplanner/incomeGoalController",
				data:{
						businessExpenses:be,
						personalExpenses:pe,
						decretionaryIncome:di,
						savings:savings,
						annualIncome:incomeDesired
					
					 },
			   success: function(data){
				   alert("Saved Successfully");
		       },
		       error: function (request, status, error) {
		    	   if(error==="Bad Request"){
		    		   alert("Record Already Exists,Go for Edit");
		    		   
		    	   }
		    	   else
		           alert("Problem Saving Details, Try Again later");
		       }
			   
			});
		});	
	 });
	  
 function isNumberKey(evt)
 {
    var charCode =  event.keyCode
    if (charCode > 31 && (charCode < 43 || charCode > 57 ) )
       return false;
  
    return true;
 }
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
