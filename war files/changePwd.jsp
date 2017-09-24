<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tcs.ilp.Teamc.servlet.*"%>
<%@page import="com.tcs.ilp.Teamc.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style type="text/css">
 fieldset
  {
    border-color:grey;
    
  }
  .bot{
	text-decoration: none;
	color: blue;
	font-size: 15px; 
	font-family: Times New Roman,verdana,arial;
	font-weight: bold;
	color:#8A2BE2;
	}
	.bot:hover{
		color: 000033;
	  }
</style>
</head>
<body background="bck1.jpg">

   
	<a href="LogOut.html" class="bot" target="_parent" class="bot">Logout</a><br>

 
</head>
<body>
<center>
<form  name="changepaswd" action="controller?name=changepassword" method="post">
	<table>
	<%EmpBean eb= new EmpBean(); %>
	 
				<tr>
					<th colspan="2" align="center" height="50px" >Change Password</th>
				</tr>
				<tr>
					<td align="right">User ID:</td>
					<td align="left"><input type="text" name="userid" readonly="readonly"  value=<%=request.getParameter("userid") %> > </td>
				</tr>
				<tr>
					<td align="right">New Password:</td>
					<td align="left"><input type="password" name="newpassword"  onFocus="err2()"/></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" name="confirmpassword"  onFocus="err3()"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><span id="espan1"></span>.</td>
					<td></td>
				</tr>
				
				<tr>
					<td></td>
					<td align="left"><input type="submit" value="Change Password" onClick="return validate()"></input></td>
					
			</table>
	</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div id="footer" style="color:green">

© 2013-2014 abc Consultancy Services Limited. All Rights Reserved
</center>
</div>
</body>
</html>