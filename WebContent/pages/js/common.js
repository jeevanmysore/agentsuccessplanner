

     
      function isNumberKey(evt)
      {
         var charCode =  event.keyCode
         if (charCode > 31 && (charCode < 45 || charCode > 57 ) )
            return false;
       
         return true;
      }
