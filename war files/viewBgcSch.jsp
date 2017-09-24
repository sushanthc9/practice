<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tcs.ilp.Teamc.bean.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bck1.jpg">
<h1>BGC Schedule List</h1>
<center>
<form action="defaultHome.html">
<table border="1">
<tr bgcolor="#33CCFF"><th>Candidate&nbspEmpId</th><th>Bgc_admin_id</th><th>Start_Date</th><th>End_Date</th><th>Bgc_test_Status</th>
    </tr>
<% ArrayList<BgcSchBean> al=(ArrayList<BgcSchBean>) request.getAttribute("empList");
for(BgcSchBean eb:al)
{
	
%>
<tr><td><%=eb.getEmpidnum() %></td><td><%=eb.getBgcadmidnum()%></td><td><%=eb.getSdate()%></td>
    <td><%=eb.getEdate() %></td></tr>

<%
	}
%>
</table>
<input type="submit" value="ok"/>
</form>
</center>
<center>
<div id="footer" style="color:green">

© 2013-2014 abc Consultancy Services Limited. All Rights Reserved

</div>
</center>

</body>
</html>