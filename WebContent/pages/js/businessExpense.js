 var pay1,pay2,pay3,pay4,pay6,pay7,pay8,pay9,pay10;
	 var pay11,pay12,pay13,pay14,pay15,pay16,pay17,pay18,pay19,pay20;
	 var pay21,pay22,pay23,pay24,pay25,pay26,pay27,pay28,pay29,pay30;
	 var pay31,pay32,pay33,pay34,pay35,pay36,pay37,BEtotal;
	 
	 
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
			pay1=formatNumber(document.getElementById("pay1").value);
			pay2=formatNumber(document.getElementById("pay2").value);
			pay3=formatNumber(document.getElementById("pay3").value);
			pay4=formatNumber(document.getElementById("pay4").value);
			pay5=formatNumber(document.getElementById("pay5").value);
			pay6=formatNumber(document.getElementById("pay6").value);
			pay7=formatNumber(document.getElementById("pay7").value);
			pay8=formatNumber(document.getElementById("pay8").value);
			pay9=formatNumber(document.getElementById("pay9").value);
			pay10=formatNumber(document.getElementById("pay10").value);
			pay11=formatNumber(document.getElementById("pay11").value);
			pay12=formatNumber(document.getElementById("pay12").value);
			pay13=formatNumber(document.getElementById("pay13").value);
			pay14=formatNumber(document.getElementById("pay14").value);
			pay15=formatNumber(document.getElementById("pay15").value);
			pay16=formatNumber(document.getElementById("pay16").value);
			pay17=formatNumber(document.getElementById("pay17").value);
			pay18=formatNumber(document.getElementById("pay18").value);
			pay19=formatNumber(document.getElementById("pay19").value);
			pay20=formatNumber(document.getElementById("pay20").value);
			pay21=formatNumber(document.getElementById("pay21").value);
			pay22=formatNumber(document.getElementById("pay22").value);
			pay23=formatNumber(document.getElementById("pay23").value);
			pay24=formatNumber(document.getElementById("pay24").value);
			pay25=formatNumber(document.getElementById("pay25").value);
			pay26=formatNumber(document.getElementById("pay26").value);
			pay27=formatNumber(document.getElementById("pay27").value);
			pay28=formatNumber(document.getElementById("pay28").value);
			pay29=formatNumber(document.getElementById("pay29").value);
			pay30=formatNumber(document.getElementById("pay30").value);
			pay31=formatNumber(document.getElementById("pay31").value);
			pay32=formatNumber(document.getElementById("pay32").value);
			pay33=formatNumber(document.getElementById("pay33").value);
			pay34=formatNumber(document.getElementById("pay34").value);
			pay35=formatNumber(document.getElementById("pay35").value);
			pay36=formatNumber(document.getElementById("pay36").value);
			pay37=formatNumber(document.getElementById("pay37").value);
			
			findSum();	
		}		
	
	
$(function(){
	$("#continue").click(function(){
	 BEtotal=formatNumber(document.getElementById("total").value);
		$.ajax({
			type:"POST",
			url:"/agentsuccessplanner/businessExpController",
			data: {
					pay1:pay1,
					pay2:pay2,
					pay3:pay3,
					pay4:pay4,
					pay5:pay5,
					pay6:pay6,
					pay7:pay7,
					pay8:pay8,
					pay9:pay9,
					pay10:pay10,
					pay11:pay11,
					pay12:pay12,
					pay13:pay13,
					pay14:pay14,
					pay15:pay15,
					pay16:pay16,
					pay17:pay17,
					pay18:pay18,
					pay19:pay19,
					pay20:pay20,
					pay21:pay21,
					pay22:pay22,
					pay23:pay23,
					pay24:pay24,
					pay25:pay25,
					pay26:pay26,
					pay27:pay27,
					pay28:pay28,
					pay29:pay29,
					pay30:pay30,
					pay31:pay31,
					pay32:pay32,
					pay33:pay33,
					pay34:pay34,
					pay35:pay35,
					pay36:pay36,
					pay37:pay37,
					total:BEtotal
				
				 },
		   success: function(data){
			   location.href='/agentsuccessplanner/incomeGoalController';
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
	 BEtotal=formatNumber(document.getElementById("total").value);
		$.ajax({
			type:"POST",
			url:"/agentsuccessplanner/businessExpController",
			data: {
					pay1:pay1,
					pay2:pay2,
					pay3:pay3,
					pay4:pay4,
					pay5:pay5,
					pay6:pay6,
					pay7:pay7,
					pay8:pay8,
					pay9:pay9,
					pay10:pay10,
					pay11:pay11,
					pay12:pay12,
					pay13:pay13,
					pay14:pay14,
					pay15:pay15,
					pay16:pay16,
					pay17:pay17,
					pay18:pay18,
					pay19:pay19,
					pay20:pay20,
					pay21:pay21,
					pay22:pay22,
					pay23:pay23,
					pay24:pay24,
					pay25:pay25,
					pay26:pay26,
					pay27:pay27,
					pay28:pay28,
					pay29:pay29,
					pay30:pay30,
					pay31:pay31,
					pay32:pay32,
					pay33:pay33,
					pay34:pay34,
					pay35:pay35,
					pay36:pay36,
					pay37:pay37,
					total:BEtotal
				
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
 
 function findSum(){		
	
	var total=document.getElementById("total");
	
	
	var sum=pay1+pay2+pay3+pay4+pay5+pay6+pay7+pay8+pay9+pay10+pay11+pay12+pay13+pay14+pay15+pay16+pay17+pay18+pay19+pay20+pay21+pay22+pay23+pay24+pay25+pay26+pay27+pay28+pay29+pay30+pay31+pay32+pay33+pay34+pay35+pay36+pay37;	
	
	total.value=CommaFormatted(sum.toFixed(2));
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
 
 function goHome(){
   location.href='/agentsuccessplanner/homeController';
 }
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