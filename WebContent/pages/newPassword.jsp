<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>
<body>
<form method="post" action="./forget">
<table border="0" cellspacing="4" cellpadding="0" align="center"><br />
                          <tr>
                            <td > New Password</td>
                            <td class="field" align="left"><input type="password" class="input" name="newpassword" required="required" autocomplete="off" /></td>
                          </tr>
                          
                          <tr>
                            <td>ConfirmPassword</td>
                            <td class="field" align="left"><input type="password" class="input" name="confirmpassword" required="required" autocomplete="off" /></td>
                          </tr>
                          
                          <tr>
                            <td>&nbsp;</td>
                            <td><input type="submit" value="Submit" /> &nbsp; <input type="reset" value="Reset" /></td>
                          </tr>
                           </table>
                        </form>
</body>
</html>